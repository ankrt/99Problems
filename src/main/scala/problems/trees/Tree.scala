package problems.trees

sealed abstract class Tree[+T] {

  def isMirrorOf[V](that: Tree[V]): Boolean
  def isSymmetric: Boolean

}

case object End extends Tree[Nothing] {

  def isMirrorOf[V](that: Tree[V]): Boolean = that == End
  def isSymmetric: Boolean = true

}

case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {

  def isMirrorOf[V](that: Tree[V]): Boolean = ???
  def isSymmetric: Boolean = ???

}


object Node {

  def apply[T](value: T): Node[T] = Node(value, End, End)
  
}

object Tree {

  def balanced[T](n: Int, v: T): Tree[T] = ???

}