package lectures.part1basics

object CBN_CBV extends App {
  def calledByValue(x:Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }
  println(calledByValue(15L))

  def calledByName(x: => Long) : Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }
  //=> called by Name
  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x:Int, y: => Int) = println(x)
  printFirst(34, infinite())
}
