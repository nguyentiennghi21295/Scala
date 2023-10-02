package lectures.part2oop

object AnonymousClass extends App {

  abstract class Animal {
    def eat: Unit
  }



  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("hahaha")
  }
  /*
    equivalent with

  class AnonymousClassess$$anon$1 extends Animal {
    override def eat: Unit = println("hahaha")
  }
  val funnyAnimal: Animal = new AnonymousClassess$$anon$1
   */

  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help you?")
  }

  val Jim = new Person( "Jim") {
    override def sayHi: Unit = println(s"Hi, my name is Jim, how can I be of service?")
  }
  println(Jim.sayHi)

  /*
     1. Generic trait MyPredicate[-T] with a little method test(T) ==> Boolean
     2. Generic trait MyTransformer[-A,B] with a method transform(A) => B
     3. MyList:
        - map(transformer) => MyList
        - filter(predicate) => MyList
        - flatMap(transformer from A to MyList[B]) => MyList [B]

        class EvenPredicate extends MyPredicate[Int]
        class StringToIntTransformer extends MyTransformer[String, Int]

        [1,2,3].map(n*2) = [2,4,6]
        [1,2,3,4].filter(n%2) = [2,4]
        [1,2,3].flatMap(n => [n, n+1]) => (1,2,2,3,3,4)
   */
}
