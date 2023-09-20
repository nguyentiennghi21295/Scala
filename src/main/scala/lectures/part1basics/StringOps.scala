package lectures.part1basics

object StringOps extends App {
  val str:String = "Hello, I am learning Scala"
  println(str.charAt(2))
  println(str.substring(7,11))
  str.split(" ").foreach(println)
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.toUpperCase())
  println(str.length)

  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  println('z'+: aNumberString )
  println("z"+: aNumberString )
  println(str.reverse)
  println(str.take(2))
  //scala-specific: String interpolators
  // S-interpolators
  val name = "David"
  val age = 12.0021312
  val greeting =s"Hello, my name is $name, and I am ${age.formatted("%.2f")}"
  println(greeting)
  val greeting1 = s"Hello, my name is $name, and I am ${age+1}"
  println(greeting1)

  val greeting2 = f"Hello, my name is $name, and I am $age%15.15f"
  println(greeting2)
  println("Hello \n BB")
  println(raw"Hello \n BB")
  val escaped = "This is a\nnewline"
  println(raw"$escaped")

}
