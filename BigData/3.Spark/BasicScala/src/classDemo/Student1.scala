package classDemo

class Student1 {
  private var stuID:Int = 0
  private var stuName:String = "Tom"
  private var age:Int = 20
  private[this] var score:Int = 80
  
  //def method : get and set
  def getStuName():String = stuName
  def setStuName(newName:String) = this.stuName = newName
  
  def getStuAge():Int = age
  def setStuAGE(newAge:Int) = this.age = newAge
}

  object Student1{
    def main(args: Array[String]): Unit = {
      var s1 = new Student1
      println(s1.getStuName() + "\t" + s1.getStuAge())
      s1.setStuName("Mary")
      s1.setStuAGE(22)
      println(s1.getStuName() + "\t" + s1.getStuAge())
      
      //with [this] scala will not generate get set method automatically
      println(s1.stuName)
      
    }
  }
