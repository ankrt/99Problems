package problems.util

object Stopwatch {

  def time[R](block: => R): StopwatchResult[R] = {
    val t0 = System.nanoTime()
    val result = block    // call-by-name
    val t1 = System.nanoTime()
    new StopwatchResult[R](result, t1 - t0)
  }

}

class StopwatchResult[R](val result: R, val elapsed: Long)
