package lectures.part4pm
import Exercises._

object Allthepatterns extends App {
  // 1 -constants
  val x:Any = "Scala"
  val constants = x match{
    case 1 => "a number"
    case "Scala" => "The Scala"
    case true => "The Truth"
    case Allthepatterns => "A singleton object"
  }

  //2 - match anything
  //2.1 wildcard
  val matchAnything = x match {
    case _ => "what every"
  }

  //2.2 variable: something
  val matchAVariable = x match{
    case something => s"I've found $something"
  }

  // 3 - tuples
  val aTuple = (1,2)
  val matchATuple = aTuple match {
    case (1,1) =>
    case (something, 2) => s"I've found $something"
  }
  println(matchATuple)
  val nestedTuple = (1,(2,3))
  val matchANestedTuple = nestedTuple match {
    case (_, (2,v)) => s"I've found $v nested 2 layer"
  }
  println(matchANestedTuple)
  //PMs can be NESTED!
  //4 - case classes - constructor pattern
  val aList: MyList[Int] = Cons(1, Cons(2,Empty))
  val matchAList = aList match {
    case Empty =>
    case Cons(head, Cons(subhead, subtail)) => s"print subhead: $subhead & subtail : $subtail"
  }
  println(matchAList)

  // 5 - list patterns
  val aStandardList = List(1,2,3,28)
  val standardListMatching = aStandardList match {
    case List(1,_,_,_) => //extractor - advanced
    case List(1, _*) => //list of arbitrary length -advanced
    case 1 :: List(_) => //infix pattern
    case List(1,2,3) :+ 42 => //infix pattern
  }
  //6 - type specifiers
  val unknown: Any = List(2,3,4)
  val unknownMatch = unknown match{
    case list: List[Int] => println(f"this is a list $list")//explicit
    case _ =>
  }

  //7 - name binding
  val nameBindingMatch = aList match {
    case nonEmptyList @ Cons(_,_) => //name binding => use the name later(here)
    case Cons(1, rest @Cons(2, _)) => //name binding inside nested patterns
  }

  //8 - multi-patterns
  val multiPatterns = aList match {
    case Empty | Cons(0, _) => println("List is empty or starts with 0")
    case _ => println("Whatever")
  }

  //9 - if guards
  val secondElementSpacial = aList match {
    case Cons(_,Cons(specialElement,_)) if specialElement%2 == 0 => println("There is the second element matching %2")
  }

  // All.
  /*Questions*/

  val numbersList = List(1,2,3)
  val numbersMatch = numbersList match {
    case listOfStrings: List[String] => "a list of strings" //
    case listOfNumbers: List[Int] => "a list of numbers"
    case _ => ""
  }
  println(numbersMatch) //returns a list of strings
  //JVM trick question
}
