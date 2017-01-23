package problems.lists

import scala.annotation.tailrec

class SimpleSolutions extends ListProblems {

  def last[A](ls: List[A]): A = ls.last

  def penultimate[A](ls: List[A]): A = ls.init.last

  def nth[A](n: Int, ls: List[A]): Option[A] = (n, ls) match {
    case (_, Nil) => None
    case (`n`, result :: _) => Some(result)
    case (_, _ :: tail) => nth(n - 1, tail)
  }

  def length[A](ls: List[A]): Int = {
    ls.foldLeft(0)((count, _) => count + 1)
  }

  def reverse[A](ls: List[A]): List[A] = {
    ls.foldLeft(List[A]())((result, next) => next :: result)
  }

  def isPalindrome[A](ls: List[A]): Boolean = {
    ls.reverse == ls
  }

  def flatten(ls: List[Any]): List[Any] = ls flatMap {
    case e: List[_] => flatten(e)
    case e => List(e)
  }

  def compress[A](ls: List[A]): List[A] = {
    ls.reverse.foldLeft(List[A]()) { (r, n) =>
      if (r.isEmpty || r.head != n) n :: r
      else r
    }
  }

  def pack[A](ls: List[A]): List[List[A]] = {
    @tailrec def run(result: List[List[A]], remaining: List[A]): List[List[A]] = {
      if (remaining.isEmpty) result
      else {
        val (packed, next) = remaining.span(_ == remaining.head)
        run(List(packed) ++ result, next)
      }
    }
    run(List.empty, ls).reverse
  }

  def encode[A](list: List[A]): List[(Int, A)] = ???
}
