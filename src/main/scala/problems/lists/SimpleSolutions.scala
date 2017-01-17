package problems.lists

import scala.annotation.tailrec

class SimpleSolutions extends ListProblems {

  def last[A](ls: List[A]): A = ls.last

  def penultimate[A](ls: List[A]): A = ls.init.last

  def nth[A](n: Int, ls: List[A]): Option[A] = {
    @tailrec def run(count: Int, remaining: List[A]): Option[A] = {
      if (remaining.isEmpty) None
      else {
        if (count == n) Some(remaining.head)
        else run(count + 1, remaining.tail)
      }
    }
    run(0, ls)
  }

  def length[A](ls: List[A]): Int = ???

  def reverse[A](ls: List[A]): List[A] = ???

  def isPalindrome[A](ls: List[A]): Boolean = ???

  def flatten(ls: List[Any]): List[Any] = ???

  def compress[A](ls: List[A]): List[A] = ???

  def pack[A](ls: List[A]): List[List[A]] = ???

  def encode[A](list: List[A]): List[(Int, A)] = ???
}
