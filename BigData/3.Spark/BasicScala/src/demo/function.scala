package demo

object function {
  def main(args: Array[String]): Unit = {
    // call by value ： (calculate first and only once)
    // call by name  :=> (every time when the parameter is used, calculate)
    
    // set default value
    def func(name:String="Tom"):String = "Hello " + name
    println(func("Marry"))
    println(func())
    
  
    def func1(name:String="Tom",age:Int=20)= name + " is " + age
    println(func1())
    println(func1(age = 1))
    
    // def multiple args
    def sum(args:Int*) = {
      var res = 0
      for(s <- args) res += s
      res
    }    
    println(sum(1,2,3,4,5))
    
    val x:Int = 1
    lazy val y = x + 1
    
    lazy val words = scala.io.Source.fromFile("d:\\temp\\b.txt.txt").mkString
    println(words)
    
  }
}