package classDemo

class Student3(var stuName:String)


object Student3 {
  def apply(name:String) = {
    println("---------using apply method---------")
    new Student3(name)
  }
  
  def main(args: Array[String]): Unit = {
    var s1 = new Student3("Tom")
    println(s1.stuName)
    
    var s2 = Student3("Jerry")
    println(s2.stuName)
  }
}