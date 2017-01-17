package problems.lists

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

  def flatten(ls: List[Any]): List[Any] = ???

  def compress[A](ls: List[A]): List[A] = ???

  def pack[A](ls: List[A]): List[List[A]] = ???

  def encode[A](list: List[A]): List[(Int, A)] = ???
}
