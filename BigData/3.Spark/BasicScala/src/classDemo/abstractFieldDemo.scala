package classDemo

object abstractFieldDemo {
  def main(args: Array[String]): Unit = {
    var p:Person1 = new Employee2(123,"Tom")
    println(p.id)   
  }

  
}

abstract class Person1{
  val id:Int
  val name:String
}

abstract class Employee1 extends Person1{
  
}

class Employee2(val id:Int, val name:String) extends Person1{
  // val id:Int
  // val name:String
}