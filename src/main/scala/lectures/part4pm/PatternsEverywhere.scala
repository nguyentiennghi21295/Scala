package lectures.part4pm

object PatternsEverywhere extends App{


  //big idea #1
  try {
    //code
  } catch {
    case e: RuntimeException => "runtime exception"
    case npe: NullPointerException => "no pointer exception"
    case _ => "something else"
  }
  // catchse are actually matches
  try {
    // code
  } catch {
    case e => e match {
      case e: RuntimeException => "runtime exception"
      case npe: NullPointerException => "no pointer exception"
      case _ => "something else"
    }
  }

  //big idea #2
  val list = List(1, 2, 3, 4)
  val evenOnes = for {
    x <- list if x % 2 == 0
  } yield 10 * x

  val tuples = List((1, 2), (3, 4))
  val filterTuples = for {
    (first, second) <- tuples
  } yield first * second
  //case classes, :: operators, ...

  //big idea #3
  val tuple = (1, 2, 3)
  val (a, b, c) = tuple
  println(b)
  //multiple value definitions based on PATTERN MATCHING
  // ALL the power
  val head :: tail = list
  println(head)
  println(tail)

  //big idea #4 - NEW
  // partial function literal based on pattern matching
  val mappedList = list.map{
    case v if (v % 2 == 0) => v + " is even"
    case 1  => "the one"
    case _  => "something else"
  }


  val mappedList2 = list.map { x => x match
    case v if v % 2 == 0 => v + " is even"
    case 1 => "the one"
    case _ => "something else"
  }
  println(mappedList)
  println(mappedList2)


}
