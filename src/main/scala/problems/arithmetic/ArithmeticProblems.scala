package problems.arithmetic

trait ArithmeticProblems {

  /** 31 Test whether this number is prime
    *
    * @return true if this number is prime, else false
    */
  def isPrime: Boolean

  /** 33 Test whether this number is coprime to that number
    *
    * Two numbers are coprime if their greatest common divisor is 1
    *
    * @param that number to compare against
    * @return true if the two numbers are coprime, else false
    */
  def isCoprimeTo(that: Int): Boolean

  /** 34 Calculate Euler's totient function
    *
    * Euler's so-called totient function phi(m) is defined as the number of
    * positive integers r (1 <= r <= m) that are coprime to m.
    *
    * @return the totient
    */
  def totient: Int

  /** 35 Determine the prime factors of a given positive integer
    *
    * @return the list of prime factors
    */
  def primeFactors: List[Int]

}

trait ArithmeticCompanion {

  /** 32 Find the greatest common divisor of two numbers
    *
    * @param a first number
    * @param b second number
    * @return the value of the greatest common divisor
    */
  def gcd(a: Int, b: Int): Int

}
