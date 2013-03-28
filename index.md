---
layout: frontpage
title: Sigma Project
---

## About ##

[Sigma]({{site.githubProject}}) project aims to provide a family of [Scala](http://scala-lang.org) embedded DSLs for model manipulation tasks such as model-to-model and model-to-text transformation, model validation, querying and construction based on the Eclipse Modeling Framework. 

While it started as a quick fix to a problems faced in [OCL](http://en.wikipedia.org/wiki/Object_Constraint_Language) (see the [OCL'12](http://st.inf.tu-dresden.de/OCL2012/preproceedings/09.pdf) paper for more details) it focuses towars much more ambitions goal...

Sigma is used for the implementation of the [ACTRESS](http://fikovnik.net/Actress) project.

_The documentation is under construction_

## Introduction ##

Model manipulation languages and tools play an essential role in _Model-Driven Engineering_ (MDE) by providing support for automating operations such as model validation and transformation.
In the past years, there have been many different technologies proposed to facilitate model manipulation, particularly within the [Eclipse Modeling Framework](http://www.eclipse.org/emf) (EMF), which is one of the most popular meta-modeling framework in the MDE community.

Since the EMF code generator maps the model concepts into Java (e.g. a class in a model becomes a Java class, an attribute becomes an instance variable), developers can use it directly to manipulate any sort of EMF models.
However, a certain loss of abstraction occurs as a result of mapping the modeling concepts into Java, and the lack of certain language constructs such as higher-order functions and type inference makes the code far from being clean and concise.
In general, using _General Purpose Programming Languages_ (GPL) such as Java for model manipulations makes the code less readable and verbose, with the expressed concern being lost among other commands.
This eventually gives rise to accidental complexities.

Indeed, the inability of some GPLs to alleviate this complexity by expressing domain concepts effectively is one of the reasons why a growing number of different model manipulation _Domain-Specific Languages_ (DSL) have been proposed.
These DSLs allow developers to manipulate models using higher-level abstractions resulting in gains in expressiveness and ease of use when compared with the use of GPLs.
Moreover, DSLs enable domain-specific static and dynamic optimizations that would not be possible with a general-purpose compiler and runtime system.

There has been a considerable amount of effort invested in a number of model manipulation languages offered in the EMF eco-system.
For example there are projects implementing the [OMG](http://www.omg.org/spec/OCL/2.0/) model manipulations standards including OCL for model navigation and validation, [QVT](http://www.omg.org/spec/QVT/1.1/) for model-to-model transformation and [MOFM2T](http://www.omg.org/spec/MOFM2T/1.0/) for model-to-text transformation.
An alternative to these standards is provided by the [Epsilon project](http://eclipse.org/epsilon) that builds an extensive family of model manipulation DSLs based on a common expression language.
Another approach is taken by [Kermeta](https://kermeta.org/), in that it provides a single, but more general imperative language to be used to perform all the different model manipulation tasks.
There are also languages that focus on a particular task such as the [ATL](http://www.eclipse.org/atl/) model transformation language.

Traditionally these languages are designed from the ground-up, are being based on some custom infrastructure, and include some level of tool integration within the Eclipse IDE to facilitate their use.
This _external_ DSL approach allows these languages to be independent and offers complete design freedom. 
On the other hand, evolving a new external DSL to a sufficient degree of maturity is an enormous effort.
It requires not only domain knowledge and language development expertise, but also considerable engineering effort particularly to provide solid tool support.

While these DSLs provide state-of-the-art support for model manipulation, they share some difficulties mostly related to the performance and to the limitations of the provided tool support.
The experience we gained while experimenting with some of the aforementioned technologies during the development of an EMF-based MDE toolchain revealed significant problems related to: 

1. poor stability of tool support and performance,
1. limitations in the more specific, but less versatile language constructs, and
1. interoperability issues among the different technologies.

Consequently, these shortcomings resulted in accidental complexities, albeit of a different nature to those associated with the use of GPLs.

We argue that many of these shortcomings are related to scalability, that is, the more the complexity of a modeling problem increases, the more powerful and expressive constructs in the DSLs need to be.
Most of the existing model manipulation DSLs already contain a lot of general programming facilities.
This complicates not only the language specifications and compilers, interpreters and libraries implementation, but also all the other aspects of modern tool support. 
These issues are primarily related to non-functional DSL requirements, and requires significant engineering effort to fix.
In the research arena, this gives rise to situations in which more effort is spent on the engineering part rather than on finding novel approaches to model manipulations.

In this paper we propose an alternative approach that produces DSLs with the expressiveness of the current model manipulation DSLs, while providing good performance and state-of-the-art tool support without requiring a lot of engineering effort.
We use this approach to develop _internal_ DSLs for EMF model manipulation.
In this paper we report on our experience of using [Scala](http://scala-lang.org) as a host language for the internal DSL.
Scala is a statically typed object-oriented and functional programming language that runs on top of a _Java Virtual Machine_ (JVM).
It includes features such as flexible syntax, higher-order functions, implicit definitions and mixin-class compositions.
Together with the seamless integration with EMF, this allows one to realize type-safe internal DSLs that are consistent and have similar features found in existing model manipulation DSLs.
Moreover, we can leverage the state-of-the-art tool support provided by the major tool vendors as well as from the many existing libraries available in the Java and Scala eco-systems.

## Publications ##

* Filip Křikava, Philippe Collet. "[On the Use of an Internal DSL for Enriching EMF Models](http://st.inf.tu-dresden.de/OCL2012/preproceedings/09.pdf)" in Proceedings of the International [Workshop on OCL and Textual Modelling 2012](http://st.inf.tu-dresden.de/OCL2012/) (OCL), Innsbruck, September 2012. 

## Presentation ##

* Filip Křikava. [Enriching EMF Models with Scala (quick overview)](http://www.slideshare.net/krikava/enriching-emf-models-with-scala), EclipseCon'12 Europe Modeling Symposium, October 2012

* Filip Křikava, Philippe Collet. [On the Use of an Internal DSL for Enriching EMF Models](http://www.slideshare.net/krikava/krikava-ocl12), OCL'12 Workshop, September 2012

## Acknowledgement ##

This work is partly funded by the [ANR SALTY project](https://salty.unice.fr/) under contract ANR-09-SEGI-012.

## Contact ##

SIGMA is being developed by the [MODALIS](http://modalis.polytech.unice.fr/) team of [I3S Laboratory](http://www.i3s.unice.fr/I3S/).

For further information, please contact:

* [Philippe Collet](http://www.i3s.unice.fr/~collet/)
* [Filip Křikava](http://fikovnik.net/canape/index.html)
* or visit [SIGMA](https://github.com/fikovnik/Sigma) github project