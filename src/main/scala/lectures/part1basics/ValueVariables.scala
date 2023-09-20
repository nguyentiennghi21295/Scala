package lectures.part1basics

object ValuesVariablesTypes extends App{
  val x: Int = 42

  // VALs are immutable
  //COMPILER can infer types
  val aString: String = "hello, this is a string"
  val anotherString = "goodbye"
  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 22000
  val along: Long = 542132152131231L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  //variables:
  var aVariable: Int = 4
  aVariable = 5
  println(aVariable)
}
