package lectures.part2oop
import scala.language.postfixOps


object Inheritance extends App {
  // protected, private, no modifier, public
  // single class inheritance
  // Super class:  reuse parent fields/methods with Super
  sealed class Animal {
    // with private its subclasses can't see the method in this super class
    // with protected, the method can be seen but must be called in the definition of the subclass
    //(accessible within subclasses but not outside subclasses)
    val creatureType = "wild"
    def eat = println("nomnom")
  }

  //Subclass
  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  println(cat crunch)


  // constructors:
  class Person(name: String ,age: Int =0) {
    //def this(name: String) = this(name, 0)
  }
  class Adult (name: String, age: Int, idCard: String) extends Person(name)

  //overriding
  class Dog(override val creatureType: String ) extends Animal {
    override def eat = { super.eat
      println("crunch, crunch")
    }
  }
  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  //type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  println()
  //a method call will always go the most recently overridden version whenever possible
  //Get all the methods in an instance
  val methods = unknownAnimal.getClass.getDeclaredMethods
  for (method <- methods) {
    println(method.getName)
  }
  //prevent overrides
  // 1 - use final on members inside a class (val, var, def)
  // 2 - also preventing extensions of the class
  // 3 - seal the class (sealed) --> extending classes in THIS FILE, but preventing extensions in other files
}
