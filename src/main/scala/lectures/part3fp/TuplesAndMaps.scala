package lectures.part3fp
import scala.annotation.tailrec


object TuplesAndMaps extends App{

  //tuples = finite-ordered "lists"
  val aTuple = (2,"hello, Scala") // Tuple2[Int,String] = (Int,String)
  //max 22 elements
  println(aTuple._1) //2
  println(aTuple.copy(_2 = "goodbye Java"))
  println(aTuple.swap) // ("hello, Scala", 2)

  // Maps - keys -> values
  val aMap: Map[String, Int] = Map()

  val phonebook = Map(("Jim",555), "Daniel" -> 789, ("JIM", 9000)).withDefaultValue(-1) //inputs: Tuples or pairing
  // a-> b is syntatic suger for (a,b)
  println(phonebook)
  println(phonebook.contains("Jim")) //return true or false depending on whether that key exists
  println(phonebook("Daniel"))
  println(phonebook("Mary"))

  // add a pairing
  val newPairing = "Mary" -> 541412
  val newPhonebook = phonebook + newPairing //because maps are immutable
  println(newPhonebook)


  //functional on maps
  //map,flatMap,filter
  println(" this is : " + phonebook.map(pair => pair._1.toLowerCase -> pair._2))

  //filterKeys //predicate
  println(phonebook.filterKeys(x => x.startsWith("J")).toMap)
  println(phonebook.filter((x, _) => x.startsWith("J")))


  //mapValues
  println(phonebook.mapValues(number =>"0212" + number * 10).toMap)
  println(phonebook.map((x, y) => x -> ("0212" + y )))

  //conversion to other collections:
  println(phonebook.toList)
  println(List(("Daniel", 555)).toMap)
  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))

  /*
  * 1. What would happen if we had two original entries "Jim" -> 555 and "JIM" -> 900?
      !!!careful with mapping keys

    2. Overly simplified social network based on maps
       Person = String
       - add a person to the network
       - remove
       - friend (mutual)
       - unfriend
       - number of friends of a person
       - person with most friends
       - how many people have NO friends
       - if there is a social connection between two people (direct or not)
  * */
  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]]=
    network + (person -> Set())

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]]= {
    val friendsA = network(a)
    val friendsB = network(b)
    network +(a -> (friendsA + b)) + (b -> (friendsB + a))
  }
  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]]={
      val friendsA = network(a)
      val friendsB = network(b)
      network + (a -> (friendsA - b)) + (b -> (friendsB -a))
  }
  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]]=
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))
    val unfriended = removeAux(network(person), network)
    unfriended - person
  }
  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty,"Bob"),"Mary")
  println(network)
  println(friend(network, "Bob", "Mary"))
  println(unfriend(friend(network, "Bob", "Mary"),"Bob","Mary"))
  println(remove(friend(network, "Bob", "Mary"),"Bob"))

  //Jim, Bob, Marry
  val people =add(add(add(empty, "Bob"),"Mary"),"Jim")
  val jimBob = friend (people, "Bob", "Jim")
  val testNet = friend (jimBob, "Bob", "Mary")
  println(testNet)

  def nFriends(network: Map[String, Set[String]], person: String): Int =
    if (!network.contains(person)) 0
    else network(person).size

  println(nFriends(testNet, "Bob"))

  def mostFriends(network: Map[String, Set[String]]): String =
    network.maxBy(pair => pair._2.size)._1
  println(testNet)
  println(mostFriends(testNet))
  def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int =
    network.count(_._2.isEmpty)
//    network.filter(pair => pair._2.isEmpty).size
//    network.filter((x,_) => network(x).isEmpty).size

  println(nPeopleWithNoFriends(network))
  println(nPeopleWithNoFriends(testNet))

  def socialConnection(network: Map[String, Set[String]], a: String, b: String): Boolean = {
    @tailrec
    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
      if (discoveredPeople.isEmpty) false
      else {
        val person = discoveredPeople.head
        if (person == target) true
        else if (consideredPeople.contains(person)) bfs(target,consideredPeople, discoveredPeople.tail)
        else bfs(target,consideredPeople + person, discoveredPeople.tail ++ network(person))
      }
    }
    bfs(b, Set(), network(a) + a)
  }
  println(testNet)
  println(socialConnection(network, "Mary", "Jim"))

}

