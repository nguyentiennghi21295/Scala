package lectures.part2oop

object AbstractDataTypes extends App {

  //abstract can have abstract and non-abstract members
  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    val creatureType: String = "Canine"
    def eat: Unit = println("crunch crunch")
  }

  // traits can have abstract and non-abstract members
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }

  trait ColdBlooded

  //multiple inheritances
  class Crocodile extends Animal with Carnivore with ColdBlooded {
    val creatureType: String = "croc"
    def eat: Unit = print("nom nom nom")
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // traits vs abstract classes
  // 1 - traits do not have constructor  parameters
  // 2 - multiple traits may be inherited by the same class
  // 3 - traits = behaviours, abstract class = "type of thing"
  
}
