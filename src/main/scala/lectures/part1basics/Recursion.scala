package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n:Int): Int = {
    if (n <= 1) 1
    else {
      println(s"Computing factorial of $n, I first need factorial of ${n-1}")
      val result = n * factorial(n-1)
      println(s"Computed factorial of $n")
      result
    }
  }
  println(factorial(10))

  @tailrec
  def factHelper(x:Int, accumulator: BigInt): BigInt = {
    if (x <= 1) accumulator
    else factHelper(x-1, x*accumulator)
  }

  println(factHelper(4000,1)) // TAIL RECURSION = use recursive call as the LAST expression
  //WHEN WE NEED LOOPS, USE TAIL RECURSION
  /*
    1. Concatenate a string n times
    2. IsPrime function tail recursive
    3. Fibonacci function, tail recursive

   */
  @tailrec
  def concatenate(words: String, n:Int, accumulator:String = ""):String= {
    if (n<=0) accumulator
    else concatenate(words,n-1, accumulator + words)
  }

  println(concatenate("B",5))

  def isPrime(n:Int): Boolean = {
    @tailrec
    def isPrimeTailRec(t:Int, isStillPrime: Boolean):Boolean=
      if (!isStillPrime) false
      else if (t <=1) true
      else isPrimeTailRec(t-1,n % t != 0 && isStillPrime)

    isPrimeTailRec(n/2,true)
  }
  println(isPrime(4))


  def fibonacci(n:Int):Int={
    @tailrec
    def fibTailRec(i:Int,last:Int, nextToLast:Int):Int = {
      if (i>n) last
      else fibTailRec(i+1, last+nextToLast, last)
    }

    if (n <= 2) 1
    else fibTailRec(3, 1, 1)

  }
  println(fibonacci(8))




  /*
  def fibonacci(n: Int): Int = {
    if (n <= 1) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  println(fibonacci(8))

  */
}
