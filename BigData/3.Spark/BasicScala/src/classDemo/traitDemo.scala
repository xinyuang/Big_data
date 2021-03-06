package classDemo

object traitDemo {
  def main(args: Array[String]): Unit = {
    var s1 = new Student4(1,"Tom")
    println(s1.id + "\t" + s1.name)
    println(s1.getActionName())
  }
}

trait Human{
  val id:Int
  val name:String
}

trait Action{
  def getActionName():String
}

class Student4(val id:Int, val name:String) extends Human with Action{
  def getActionName():String = "Action is running"
}