package lectures.part2oop

object Object{
  //SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY
  //OBJECTS CAN HAVE VALUES OR VARIABLES OR METHODS DEFINITIONS
  //Objects do not receive parameters
  object Person { //type + its only instance //singleton instance
    // "static"/"class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    //factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }
  class Person (val name: String) {
    // instance-level functionality //regular instance
  }
  //class and object with the sam name are companions

  def main(args: Array[String]): Unit = {
    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object = SINGLETON INSTANCE
    val mary = new Person("Mary")
    val john = new Person("John")
    println(mary == john)

    val person1 = Person
    val person2 = Person
    println(person1 == person2)

    val bobbie = Person(mary,john)
    print(bobbie.name)

    //Scala Applications = Scala object with
    //def main(args: Array[String]): Unit
    }



}
