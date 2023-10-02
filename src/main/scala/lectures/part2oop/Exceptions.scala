package lectures.part2oop

object Exceptions extends App {
  val x: String = null
  //println(x.length)

  //Throwing and catching exceptions = exceptions
  //Nothing is a valid substitute for any other data types
  //Exceptions are instances of classes
  //val aWeirdValue: String = throw new NullPointerException
  //Throwable classes extend the throwable class
  //Exception and Error are the major Throwable subtypes
  // 2. How to catch exceptions

  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you")
    else 42

  val potentialFail = try {
    //code that might fail
    getInt(false)
  } catch {
        //e: RuntimeException ==> pattern
        // If there is no catch for the exceptions, there will be some crashes
    case e: RuntimeException => 43
  } finally {
    // code that will get executed NO MATTER WHAT
    // optional
    // does not influence the return type of this expression
    // use finally only for side effects
    println("finally")
  }
  println(potentialFail)

  //3. how to define out own exceptions
  class MyException extends Exception
  val exception = new MyException

  //throw exception

  /*
    1. Crash our programm with an OutOfMemoryError
    2. Crash with SOError
    3. PocketCalculator
      - add(x,y)
      - substract(x,y)
      - multiply(x,y)
      - divide(x,y)

      Throw
        - OverflowException if add(x,y) exceeds Int.MAX_VALUE
        - UnderflowException if substract(x,y) exceeds Int.MIN_VALUE
        - MathCalculationException for division by 0
   */
  // OOM
  //  val array = Array.ofDim(Int.MaxValue)
  // StackOverFlow
//  def infinite: Int = 1 + infinite
//  val noLimit =

  class OverFlowException extends RuntimeException
  class UnderFlowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator {
    def add(x: Int, y: Int) = {
      val result = x + y

      if (x > 0 && y > 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderFlowException
      else result
    }
    def substract (x: Int, y: Int) = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderFlowException
    }

    def multiply(x:Int, y: Int) = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y < 0 && result < 0) throw new OverFlowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderFlowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderFlowException
      else result
    }

    def divide (x:Int, y:Int) = {
      if (y == 0) throw new MathCalculationException
      else x/y
    }
  }
//  println(PocketCalculator.add(Int.MaxValue, 10))
  println(PocketCalculator.divide(2,0))


}
