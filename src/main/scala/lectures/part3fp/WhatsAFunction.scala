package lectures.part3fp

object WhatsAFunction extends App {

  // use functions as first-class elements
  // problem: oop

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))
  //function types = Function1[A,B]
  //supports up to 22 parameters
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }
  println(stringToIntConverter("3") + 4)

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  //function types Function2[A,B,R] === (A,B) =>R
  //All Scala functions are objects (or instances of classes derived from function one, two ...)
  /*val adder: Function2[Int, Int, Int] = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }*/

  def concatenator:(String, String) => String = new Function2[String, String, String]{
    override def apply(a: String, b: String): String = a + b
  }
  println(concatenator("Hello ", "Scala"))

  /*
    1. A function which takes 2 strings and concatenates them
    2. Transform the MyPredicate and MyTransformer into function types
    3. define a function which takes an int and returns another functions which takes an int and returns an int
      - what's the type of this function
      - how to do it
   */
  //3. Function1[Int, Function1[Int,Int]
  val supperAdder: Function1[Int, Function1[Int,Int]] = new Function1[Int,Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x +y
    }
  }
  val adder3 = supperAdder(3)
  println(adder3(4))
  println(supperAdder(3)(4)) //curried function


}

trait MyFunction[A, B] {
  def apply(element: A):B
}