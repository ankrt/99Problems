package problems.logic

import scala.annotation.tailrec

class S99Logic(a: Boolean) {
  import S99Logic._

  def and(b: Boolean): Boolean = (a, b) match {
    case (true, true) => true
    case _ => false
  }

  def or(b: Boolean): Boolean = (a, b) match {
    case (true, _) => true
    case (_, true) => true
    case (_, _) => false
  }

  def nand(b: Boolean): Boolean = not(a and b)

  def nor(b: Boolean): Boolean = not(a or b)

  def xor(b: Boolean): Boolean = not(a equ b)

  def impl(b: Boolean): Boolean = not(a) or b

  def equ(b: Boolean): Boolean = (a and b) or (not(a) and not(b))

}

object S99Logic {

  implicit def boolean2S99Logic(a: Boolean): S99Logic = new S99Logic(a)

  def not(a: Boolean): Boolean = a match {
    case true => false
    case _ => true
  }

  def table2(f: (Boolean, Boolean) => Boolean): Unit = {
    println("A\t B\t Result")
    for (i <- List(true, false);
         j <- List(true, false)) {
      print(s"$i\t $j\t ${f(i, j)}\n")
    }
  }

  def gray(n: Int): List[String] = {
    @tailrec def build(count: Int, code: List[String]): List[String] = {
      if (count > n) code
      else {
        val nextCode = (code map { 0 + _ }) ++ (code.reverse map { 1 + _ })
        build(count + 1, nextCode)
      }
    }
    build(1, List(""))
  }

  // TODO: Problem 50 - Huffman code. Looks difficult.

}
