package problems.arithmetic

trait ArithmeticProblems {

  def isPrime: Boolean

  def gcd(a: Int, b: Int): Int

  def isCoprimeTo(that: Int): Boolean

  def totient: Int

  def primeFactors: List[Int]

}
