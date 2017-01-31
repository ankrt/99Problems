package problems.arithmetic

import problems.util.Stopwatch

import scala.annotation.tailrec

class S99Int(val start: Int) extends ArithmeticProblems {
  import S99Int._

  def isPrime: Boolean = {
    primes takeWhile { _ <= start } contains start
  }

  def isCoprimeTo(that: Int): Boolean = {
    gcd(start, that) == 1
  }

  def totient: Int = {
    1 to start count { _ isCoprimeTo start }
  }

  def primeFactors: List[Int] = {
    @tailrec def count(result: List[Int], n: Int, p: Int): List[Int] = {
      if (n % p == 0) count(p :: result, n / p, p)
      else result
    }
    primes.takeWhile { _ <= start }
      .flatMap { count(List.empty, start, _) }
      .toList
  }

  def primeFactorsMultiplicity: Map[Int, Int] = {
    @tailrec def run(result: Map[Int, Int], remaining: List[Int]): Map[Int, Int] = {
      if (remaining.isEmpty) result
      else {
        val current = remaining.head
        val count = if (result contains current) result(current) + 1 else 1
        run(result + (current -> count), remaining.tail)
      }
    }
    run(Map.empty, start.primeFactors)
  }

  def totientImproved: Int = {
    start.primeFactorsMultiplicity.foldLeft(1) { (tot, entry) =>
      entry match {
        case (pf, m) => tot * (pf - 1) * Math.pow(pf, m - 1).toInt
      }
    }
  }

  def goldbach: (Int, Int) = {
    @tailrec def run(current: Int, remaining: Stream[Int]): (Int, Int) = {
      val result = remaining filter { _ + current == start }
      if (result.nonEmpty) (current, result.head)
      else run(remaining.head, remaining.tail)
    }
    val candidates = primes takeWhile { _ < start }
    run(candidates.head, candidates.tail)
  }

}

object S99Int extends ArithmeticCompanion {

  implicit def int2S99Int(i: Int): S99Int = new S99Int(i)

  val primes: Stream[Int] = {
    // TODO: trial division is not good enough
    2 #:: Stream.from(3, 2).filter(i => {
      primes takeWhile { j => j * j <= i } forall { k => i % k > 0 }
    })
  }

  @tailrec def gcd(a: Int, b: Int): Int = (a, b) match {
    case (result, 0) => result
    case (m, n) => gcd(n, m % n)
  }

  def totientCompare: (Long, Long) = {
    def hopefullySlower() = 1 to 10000 foreach { _.totient }
    def hopefullyFaster() = 1 to 10000 foreach { _.totientImproved }

    (Stopwatch.time(hopefullySlower()).elapsed
      , Stopwatch.time(hopefullyFaster()).elapsed)
  }

  def listPrimesInRange(range: Range): List[Int] = {
    (primes dropWhile { _ < range.start } takeWhile { _ <= range.end }).toList
  }

}
