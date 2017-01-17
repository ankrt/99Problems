package problems.lists

import org.scalatest.FlatSpec

abstract class ListProblemsSpec extends FlatSpec {

  abstract def listProblems: ListProblems

  "ListProblems" should "find the last element of a list" in {
    val ls = List(1, 1, 2, 3, 5, 8)
    val answer = listProblems.last(ls)
    assert(answer == 8)
  }

  it should "find the penultimate element of a list" in {
    val ls = List(1, 1, 2, 3, 5, 8)
    val answer = listProblems.penultimate(ls)
    assert(answer == 5)
  }

  it should "find the nth element of a list" in {
    val ls = List(1, 1, 2, 3, 5, 8)
    val answer = listProblems.nth(2, ls)
    assert(answer == 2)
  }

  it should "find the length of a list" in {
    val ls = List(1, 1, 2, 3, 5, 8)
    val answer = listProblems.length(ls)
    assert(answer == 6)
  }

  it should "find the reverse of a list" in {
    val ls = List(1, 1, 2, 3, 5, 8)
    val answer = listProblems.reverse(ls)
    assert(answer == List(8, 5, 3, 2, 1, 1))
  }

  it should "test whether a list is a palindrome" in {
    val ls = List(1, 2, 3, 2, 1)
    val answer = listProblems.isPalindrome(ls)
    assert(answer)
  }

  it should "flatten a nested list structure" in {
    val ls = List(List(1, 1), 2, List(3, List(5, 8)))
    val answer = listProblems.flatten(ls)
    assert(answer == List(1, 1, 2, 3, 5, 8))
  }

  it should "eliminate consecutive duplicate elements in a list" in {
    val ls = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val answer = listProblems.compress(ls)
    assert(answer == List('a, 'b, 'c, 'a, 'd, 'e))
  }

  it should "pack consecutive duplicates of list elements into sublists" in {
    val ls = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val answer = listProblems.pack(ls)
    assert(answer == List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)))
  }

  it should "run-length encode a list" in {
    val ls = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val answer = listProblems.encode(ls)
    assert(answer == List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)))
  }

}
