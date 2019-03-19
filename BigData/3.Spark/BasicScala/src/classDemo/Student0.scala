package classDemo

class Student0(var stuName:String, var age:Int) {
  // main constructor is above inputs
  // auxiliary constructor this 
  def this(age:Int){
    this("no name",age)
    println("using auxiliary constructor")
  }
}

object Student0 {
  def main(args: Array[String]): Unit = {
    var s1 = new Student0("Tom",20)
    println(s1.stuName + "\t" + s1.age)
    
    var s2 = new Student0(25)
    println(s2.stuName + "\t" + s2.age)
    
  }
}