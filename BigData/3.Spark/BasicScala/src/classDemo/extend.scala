package classDemo

object extend {
  def main(args: Array[String]): Unit = {
    var p = new Person("Tom",20)
    println(p.name + '\t' + p.age)
    println(p.sayHello())
    
    var p2:Person = new Employee("Jerry",25,1000)
    println(p2.sayHello())
    
    var p3:Person = new Person("Mary",25){
      override def sayHello():String = "Mary says Hello"
    }
    print(p3.sayHello())
  }
}

class Person(val name:String, val age:Int){
  def sayHello():String = "Hello " + name + " and the age is " + age
}

class Employee(override val name:String, override val age:Int, val salary:Int) extends Person(name,age){
  override def sayHello():String = "Employee says hello"
}