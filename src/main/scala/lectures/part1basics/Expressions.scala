package lectures.part1basics

object Expressions extends App{
  val x = 1 + 2 //expression
  println(x)
  println(2+3*4)
  // + - * / & | ^ << >> >>>
  println(1==x)
  // == != > >= < <=
  println(!(1 == x))
  // ! && ||
  var aVariable = 2
  aVariable += 3 // also work with -= *= /=   .... side effects
  println(s"aVariable: $aVariable")

  // Instructions (DO) vs Expressions (VALUE)

  // IF expression
  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3 // IF Expression
  println(aConditionedValue)
  println(if (aCondition) 5 else 3)
  println(1+3)

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  // NEVER WRITE THIS AGAIN
  //EVERYTHING in Scala is an Expression!

  val aWeirdValue = (aVariable = 3)  //Unit ===void
  println(aWeirdValue)
  println(s"aVariable: $aVariable")

  // side effects: println(), whiles, reassigning
  // Code blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z>2) "hello" else "goodbye"
  }
  val someValue = {
    2<3
  }
  println(someValue)

  val someOtherValue = {
    if (someValue) 239 else 986
    42
  }
  println(someOtherValue)
}
