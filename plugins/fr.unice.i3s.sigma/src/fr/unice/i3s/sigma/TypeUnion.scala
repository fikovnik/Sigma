package fr.unice.i3s.sigma

/**
 * Unboxed union types in Scala via the Curry-Howard isomorphism.
 *
 * Implemenmtation based on Miles Sabin's [[http://www.chuusai.com/2011/06/09/scala-union-types-curry-howard/ article]]
 */
object TypeUnion {

  private type ¬[A] = A ⇒ Nothing
  private type ¬¬[A] = ¬[¬[A]]
  
  type ∨[T, U] = ¬[¬[T] with ¬[U]]

  /**
   * Disjunct union type that can be used to form union types such as:
   * {{{
   * [T: (Int |∨| String)#λ]
   * }}}
   *
   */
  type |∨|[T, U] = { type λ[X] = ¬¬[X] <:< (T ∨ U) }

}