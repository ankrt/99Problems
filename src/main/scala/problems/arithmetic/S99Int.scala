package problems.arithmetic

class S99Int(val start: Int) extends ArithmeticProblems {

  def isPrime: Boolean = ???

  def gcd(a: Int, b: Int): Int = ???

  def isCoprimeTo(that: Int): Boolean = ???

  def totient: Int = ???

  def primeFactors: List[Int] = ???
}

object S99Int {
  implicit def int2S99Int(i: Int): S99Int = new S99Int(i)
}
