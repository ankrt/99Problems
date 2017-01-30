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

}
