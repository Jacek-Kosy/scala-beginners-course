package lectures.part1basics

import scala.annotation.tailrec

object Functions extends App {

  def aFunction(a: String, b: Int): String =
    a + " " + b

  def aParameterlessFunction(): Int = 42

  def aRepeatedFunction(aString: String, n: Int): String =
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)

  println(aRepeatedFunction("hello", 3))

  // WHEN YOU NEED LOOPS, USE RECURSION

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int =
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    aSmallerFunction(n, n-1)

  def greeting(name: String, age: Int) =
    "Hi, my name is " + name + " and I am " + age + " years old."

  println(greeting("Jacek", 24))

  def factorial(n: Int): Int =
    if (n == 1) n
    else n * factorial(n -1)

  def fibonacci(n: Int): Int =
    if (n == 1 || n == 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)

  println(factorial(5))
  println(fibonacci(10))

  def isPrime(n: Int): Boolean =
      @tailrec
      def isPrimeUntil(t: Int): Boolean =
        if (t <= 1) true
        else n % t != 0 && isPrimeUntil(t - 1)
      isPrimeUntil(n / 2)

  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37 * 17))

}
