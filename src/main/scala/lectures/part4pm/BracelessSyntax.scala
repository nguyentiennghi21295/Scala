package lectures.part4pm

object BracelessSyntax {
  // if -expressions
  val anIfExpression = if (2>3) "bigger" else "smaller"

  //java-style
  val anIfExpression_2 =
    if (2> 3) {
      "bigger"
    } else {
      "smaller"
    }

  //compact
  val anIfExpression_3 =
    if (2>3) "bigger"
    else "smaller"

  // scala 3
  val anIfExpression_4 =
    if 2>3 then
      "bigger" //higher indentation than the if part
    else
      "smaller"

  val anIfExpression_5 =
    if 2>3 then
      val result = "bigger"
      result
    else
      val result = "smaller"
      result
  //Scala 3 one-liner
  val anIfExpression_6 = if 2 > 3 then "bigger" else "smaller"

  //for comprehensions
  val aForComprehension = for {
    n <- List(1,2,3)
    s <- List("black", "white")
  } yield s"$n$s"

  //for comprenhensions scala 3

  val aForComprehension2 =
    for
      n <- List(1,2,3)
      s <- List("black", "white")
    yield s"$n$s"

  //pattern matching
  val meaningOfLife = 42
  val aPatternMatch = meaningOfLife match {
    case 1 => "the one"
    case 2 => "double or nothing"
    case _ => "something else"
  }

  // Scala 3
  val aPatternMatch_v2 =
    meaningOfLife match
      case 1 => "the one"
      case 2 => "double or nothing"
      case _ => "something else"

  //methods without braces
  def computeMeaningOfLife(arg:Int): Int =
    val partialResult = 40
    partialResult + 2

  // class definition with significant indentation (same for traits, objects, enums etc.)
  class Animal: //needed to add : to get class definition with significant indentation
    def eat(): Unit =
      println("I'm eating")
    end eat

    def grow(): Unit =
      println("I'm growing")
    end grow

  end Animal //add end for significant indentation obejcts: if, match, for, methods, classes, traits, enums, objects

  // anonymous classes
  val aSpecialAnimal = new Animal:
    override def eat(): Unit = println("I'm special")

  //indentation = strictly-larger indentation
  //3 spaces + 2 tabs > 2 spaces + 2 tabs
  // 3 spaces + 2 tabs > 3 spaces + 1 tab
  // 3 tabs + 2 spaces ??? 2 tabs + 3 spaces

  def main(args: Array[String]): Unit = {
    println(anIfExpression_5)
    println(computeMeaningOfLife(212))
  }

}
