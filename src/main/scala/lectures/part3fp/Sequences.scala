package lectures.part3fp

import scala.util.Random

object Sequences extends App{
  val aSequence = Seq(1,2,3,4)
  println(aSequence)
  // List is a subclass of sequences
  println(aSequence.reverse)
  println(aSequence(2)) //return at a particular index
  println(aSequence ++ Seq(7,5,6)) //concatenation
  println((aSequence ++ Seq(7,5,6)).sorted)

  // Ranges
  val aRange: Seq[Int] = 1 to 10 //a Range from 1 to 10 (10 included)

  println(aRange)
  val aRangeUntil: Seq[Int] = 1 until 10 //a Range from 1 until 10 (10 not included)
  println("aRangeUntil: "+ aRangeUntil)
  aRangeUntil.foreach(println) //1 to 9
  aRange.foreach(println)
  println(1 to 10)
  (1 to 10).foreach(x => println("Hello"))


  //Lists
  val aList = List(1,2,3)
  val prepended = 42 :: aList
  val prepended2 = 42 +: aList
  val pre_append = 42 +: aList :+ 4
  println(prepended)
  println(prepended2)
  println(pre_append)

  val apples5 = List.fill(5)("apple")
  println(apples5)
  println(aList.mkString("-|"))

  //Arrays -default values are 0 for Int, "null" for strings
  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[Int](0)
  println(threeElements)
  threeElements.foreach(println)
  val threeStrings = Array.ofDim[String](3)
  threeStrings.foreach(println)
  //mutation for arrays
  numbers(2)= 0 //update the element at the index "2" to 0
  //numbers.update(2,0) --update is a special method in Scala
  println(numbers.mkString(" "))

  //Arrays and Seqs
  val numbersSeq: Seq[Int] = numbers //conversion is applied here //implicit conversion
  println(numbersSeq)

  //Vectors:
  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)
  //Vectors vs Lists

  val maxRuns = 1000
  val maxCapacity = 1000000
  def getWritetime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity),r.nextInt())
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 /maxRuns
  }
  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  // keeps reference to tail
  // updating an element in the middle takes a long time
  println(getWritetime(numbersList))
  // depth of the tree is small
  // needs to replace an entire 32-element chunk
  println(getWritetime(numbersVector))
}
