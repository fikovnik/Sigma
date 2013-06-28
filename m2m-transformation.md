---
layout: docs
title: Model-to-Model Transformation
---

Inspired by [ETL](http://www.eclipse.org/epsilon/doc/etl/) and [ATL](http://www.eclipse.org/atl/), Sigma provide a dedicated internal DSL that combines imperative features with declarative rule-based execution scheme into a hybrid M2M transformation language.

Currently, there are two flavors of the M2M transformation DSL:

- Reflection-based - using reflection to execute the transformation rules.
- ( _experimental_ ) Type-safe - using regular method invocation to execute the transformation.

## Reflection-based Transformation ##

In reflection based transformation, the rules are represented by methods that are introspected and registered at runtime. Each method representing a rule must start with `rule` prefix and have one of the following signature:

1. `def rule`_Name_`(source: S, target: T [, target2: T2, ..., targetN: Tn]): Unit`

        def ruleClass2Table(cls: Class, tab: Table, pkey: Column) {
          // the instance cls, tab, pkey has been created by the engine
          // ...
        }


1. `def rule`_Name_`(source: S, target: T [, target2: T2, ..., targetN: Tn]): Option[Unit]`

        def ruleProperty2Column4(prop: Property, col: Column) =
          guardedBy {
            // a boolean expression
          } transform {
            // transformation block
          }


1. `def rule`_Name_`(source: S): T`

1. `def rule`_Name_`(source: S): Option[T]`

        def ruleProperty2Column2(prop: Property) = guardedBy {
          // a boolean expression
        } transform {
          // transformation block that is responsible to create and return an EObject
        }

1. `def rule`_Name_`: PartialFunction[S,T]`

        def ruleProperty2Column = partial[Property, Column] {
          case Property(_, name, _, type_ : PrimitiveType, false) =>
            Column(name, type_.name)
        }

where `S` is the type of the `source` element, `T` is the type of the primary `target` element and `T2,...,Tn` are the types of addition targets `target2,...,targetN`.

A rule method corresponds to an ATL/EGL matched rule. It can be further annotated by `@Lazy` to mark a lazy rule and `@Unique` to mark a unique rule. A lazy rule has to be called explicitly and will produce always a new set of targets unless `@Unique` is present in which case it returns always the same targets for a given source.

    @Unique
    @Lazy
    def ruleProperty2Column2(prop: Property)

### Matching Target Elements

During the M2M transformation, there is often the need to relate the target elements that have been already (or can be) transformed from source elements. For this purpose, the DSL provides a unary operator `~` (tilde) that can be applied to both an instance of an EObject and to a collection of EObjects. At runtime, this operator looks up the rule that can convert the source into the target.

The operator is defined using implicit conversions in `RuleMethods` trait:

    implicit class EObjectM2MSupport(that: EObject) {
      def unary_~[B >: Null <: EObject]: B
    }

    implicit class EListM2MSupport(that: EList[_ <: EObject]) {
      def unary_~[B <: EObject]
    }

## Type-safe Transformation ##

The idea behind the type-safe M2M transformation is to resolve the rule scheduling at compile-time as much as possible to reduce the possibility of failures occurring at runtime. Currently, this is an *experimental work-in-progress*.

Similarly to the reflection-based transformation, it represents the transformation rules as methods. Each method must be explicitly registered using following construct:

    implicit val _ruleName = rule(ruleMethod _)

The reason is, that the implicit value will be later used for the `~` operator to relate target elements. This operator is redefined as:

    implicit class EObjectM2MSupport[A <: EObject: ClassTag](that: A) {
      def unary_~[B >: Null <: EObject](implicit rule: Rule[A, B]): B
    }

    implicit class EListM2MSupport[A <: EObject: ClassTag](that: EList[A]) {
      def unary_~[B <: EObject](implicit rule: Rule[A, B])
    }

The advantage is that if there is no such a rule between `S` and `T`, the compiler will complain at compile time with following error:
_"No conversion rule between S and T"_. This message has been defined on the `Rule`:

    @implicitNotFound(msg = "No conversion rule between ${S} and ${T}.")
    trait Rule[S <: EObject, T <: EObject] {
      // ...
    }

This is the same principle that is used in the Scala collection library using the [`CanBuildFrom`](http://www.scala-lang.org/api/current/index.html#scala.collection.generic.CanBuildFrom).

_Note:_ currently, the type-safe transformation is rather experimental and contained in its own package `fr.unice.i3s.sigma.m2m.experimental`. We are currently looking into type macros to alleviate some of the inconveniences such as explicit rule registration and code duplication (for each possible rule method combination, there has to be a `rule` registration methods). 