package problems.lists

import scala.annotation.tailrec

trait ListProblems {

  /** 01 Find the last element of a list
    */
  def last[A](ls: List[A]): A = ls.last

  /** 02 Find the last but one element of a list
    */
  def penultimate[A](ls: List[A]): A = ls.init.last

  /** 03 Find the nth element of a list
    */
  def nth[A](n: Int, ls: List[A]): Option[A] = {
    val normN = if (n < 0) ls.length - Math.abs(n) else n
    @tailrec def run(accumulated: List[A], remaining: List[A]): Option[A] = {
      if (remaining.isEmpty) None
      else {
        if (accumulated.length >= normN) Some(remaining.head)
        else run(remaining.head :: accumulated, remaining.tail)
      }
    }
    run(List.empty, ls)
  }

  /** 04 Find the number of elements of a list
    */
  def length[A](ls: List[A]): Int = {
    ls.foldLeft(0)((count, _) => count + 1)
  }

  /** 05 Reverse a list
    */
  def reverse[A](ls: List[A]): List[A] = {
    ls.foldLeft(List[A]())((result, next) => next :: result)
  }

  /** 06 Test whether a list is a palindrome
    */
  def isPalindrome[A](ls: List[A]): Boolean = {
    ls.reverse == ls
  }

  /** 07 Flatten a nested list structure
    */
  def flatten(ls: List[Any]): List[Any] = ls flatMap {
    case e: List[_] => flatten(e)
    case e => List(e)
  }

  /** 08 Eliminate consecutive duplicates of list elements
    */
  def compress[A](ls: List[A]): List[A] = {
    ls.reverse.foldLeft(List[A]()) { (r, n) =>
      if (r.isEmpty || r.head != n) n :: r
      else r
    }
  }

  /** 09 Pack consecutive duplicates of list elements into sublists
    */
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

  /** 10 Run-length encoding of a list
    */
  def encode[A](ls: List[A]): List[(Int, A)] = {
    pack(ls) map { el => (el.length, el.head) }
  }

  /** 11 Modified run-length encoding
    */
  def encodeModified[A](ls: List[A]): List[Either[(Int, A), A]] = {
    pack(ls) map { el =>
      if (el.length == 1) Right(el.head)
      else Left((el.length, el.head))
    }
  }

  /** 12 Decode a run-length encoded list
    */
  def decode[A](ls: List[(Int, A)]): List[A] = {
    ls flatMap { el => List.fill(el._1)(el._2) }
  }

  /** 13 Run-length encoding of a list (direct solution)
    */
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

  /** 14 Duplicate the elements of a list
    */
  def duplicate[A](ls: List[A]): List[A] = {
    ls flatMap { List.fill(2)(_) }
  }

  /** 15 Duplicate the elements of a list N times
    */
  def duplicateN[A](n: Int, ls: List[A]): List[A] = {
    ls flatMap { List.fill(n)(_) }
  }

  /** 16 Drop every Nth element from a list
    */
  def drop[A](n: Int, ls: List[A]): List[A] = {
    ls zip (Stream from 1) filterNot { _._2 % n == 0 } map { _._1 }
  }

  /** 17 Split a list into two parts
    */
  def split[A](n: Int, ls: List[A]): (List[A], List[A]) = {
    @tailrec def run(left: List[A], right: List[A]): (List[A], List[A]) = {
      if (right.isEmpty || left.length == n) (left.reverse, right)
      else run(right.head :: left, right.tail)
    }
    run(List.empty, ls)
  }

  /** 18 Extract a slice from a list
    */
  def slice[A](i: Int, k: Int, ls: List[A]): List[A] = {
    // not ideal
    ls.zipWithIndex filter { el => el._2 >= i && el._2 < k } map { _._1 }
  }

  /** 19 Rotate a list N places to the left
    */
  def rotate[A](n: Int, ls: List[A]): List[A] = {
    val normalised = if (n < 0) ls.length - Math.abs(n) else n
    val (left, right) = ls splitAt normalised
    right ++ left
  }

  /** 20 Remove the Nth element from a list
    */
  def removeAt[A](n: Int, ls: List[A]): (List[A], A) = {
    val (left, excluded :: right) = ls splitAt n
    (left ++ right, excluded)
  }

  /** 21 Insert an element at a given position into a list
    */
  def insertAt[A](that: A, n: Int, ls: List[A]): List[A] = {
    val (left, right) = ls splitAt n
    left ::: that :: right
  }

  /** 22 Create a list containing all integers within a given range
    */
  def range(start: Int, end: Int): List[Int] = {
    require(end > start)
    @tailrec def run(c: Int, result: List[Int]): List[Int] = {
      if (c < start) result
      else run(c - 1, c :: result)
    }
    run(end, List.empty)
  }

  /** 23 Extract a given number of randomly selected elements from a list
    */
  def randomSelect[A](n: Int, ls: List[A]): List[A] = {
    val rand = util.Random
    @tailrec def run(result: List[A], remaining: List[A]): List[A] = {
      if (result.length == n) result
      else {
        val (next, selected) = removeAt(rand.nextInt(remaining.length), remaining)
        run(selected :: result, next)
      }
    }
    run(List.empty, ls)
  }

  /** 24 Lotto: Draw N different random numbers from the set 1..M
    */
  def lotto(n: Int, m: Int): List[Int] = {
    randomSelect(n, List.range(1, m + 1))
  }

  /** 25 Generate a random permutation of the elements of a list
    */
  def randomPermute[A](ls: List[A]): List[A] = {
    // let's be lazy
    randomSelect(ls.length, ls)
  }

}
