package lectures.part4pm
import scala.util.Random

object PatternMatching extends App{
  //switch on steroids
  val random = new Random
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "the ONE"
    case 2 => "double or nothing"
    case 3 => "third time is the charm"
    case _ => "something else" // _ = wildcard
  }
  println(x)
  println(description)

  //1. Decompose values
  case class Person(name: String, age:Int)
  val bob = Person("Bob", 20)
  //pattern match values or case class
  val greeting = bob match {
    case Person(n, a) if a < 21 => s"Hi, my name is $n and I can't drink in the US"
    case Person(n,a) => s"Hi, my name is $n and I am $a years old"
    case _ => "I don't know who I am"
  }
  println(greeting)
  /*
  1. cases are matched in order: the first pattern matches, it will be returned instead of the others
  2. what if no cases match? MatchError -> necessary to cover all the cases
  3. types of PM expressions: the compiler tries to unify all the types in all the cases
  */

  // PM on saled hierarchies
  sealed class Animal //(helps )
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Terra Nova")
  val animal1: Animal = Parrot("aeaz")
  animal1 match{
    case Dog(someBreed) => println( s"matched a dog the $someBreed")
    case Parrot(someBreed1) => println(s"matched a parrot the $someBreed1")
  }

  //match every
  val isEvent = x match{
    case n if n%2 == 0 => true
    case _ => false
  }
  //Why?! Overkill
  val isEventCond = if (x%2 == 0) true else false
  val isEvenNormal =(x%2 ==0)

//  EXERCISES: simple functions uses PM
// takes an Expr => human readable form

//  Sum(Number(2), Number(3)) => 2+3
//  Sum(Number(2), Number(3), Number(4)) => 2 +3 +4
//  Prod(Sum(Number(2), Number(3), Number(4)), Number(3)) =(2+1) *3
//  Sum(Prod(Number(2), Number(1)), Number(3)) = 2*1 +3

  trait Expr
  case class Number(n:Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  def show(e:Expr): String = e match {
    case Number(n) => s"$n"
    case Sum(e1,e2) => show(e1) + " + " + show(e2)
    case Prod(e1, e2) => {
      def maybeShowParentheses(exp: Expr) = exp match {
        case Prod(_,_) => show(exp)
        case Number(_) => show(exp)
        case _ => "(" + show(exp) +")"
      }
      maybeShowParentheses(e1) + " * " + maybeShowParentheses(e2)
    }
  }

  println(show(Sum(Number(2), Number(3))))
  println(show(Sum(Sum(Number(2), Number(3)), Number(4))))
  println(show(Prod(Sum(Number(2), Number(1)), Number(3))))
  println(show(Prod(Sum(Number(2), Number(1)), Sum(Number(3), Number(4)))))
  println(show(Sum(Prod(Number(2), Number(1)), Number(3))))
}

