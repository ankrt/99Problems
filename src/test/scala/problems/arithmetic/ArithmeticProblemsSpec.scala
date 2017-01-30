package problems.arithmetic

import org.scalatest.FlatSpec
import problems.arithmetic.S99Int._

class ArithmeticProblemsSpec extends FlatSpec {

  "Problem 31" should "test whether a number is prime" in {
    assert(7.isPrime)
    assert(!10.isPrime)
  }

  "Problem 32" should "calculate the GCD of two numbers" in {
    assert(S99Int.gcd(36, 63) == 9)
    assert(S99Int.gcd(54, 24) == 6)
    assert(S99Int.gcd(48, 180) == 12)
  }

  "Problem 33" should "test whether two numbers are coprime" in {
    assert(35 isCoprimeTo 64)
  }

  "Problem 34" should "calculate the totient of a number" in {
    assert(10.totient == 4)
  }

  "Problem 35" should "calculate the prime factors of a number" in {
    val answer = 315.primeFactors
    assert(answer == List(3, 3, 5, 7))
  }

  "Problem 36" should "caclulate the prime factors of a number and their multiplicity" in {
    val answer = 315.primeFactorsMultiplicity
    assert(answer == List((3,2), (5,1), (7,1)))
  }

  "Problem 37" should "improve the method of calculating the totient" in {
    assert(10.totientImproved == 4)
  }

  "Problem 38" should "compare the two totient implementations" in {
    ???
  }

  "Problem 39" should "find the list of prime numbers in a given range" in {
    val answer = S99Int.listPrimesInRange(7 to 31)
    assert(answer == List(7, 11, 13, 17, 19, 23, 29, 31))
  }

  "Problem 40" should "find the two primes that sum to an event integer" in {
    val answer = 28.goldbach
    assert(answer == (5, 23))
  }

}
