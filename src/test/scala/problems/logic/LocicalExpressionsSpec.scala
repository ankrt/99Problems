package problems.logic

import org.scalatest.{Matchers, PropSpec}
import org.scalatest.prop.TableDrivenPropertyChecks

class LocicalExpressionsSpec extends PropSpec
                              with TableDrivenPropertyChecks
                              with Matchers {
  import S99Logic._

  val andProps = Table(
    ("(a, b)", "answer")
    ,((true, true), true)
    ,((true, false), false)
    ,((false, true), false)
    ,((false, false), false)
  )

  property("AND") {
    forAll(andProps) { (input, answer) =>
      (input._1 and input._2) should be (answer)
    }
  }

  val notProps = Table(
    ("a", "answer")
    , (true, false)
    , (false, true)
  )

  property("NOT") {
    forAll(notProps) { (input, answer) =>
      S99Logic.not(input) should be (answer)
    }
  }

  val orProps = Table(
    ("(a, b)", "answer")
    ,((true, true), true)
    ,((true, false), true)
    ,((false, true), true)
    ,((false, false), false)
  )

  property("OR") {
    forAll(orProps) { (input, answer) =>
      (input._1 or input._2) should be (answer)
    }
  }

  val nandProps = Table(
    ("(a, b)", "answer")
    ,((true, true), false)
    ,((true, false), true)
    ,((false, true), true)
    ,((false, false), true)
  )

  property("NAND") {
    forAll(nandProps) { (input, answer) =>
      (input._1 nand input._2) should be (answer)
    }
  }

  val norProps = Table(
    ("(a, b)", "answer")
    ,((true, true), false)
    ,((true, false), false)
    ,((false, true), false)
    ,((false, false), true)
  )

  property("NOR") {
    forAll(norProps) { (input, answer) =>
      (input._1 nor input._2) should be (answer)
    }
  }

  val xorProps = Table(
    ("(a, b)", "answer")
    ,((true, true), false)
    ,((true, false), true)
    ,((false, true), true)
    ,((false, false), false)
  )

  property("XOR") {
    forAll(xorProps) { (input, answer) =>
      (input._1 xor input._2) should be (answer)
    }
  }

  val implProps = Table(
    ("(a, b)", "answer")
    ,((true, true), true)
    ,((true, false), false)
    ,((false, true), true)
    ,((false, false), true)
  )

  property("IMPL") {
    forAll(implProps) { (input, answer) =>
      (input._1 impl input._2) should be (answer)
    }
  }

  val equProps = Table(
    ("(a, b)", "answer")
    ,((true, true), true)
    ,((true, false), false)
    ,((false, true), false)
    ,((false, false), true)
  )

  property("EQU") {
    forAll(equProps) { (input, answer) =>
      (input._1 equ input._2) should be (answer)
    }
  }

}
