package lectures.part2oop
import Exercises.{Cons, Empty as EmptyList}

import java.sql
//import Exercises._

import java.util.Date
import java.sql.{Date => sqlDate}

object PackagingAndImports extends App {

  //package members are accessible by their simple name
  val writer = new Writer("Daniel","RockTheJVM", 2018)

  //import the package
  //Exercises.Cons = fully-qualified names
  val addList = new Exercises.Cons (1, new Exercises.Cons(2, new Exercises.Cons (3, Exercises.Empty ) ))
//  val addList = new Cons (1, new Cons(2, new Cons (3,  EmptyList) ))

  println(addList)

  //packages are in hierarchy
  //matching folder structure

  //package object
  sayHello
  println(SPEED_OF_LIGHT)

  //imports
  val AddList = EmptyList

  //1. Use fully qualified names
  val date1 = new Date(123, 2,10)
  //automatically choose the first Date import
  val sqlDate = new sql.Date(123, 1,10)

  println(date1)
  println(sqlDate)
  val sqlDate1 = new sqlDate(123, 1,10)
  println(sqlDate1)
  //2. Use aliasing

  //default
  //java.lang - String, Object, Exception
  //scala - Int, Nothing, Function
  //scala.Predef - println, ???
}
