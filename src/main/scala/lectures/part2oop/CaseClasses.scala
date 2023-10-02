package lectures.part2oop

object CaseClasses extends App {
  case class Person(name: String, age: Int)

  // 1. class parameters are fields
  val Jim = new Person("Jim", 34)
  println(Jim.name)
  println(Jim.age)

  // 2. sensible to toString
  // println(instance) = println(instance.toString)
  println(Jim)
  println(Jim.toString)

  // 3. equals and hashCode implemented OOTB
  val Jim2 = new Person("Jim", 34)
  println(Jim == Jim2)

//  4. CaseClasses have handy copy method
//  val Jim3 = Jim.copy()
  val Jim3 = Jim.copy(age = 45)
  println(Jim3)

  // 5. Caseclasses have companion objects
  val thePerson = Person
  val Mary = Person("Mary",23)

  // 6. Case classes are serializable
  // Akka

  // 7. Case classes have extractor patterns = CCs can be used in PATTERN MATCHING

  case object UnitedKingdom {
    def name: String = "the UK of GB and NI"
  }
  /*
    Expand MyList = use case classes and case objects
  */
}


