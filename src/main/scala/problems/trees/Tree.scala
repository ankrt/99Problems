package problems.trees

sealed abstract class Tree[+T] {
  def isMirrorOf[V](that: Tree[V]): Boolean
  def isSymmetric: Boolean
}

case object End extends Tree[Nothing] {
  def isMirrorOf[V](that: Tree[V]): Boolean = that == End
  def isSymmetric: Boolean = true

  override def toString: String = "."
}

case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {

  def isMirrorOf[V](that: Tree[V]): Boolean = ???
  def isSymmetric: Boolean = ???

  override def toString: String = {
    "T(" + value.toString + " " + left.toString + " " + right.toString + ")"
  }

}

object Node {

  def apply[T](value: T): Node[T] = Node(value, End, End)

}

object Tree {

  /**
    * Construct a balanced binary tree.
    *
    * In a balanced binary tree the following property holds for every node:
    * the number of nodes in its left subtree and its right subtree are almost
    * equal, which means their difference is not greater than one.
    *
    * @param nodes the number of nodes to generate
    * @param value the value to put in each node
    * @tparam T the type of the value
    * @return a balanced binary tree
    */
  def balanced[T](nodes: Int, value: T): Tree[T] = nodes match {
    case n if n < 1 => End
    case n if n % 2 == 1 => {
      val subtree = balanced(n / 2, value)
      Node(value, subtree, subtree)
    }
    case n if n % 2 == 0 => {
      val greaterSubtree = balanced((n - 1) / 2, value)
      val lesserSubtree = balanced((n - 1) / 2 + 1, value)
      Node(value, lesserSubtree, greaterSubtree)
    }
  }

}