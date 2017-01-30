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

  /** 36 Determine the prime factors of a given positive integer (2)
    *
    * @return the list of prime factors and their multiplicities
    */
  def primeFactorsMultiplicity: Map[Int, Int]

  /** 37 Totient Improved
    *
    * The output of problem 36 can be used to calculate the totient more
    * efficiently.
    *
    * @return the totient
    */
  def totientImproved: Int

  /** 38 Compare the two methods of calculating Euler's totient function
    *
    */
  def totientCompare(): Unit

  /** 40 Goldbach's conjecture
    *
    * Goldbach's conjecture says that every positive even number greater than 2
    * is the sum of two prime numbers. This function finds the two prime
    * numbers that sum up to a given even integer.
    *
    * @return the pair of integers that sum to this integer
    */
  def goldbach: (Int, Int)


}

trait ArithmeticCompanion {

  /** 32 Find the greatest common divisor of two numbers
    *
    * @param a first number
    * @param b second number
    * @return the value of the greatest common divisor
    */
  def gcd(a: Int, b: Int): Int

  /** 39 List primes in a given range
    *
    * @return the list of primes in the range
    */
  def listPrimesInRange(range: Range): List[Int]

}
