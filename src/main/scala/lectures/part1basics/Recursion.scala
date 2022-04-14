package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else n * factorial(n - 1)

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x < 1) accumulator
      else factHelper(x - 1, x * accumulator) //TAIL RECURSION = use recursive call as the LAST expression

    factHelper(n, 1)
  }

  println(anotherFactorial(50))

  /*
    1. Concatenate a string n times - tail recursive
    2. IsPrime - tail recursive
    3. Fibonacci - tail recursive
  */
  @tailrec
  def concatenate(string: String, n: Int, accumulator: String): String = {
    if (n < 1) accumulator
    else concatenate(string, n - 1, string + accumulator)
  }

  println(concatenate("Polska", 6, ""))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailRec(t - 1, n % t != 0 && isStillPrime)
    }

    isPrimeTailRec(n / 2, true)
  }
  println(isPrime(13))

  def fibonacci(n: Int): Int = {
    @tailrec
    def fibonacciTailrec(i: Int, last: Int, nextToLast: Int): Int =
      if(i <= n) last
      else fibonacciTailrec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fibonacciTailrec(2, 1, 1)
  }
  println(fibonacci(8))
}