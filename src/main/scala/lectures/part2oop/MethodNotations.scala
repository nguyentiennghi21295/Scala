package lectures.part2oop
import scala.language.postfixOps

object MethodNotations extends App {
  class Person (val name: String, favouriteMovie: String, val age:Int = 0) {
    def likes(move: String): Boolean = move == this.favouriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hang out with ${person.name}"
    def unary_! : String = s"$name, what the heck!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favouriteMovie"
    def +(who:String): Person = new Person(s"$name ($who)",favouriteMovie)
    def unary_+ :Person  = new  Person(name, favouriteMovie, age= age + 1)
    def learns(thing: String) = s"${this.name} is learning $thing"
    def learnsScala = this learns "Scala"
    def apply(n:Int):String = s"${this.name} watched $favouriteMovie $n times"
  }
  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  val tom = new Person("Tom", "Flight Club")
  println(mary hangOutWith tom)
  // infix notation = operator notation (working only with methods having one parameter)
  // syntactic sugar
  println(1 * 2)
  println(1.+(2))
  // "operators" in Scala
  // ALL OPERATORS ARE METHODS
  // Akka actors have ! ?


  // prefix notation
  val x = -1 //equivalent with 1.unary_-
  val y = 1.unary_-
  //unary_ prefix only works with - + ~
  println(!mary)
  println(mary.unary_!)

  //postfix notation for methods without parameters
  println(mary.isAlive)
  println(mary isAlive)

  //apply
  println(mary.apply())
  println(mary()) //equivalent

  println((mary + "the rockstar")())
  println((+mary).age)
  println(mary learnsScala)
  println(mary.apply(2))
  /*
  1. Overload the + operator
  mary + "the rockstar" => new prson "Mary (rockstar)"

  2. Add an age to the Person class
    Add a unary + operator => new person with the age + 1
    +mary => mary with the age incrementer
  3. Add a "learns" method in the Person class => "Mary learns Scala"
     Add a leansScala method, calls learns method with "Scala"/
     Use it in postfix notation
  4. Overload the apply method
     marry.apply(2) => "Marry watched Inception 2 times
   */





}


//Class-level functionality (not depending on an instance of a class)