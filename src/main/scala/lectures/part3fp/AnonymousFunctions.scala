package lectures.part3fp

object AnonymousFunctions extends App {
//  val doubler = (new Function1[Int, Int] {
//    override def apply(x: Int) = x * 2
//  })
  //AnonymousFunction (Lambda)
/*  val doubler:Int => Int = {
  x => x*2
  }*/
  val doubler: Int => Int = x => x * 2
  val adder: (Int, Int) => Int = {
    (a: Int, b: Int) => a + b
  }

  val justDoSomething: () => Int = () => 3
  //careful: need to call with (). Otherwise, it returns the function itself
  println(justDoSomething)
  println(justDoSomething())

  //curly braces with Lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  //More syntactic sugar
  val niceIncrementer: Int => Int =  _ + 1 //equivalent to x => x + 1
  val niceAdder: (Int,Int) => Int = _ + _ //equivalent to (a,b) => a + b
  /*
   1. MyList: replace all FunctionX callls with Lambdas
   2. Rewrite the "special" adder as an anonymous functions
  */
  val superAdd123 = (x: Int) => (y: Int) => x + y
  println(superAdd123(3)(4))
  


}




