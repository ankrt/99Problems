package problems.lists

import org.scalatest.FlatSpec

abstract class ListProblemsSpec extends FlatSpec {

  def listProblems: ListProblems

  // 1
  "ListProblems" should "find the last element of a list" in {
    val ls = List(1, 1, 2, 3, 5, 8)
    val answer = listProblems.last(ls)
    assert(answer == 8)
  }

  // 2
  it should "find the penultimate element of a list" in {
    val ls = List(1, 1, 2, 3, 5, 8)
    val answer = listProblems.penultimate(ls)
    assert(answer == 5)
  }

  // 3
  it should "find the nth element of a list" in {
    val ls = List(1, 1, 2, 3, 5, 8)
    val answer = listProblems.nth(2, ls)
    assert(answer.get == 2)
  }

  // 4
  it should "find the length of a list" in {
    val ls = List(1, 1, 2, 3, 5, 8)
    val answer = listProblems.length(ls)
    assert(answer == 6)
  }

  // 5
  it should "find the reverse of a list" in {
    val ls = List(1, 1, 2, 3, 5, 8)
    val answer = listProblems.reverse(ls)
    assert(answer == List(8, 5, 3, 2, 1, 1))
  }

  // 6
  it should "test whether a list is a palindrome" in {
    val ls = List(1, 2, 3, 2, 1)
    val answer = listProblems.isPalindrome(ls)
    assert(answer)
  }

  // 7
  it should "flatten a nested list structure" in {
    val ls = List(List(1, 1), 2, List(3, List(5, 8)))
    val answer = listProblems.flatten(ls)
    assert(answer == List(1, 1, 2, 3, 5, 8))
  }

  // 8
  it should "eliminate consecutive duplicate elements in a list" in {
    val ls = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val answer = listProblems.compress(ls)
    assert(answer == List('a, 'b, 'c, 'a, 'd, 'e))
  }

  // 9
  it should "pack consecutive duplicates of list elements into sublists" in {
    val ls = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val answer = listProblems.pack(ls)
    assert(answer == List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)))
  }

  // 10
  it should "run-length encode a list" in {
    val ls = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val answer = listProblems.encode(ls)
    assert(answer == List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)))
  }

  // 11
  it should "modified run-length encoding" in {
    val ls = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val answer = listProblems.encodeModified(ls)
    assert(answer == List(Left((4,'a)), Right('b), Left((2,'c)), Left((2,'a)), Right('d), Left((4,'e))))
  }

  // 12
  it should "decode a run-length encoded list" in {
    val ls = List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
    val answer = listProblems.decode(ls)
    assert(answer == List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  }

  // 13
  it should "run-length encode a list without using previous solutions" in {
    val ls = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val answer = listProblems.encodeDirect(ls)
    assert(answer == List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)))
  }

  // 14
  it should "duplicate the elements of a list" in {
    val ls = List('a, 'b, 'c, 'c, 'd)
    val answer = listProblems.duplicate(ls)
    assert(answer == List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd))
  }

  // 15
  it should "duplicate the elements of a list N times" in {
    val ls = List('a, 'b, 'c, 'c, 'd)
    val answer = listProblems.duplicateN(3, ls)
    assert(answer == List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd))
  }

  // 16
  it should "drop every Nth element from a list" in {
    val ls = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    val answer = listProblems.drop(3, ls)
    assert(answer == List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k))
  }

  // 17
  it should "split a list into two parts" in {
    val ls = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    val answer = listProblems.split(3, ls)
    assert(answer == (List('a, 'b, 'c), List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }

  // 18
  it should "extract a slice from a list" in {
    val ls = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    val answer = listProblems.slice(3, 7, ls)
    assert(answer == List('d, 'e, 'f, 'g))
  }

  // 19
  it should "rotate a list N places to the left" in {
    val ls = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    val forwards = listProblems.rotate(3, ls)
    val backwards = listProblems.rotate(-2, ls)
    assert(forwards == List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c))
    assert(backwards == List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i))
  }

  // 20
  it should "remove the Nth element from a list" in {
    val ls = List('a, 'b, 'c, 'd)
    val answer = listProblems.removeAt(1, ls)
    assert(answer == (List('a, 'c, 'd), 'b))
  }

}
