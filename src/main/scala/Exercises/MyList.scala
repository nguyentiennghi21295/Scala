package Exercises

abstract class MyList[+A] {
  /*
    head = the first element of the list
    tail = the remainder of the list
    isEmpty = is this list empty
    method add(int) => new list with this element added
    toString => a string representation of the list
   */
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  override def toString: String = "[" + printElements +"]"

  def map[B] (transformer: A => B): MyList[B]
  def flatMap[B] (transformer: A => MyList[B]): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]

  //Concatenation
  def ++[B >: A](list: MyList[B]): MyList[B]

  //HOFs
  def foreach(f: A => Unit): Unit
  def sort(compare: (A,A)=> Int): MyList[A]
  def zipWith[B,C](list: MyList[B], zip:(A,B) => C): MyList[C]
  def fold[B](start: B)(operator: (B,A) => B): B
}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  def printElements: String = ""

  // higher-order functions: receiving functions as parameters or
  // return other functions as a result
  def map[B](transformer: Nothing => B): MyList[B] = Empty
  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty
  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  //HOFs
  def foreach(f: Nothing => Unit): Unit = ()
  def sort(compare: (Nothing,Nothing)=> Int) = Empty
  def zipWith[B,C](list: MyList[B], zip:(Nothing,B) => C): MyList[C]  =
    if (!list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else Empty
  def fold[B](start: B)(operator: (B, Nothing) => B): B = start
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail : MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
  def printElements: String =
    if (t.isEmpty) "" + h.toString
    else h.toString + " " + t.printElements

  def filter(predicate: A => Boolean): MyList[A] =
    if (predicate.apply(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  def map[B](transformer: A => B): MyList[B] =
    new Cons(transformer(h), t.map(transformer))

  /*
   [1,2] ++ [3,4,5]
    = new Cons (1, [2] ++ [3,4,5])
    = new Cons (1, new Cons(2, Empty ++ [3,4,5]))
    = new Cons (1, new Cons (2, [3,4,5])
    = new Cons (1, new Cons (2, new Cons(3, new Cons(4, new Cons(5)))))
   */
  //Concatenation
  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)
  /*
  [1,2].flatmap(n => [n, n+1])
  = [1,2] ++ [2].flatmap(n => [n, n+1])
  = [1,2] ++ [2,3] ++ Empty.flatMap(n => [n, n+1])
  = [1,2,2,3] +

  */
  def flatMap[B] (transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)

  //HOFs
  def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  def sort(compare: (A,A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] =
      if (sortedList.isEmpty) new Cons(x,Empty)
      else if (compare(x, sortedList.head) >= 0) new Cons(x, sortedList)
      else new Cons(sortedList.head, insert(x,sortedList.tail))

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }

  def zipWith[B, C](list:MyList[B], zip: (A,B) => C): MyList[C] =
    if (list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else new Cons(zip(h, list.head), t.zipWith(list.tail, zip))

  /*
      [1,2,3].fold(0)(+) = [2,3].fold(1)(+) = [3].fold(3)(+) =[].fold(6)(+) = 6

   */

  def fold[B](start: B)(operator: (B,A) => B): B = {
    t.fold(operator(start, h))(operator)

  }
}

/*
trait MyPredicate[-T] { // T => Boolean
  def test(elem: T): Boolean
}

trait MyTransformer[-A, B] { // A => B
  def transform(elem: A): B
}
*/





object ListTest extends App {
  val listOfIntegers: MyList[Int] = new Cons (1, new Cons(2, new Cons (3, Empty ) ))
  val cloneListOfIntegers: MyList[Int] = new Cons (1, new Cons(2, new Cons (3, Empty ) ))
  val anotherListOfIntegers: MyList[Int] = new Cons(4, new Cons(5,Empty))
  val listOfStrings: MyList[String] = new Cons ("Hello", new Cons ("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)
  println(anotherListOfIntegers.toString)
  println(listOfIntegers.map(_ * 2).toString)
//  println(listOfIntegers.map(elem => elem * 2).toString)
//  println(listOfIntegers.map(new Function1[Int, Int]{
//    override def apply(elem: Int): Int = elem * 2
//  }).toString)

  println(listOfIntegers.filter(_ % 2 == 0
  ).toString)
//  println(listOfIntegers.filter(elem => elem % 2 == 0
//  ).toString)
//  println(listOfIntegers.filter(new Function1[Int, Boolean]{
//    override def apply(elem: Int): Boolean = elem%2 == 0
//  }).toString)

  println((listOfIntegers ++ anotherListOfIntegers).toString)
  println(listOfIntegers.flatMap(new Function1[Int, MyList[Int]] {
    override def apply(elem: Int): MyList[Int] = new Cons(elem, new Cons(elem + 1, Empty))
  }).toString)

  println(cloneListOfIntegers == listOfIntegers)
  listOfIntegers.foreach(println)
  println(listOfIntegers.sort((x,y) => x-y))
  println(anotherListOfIntegers.zipWith(listOfStrings, _ + "-" + _ ))

  println(listOfIntegers.fold(0) (_ + _))

  // for comprehensions
  val combinations = for {
    n <- listOfIntegers
    string <- listOfStrings
  } yield n + "-" + string
  println(for {
    n <- listOfIntegers
    string <- listOfStrings
  } yield n + "-" + string)
}