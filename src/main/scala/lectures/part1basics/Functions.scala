package lectures.part1basics

object Functions extends App{
  def aFunction(a: String, b: Int) = {
    a + " " + b
  }

  println(aFunction("Blue", 1))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())

  def aRepeatedFunction(aString: String, n: Int):String = {
    if (n==1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("BlueBerry", 3))
  // WHEN WE NEED LOOPS, USE RECURSION

  def aFunctionWithSideEffects (aString: String): Unit = println(aString)

  def aBigFunction (n:Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    aSmallerFunction(n,n-1)
  }
  /*
    1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old."
    2. Factorial function 1*2*3*...*n
  */
  def greeting(name: String, age: Int):String = {s"Hi, my name is $name and I am $age years old"}
  println(greeting("BlueBerry",28))
  def factorial(n: Int): BigInt = {
    if (n <= 0)  1
    else factorial(n-1)*n
  }
  println(factorial(20))

  def fibonacci (n: Int): Int = {
    if (n <= 1) 1
    else fibonacci(n-1) + fibonacci(n-2)
  }
  println(fibonacci(8))

  def isPrime(n:Int):Boolean = {
    def isPrimeUnitl(t:Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUnitl(t-1)

    isPrimeUnitl(n/2)
  }
  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37*17))
}
