package problems.lists

trait ListProblems {

  /** 01 Find the last element of a list
    */
  def last[A](ls: List[A]): A

  /** 02 Find the last but one element of a list
    */
  def penultimate[A](ls: List[A]): A

  /** 03 Find the nth element of a list
    */
  def nth[A](n: Int, ls: List[A]): Option[A]

  /** 04 Find the number of elements of a list
    */
  def length[A](ls: List[A]): Int

  /** 05 Reverse a list
    */
  def reverse[A](ls: List[A]): List[A]

  /** 06 Test whether a list is a palindrome
    */
  def isPalindrome[A](ls: List[A]): Boolean

  /** 07 Flatten a nested list structure
    */
  def flatten(ls: List[Any]): List[Any]

  /** 08 Eliminate consecutive duplicates of list elements
    */
  def compress[A](ls: List[A]): List[A]

  /** 09 Pack consecutive duplicates of list elements into sublists
    */
  def pack[A](ls: List[A]): List[List[A]]

  /** 10 Run-length encoding of a list
    */
  def encode[A](ls: List[A]): List[(Int, A)]

  /** 11 Modified run-length encoding
    */
  def encodeModified[A](ls: List[A]): List[Either[(Int, A), A]]

  /** 12 Decode a run-length encoded list
    */
  def decode[A](ls: List[(Int, A)]): List[A]

  /** 13 Run-length encoding of a list (direct solution)
    */
  def encodeDirect[A](ls: List[A]): List[(Int, A)]

  /** 14 Duplicate the elements of a list
    */
  def duplicate[A](ls: List[A]): List[A]

  /** 15 Duplicate the elements of a list N times
    */
  def duplicateN[A](n: Int, ls: List[A]): List[A]

  /** 16 Drop every Nth element from a list
    */
  def drop[A](n: Int, ls: List[A]): List[A]

  /** 17 Split a list into two parts
    */
  def split[A](n: Int, ls: List[A]): (List[A], List[A])

  /** 18 Extract a slice from a list
    */
  def slice[A](i: Int, k: Int, ls: List[A]): List[A]

  /** 19 Rotate a list N places to the left
    */
  def rotate[A](n: Int, ls: List[A]): List[A]

  /** 20 Remove the Nth element from a list
    */
  def removeAt[A](n: Int, ls: List[A]): (List[A], A)

  /** 21 Insert an element at a given position into a list
    */
  def insertAt[A](that: A, n: Int, ls: List[A]): List[A]

  /** 22 Create a list containing all integers within a given range
    */
  def range(from: Int, to: Int): List[Int]

  /** 23 Extract a given number of randomly selected elements from a list
    */
  def randomSelect[A](n: Int, ls: List[A]): List[A]

  /** 24 Lotto: Draw N different random numbers from the set 1..M
    */
  def lotto(n: Int, m: Int): List[Int]

  /** 25 Generate a random permutation of the elements of a list
    */
  def randomPermute[A](ls: List[A]): List[A]

}
