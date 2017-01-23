package problems.lists

import scala.annotation.tailrec

class SimpleSolutions extends ListProblems {

  def last[A](ls: List[A]): A = ls.last

  def penultimate[A](ls: List[A]): A = ls.init.last

  def nth[A](n: Int, ls: List[A]): Option[A] = (n, ls) match {
    case (_, Nil) => None
    case (0, head :: _) => Some(head)
    case (`n`, _ :: tail) => nth(n - 1, tail)
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

  def encode[A](ls: List[A]): List[(Int, A)] = {
    pack(ls) map { el => (el.length, el.head) }
  }

  def encodeModified[A](ls: List[A]): List[Either[(Int, A), A]] = {
    pack(ls) map { el =>
      if (el.length == 1) Right(el.head)
      else Left((el.length, el.head))
    }
  }

  def decode[A](ls: List[(Int, A)]): List[A] = {
    ls flatMap { el => List.fill(el._1)(el._2) }
  }

  def encodeDirect[A](ls: List[A]): List[(Int, A)] = {
    @tailrec def run(result: List[(Int, A)], remaining: List[A]): List[(Int, A)] = {
      if (remaining.isEmpty) result
      else {
        val (packed, next) = remaining.span(_ == remaining.head)
        run((packed.length, packed.head) :: result, next)
      }
    }
    run(List.empty, ls).reverse
  }

  def duplicate[A](ls: List[A]): List[A] = {
    ls flatMap { List.fill(2)(_) }
  }

  def duplicateN[A](n: Int, ls: List[A]): List[A] = {
    ls flatMap { List.fill(n)(_) }
  }

  def drop[A](n: Int, ls: List[A]): List[A] = {
    ls zip (Stream from 1) filterNot { _._2 % n == 0 } map { _._1 }
  }

  def split[A](n: Int, ls: List[A]): (List[A], List[A]) = {
    @tailrec def run(left: List[A], right: List[A]): (List[A], List[A]) = {
      if (right.isEmpty || left.length == n) (left.reverse, right)
      else run(right.head :: left, right.tail)
    }
    run(List.empty, ls)
  }

  def slice[A](i: Int, k: Int, ls: List[A]): List[A] = {
    // not ideal
    ls.zipWithIndex filter { el => el._2 >= i && el._2 < k } map { _._1 }
  }

  def rotate[A](n: Int, ls: List[A]): List[A] = {
    val normalised = if (n < 0) ls.length - Math.abs(n) else n
    val (left, right) = ls splitAt normalised
    right ++ left
  }

  def removeAt[A](n: Int, ls: List[A]): (List[A], A) = {
    val (left, excluded :: right) = ls splitAt n
    (left ++ right, excluded)
  }

  def insertAt[A](that: A, n: Int, ls: List[A]): List[A] = ???

  def range(from: Int, to: Int): List[Int] = ???

  def randomSelect[A](n: Int, ls: List[A]): List[Int] = ???

  def lotto(n: Int, m: Int): List[Int] = ???

  def lotto[A](ls: List[A]): List[A] = ???
}
