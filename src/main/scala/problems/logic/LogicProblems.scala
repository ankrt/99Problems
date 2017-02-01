package problems.logic

trait LogicProblems {

}

trait LogicalExpressions {

  /** Logical AND
    *
    * @param a left comparison
    * @param b right comparison
    * @return true iff a and b are true, else false
    */
  def and(a: Boolean, b: Boolean): Boolean = a match {
    case true => a == b
    case _ => false
  }

  /** Logical NOT
    *
    * @param a element to negate
    * @return not the input
    */
  def not(a: Boolean): Boolean = a match {
    case true => false
    case _ => true
  }

  /** Logical OR
    *
    * @param a left comparison
    * @param b right comparison
    * @return true if any of A or B are true, else false
    */
  def or(a: Boolean, b: Boolean): Boolean = a match {
    case true => true
    case _ => b
  }

  /** Logical NAND
    *
    * @param a left comparison
    * @param b right comparison
    * @return true iff A and B are false, else true
    */
  def nand(a: Boolean, b: Boolean): Boolean = not(and(a, b))

  /** Logical NOR
    *
    * @param a left comparison
    * @param b right comparison
    * @return true iff A and B are false, else false
    */
  def nor(a: Boolean, b: Boolean): Boolean = not(or(a, b))

  /** Logical XOR
    *
    * @param a left comparison
    * @param b right comparison
    * @return true iff one of A and B are true, else false
    */
  def xor(a: Boolean, b: Boolean): Boolean = or(and(a, not(b)), and(not(a), b))

  /** Logical Material Implication
    *
    * @param a left comparison
    * @param b right comparison
    * @return true iff A is not true, or B is true, else false
    */
  def impl(a: Boolean, b: Boolean): Boolean = or(not(a), b)

  /** Test logical Equivalence
    *
    * @param a left comparison
    * @param b right comparison
    * @return true iff A and B are logically equivalent, else false
    */
  def equ(a: Boolean, b: Boolean): Boolean = or(and(a, b), and(not(a), not(b)))

  /** Print a truth table for a given expression
    *
    * @param f logical expression
    */
  def table2(f: (Boolean, Boolean) => Boolean): Unit = {
    println("A\t B\t Result")
    for (i <- List(true, false);
        j <- List(true, false)) {
      print(s"$i\t $j\t ${f(i, j)}\n")
    }
  }

}
