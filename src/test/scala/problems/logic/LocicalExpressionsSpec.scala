package problems.logic

import org.scalatest.{Matchers, PropSpec}
import org.scalatest.prop.TableDrivenPropertyChecks

class LocicalExpressionsSpec extends PropSpec
                              with TableDrivenPropertyChecks
                              with Matchers {

  val andProps = Table(
    ("(a, b)", "result")
    ,((true, true), true)
    ,((true, false), false)
    ,((false, true), false)
    ,((false, false), false)
  )

  property("AND") {
    forAll(andProps) { (input, result) =>
      S99Logic.and(input._1, input._2) should be (result)
    }
  }

  val notProps = Table(
    ("a", "result")
    , (true, false)
    , (false, true)
  )

  property("NOT") {
    forAll(notProps) { (input, result) =>
      S99Logic.not(input) should be (result)
    }
  }

  val orProps = Table(
    ("(a, b)", "result")
    ,((true, true), true)
    ,((true, false), true)
    ,((false, true), true)
    ,((false, false), false)
  )

  property("OR") {
    forAll(orProps) { (input, result) =>
      S99Logic.or(input._1, input._2) should be (result)
    }
  }

  val nandProps = Table(
    ("(a, b)", "result")
    ,((true, true), false)
    ,((true, false), true)
    ,((false, true), true)
    ,((false, false), true)
  )

  property("NAND") {
    forAll(nandProps) { (input, result) =>
      S99Logic.nand(input._1, input._2) should be (result)
    }
  }

  val norProps = Table(
    ("(a, b)", "result")
    ,((true, true), false)
    ,((true, false), false)
    ,((false, true), false)
    ,((false, false), true)
  )

  property("NOR") {
    forAll(norProps) { (input, result) =>
      S99Logic.nor(input._1, input._2) should be (result)
    }
  }

  val xorProps = Table(
    ("(a, b)", "result")
    ,((true, true), false)
    ,((true, false), true)
    ,((false, true), true)
    ,((false, false), false)
  )

  property("XOR") {
    forAll(xorProps) { (input, result) =>
      S99Logic.xor(input._1, input._2) should be (result)
    }
  }

  val implProps = Table(
    ("(a, b)", "result")
    ,((true, true), true)
    ,((true, false), false)
    ,((false, true), true)
    ,((false, false), true)
  )

  property("IMPL") {
    forAll(implProps) { (input, result) =>
      S99Logic.impl(input._1, input._2) should be (result)
    }
  }

  val equProps = Table(
    ("(a, b)", "result")
    ,((true, true), true)
    ,((true, false), false)
    ,((false, true), false)
    ,((false, false), true)
  )

  property("EQU") {
    forAll(equProps) { (input, result) =>
      S99Logic.equ(input._1, input._2) should be (result)
    }
  }

}
