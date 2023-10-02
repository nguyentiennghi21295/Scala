package lectures.part2oop

object generics extends App {
  class MyList[+A] {
    // use the type A
    def add[B >: A](element: B): MyList[B] = ???
    /*
      A = Cat
      B = Animal
     */
  }
  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  class MyMap[Key, Value]
  //trait can be parameterized
  //trait MyList[A]
  //generic methods
  /*
  object MyList {
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]
  */
  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. yes List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ???? HARD QUESTION --> we return a list of animal
  // 2. no = INVARIANCE
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]
  // 3. Hell,no ! Contravariance
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  // bounded types: subclasses of a certain type or superclasses of a certain type
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)




}
