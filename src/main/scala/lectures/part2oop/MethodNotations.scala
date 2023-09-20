package lectures.part2oop

object MethodNotations extends App {
  class Person (val name: String, favouriteMovie: String ) {
    def likes(move: String): Boolean = move == this.favouriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hang out with ${person.name}"
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
  val x = -1
}
