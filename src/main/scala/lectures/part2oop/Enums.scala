package lectures.part2oop

object Enums {
  enum Permissions {
    case READ, WRITE, EXECUTE, NONE

    // add fields/methods
    def openDocument(): Unit =
      if (this == READ) println("Opening document ...")
      else println("reading not allowed")
  }

  val somePermissions: Permissions = Permissions.EXECUTE

  enum PermissionsWithBits(bits: Int){
    case READ extends PermissionsWithBits(4) // 100
    case WRITE extends PermissionsWithBits(2) // 010
    case EXECUTE extends PermissionsWithBits(1) //001
    case NONE extends PermissionsWithBits(0)// 000
  }
  /*
  enum Thing {
  case A(2), B(3)
  }
  */

  object PermissionsWithBits {
    def fromBits(bits:Int): PermissionsWithBits =
      PermissionsWithBits.NONE
  }

  // Standard API
  val somePermissionsOrdinal = somePermissions.ordinal
  val allPermissions = PermissionsWithBits.values // Return an array of all possible values of Enum
  val readPermission: Permissions = Permissions.valueOf("READ")






  //Constructor Arguments
  def main(args: Array[String]): Unit = {
    somePermissions.openDocument()
    println(somePermissionsOrdinal)
    println(allPermissions.map(_.toString).mkString(", "))
    println(readPermission)

  }
}
