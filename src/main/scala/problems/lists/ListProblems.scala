package scala.problems.lists

trait ListProblems {

  /** Find the last element of a list
    */
  def last[A](ls: List[A]): A

  /** Find the last but one element of a list
    */
  def penultimate[A](ls: List[A]): A

  /** Find the nth element of a list
    */
  def nth[A](ls: List[A]): A

  /** Find the number of elements of a list
    */
  def length[A](ls: List[A]): Int

  /** Reverse a list
    */
  def reverse[A](ls: List[A]): List[A]

  /** Test whether a list is a palindrome
    */
  def isPalindrome[A](ls: List[A]): Boolean

  /** Flatten a nested list structure
    */
  def flatten(ls: List[Any]): List[Any]

  /** Eliminate consecutive duplicates of list elements
    */
  def compress[A](ls: List[A]): List[A]

  /** Pack consecutive duplicates of list elements into sublists
    */
  def pack[A](ls: List[A]): List[List[A]]

  /** Run-length encoding of a list
    */
  def encode[A](list: List[A]): List[(Int, A)]
}
