package lectures.part2oop

object OOBasics extends App {
  val person = new Person("John",26)
  println(person.age)
  println(person.name)
  println(person.x)
  println(person.greet("BlueBerry"))
  val BB = new Writer("Blue", "Berry", 1995)
  println(BB.fullname)
  val author = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)
  println(novel.authorAge)
  println(novel.isWrittenBy(BB))

  val counter = new Counter
  counter.increment(-5).print
  counter.increment.increment.increment.print
  counter.increment(10).print
}
//every instantiation invokes the expressions and all side effects within the class


// constructor
class Person(var name:String, val age: Int=0) {
  // body
  val x = 2
  println(1+3)

  def greet(name: String): Unit = println(s"${this.name} says: Hi $name")

  // overloading
  def greet(): Unit = println(s"Hi, I am $name")

  //multiple constructors
}

/*
Novel and a Writer

Writer: first name, surname, year
- method fullname

Novel: name, year of release, author
- authorAge
- isWrittenBy(author)
- copy (new year of release) = new instance of Novel
 */
class Writer(firstname: String, surname: String, val year: Int) {
  def fullname = firstname + " " + surname
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {
  def authorAge = yearOfRelease - author.year
  def isWrittenBy(author: Writer) = author == this.author
  def copy(newYear: Int):Novel = new Novel(name, newYear, author)
}

class Counter(val count: Int= 0) {
  def increment = {
    println("incrementing")
    new Counter(count + 1)
  }

  def decrement = {
    println("decrementing")
    new Counter(count - 1)
  }

  def increment(n:Int): Counter = {
    if (n <= 0) this
    else increment.increment(n-1)
  } //immutability
  def decrement(n:Int): Counter =
    if (n <= 0) this
    else decrement.decrement(n-1)

  def print: Unit = println(count)
}
/*
Counter class
- receives an Int value
- method current count
- method to increment/decrement => new Counter
- overload inc/dec to receive an amount
 */


// class parameters are NOT FIELDS
// to convert to FIELDS, we need to add val or var
// the value definitions or the var definitions inside the class implementations are fields