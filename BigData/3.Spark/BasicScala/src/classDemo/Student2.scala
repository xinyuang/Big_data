package classDemo

import scala.collection.mutable.ArrayBuffer

class Student2 {
  private var stuID:Int = 0
  private var stuName:String = "Tom"
  private var age:Int = 20
  private[this] var score:Int = 80
  
  private var courseList = new ArrayBuffer[Course]()
  
  def addNewCourse(cname:String,grade:Int){
    var c = new Course(cname,grade)
    courseList += c
  }
  // internal class
  class Course(val couseName:String, val grade:Int){
    
  }
  
  
  //def method : get and set
  def getStuName():String = stuName
  def setStuName(newName:String) = this.stuName = newName
  
  def getStuAge():Int = age
  def setStuAGE(newAge:Int) = this.age = newAge
}

  object Student2{
    def main(args: Array[String]): Unit = {
      var s2 = new Student2
      s2.addNewCourse("math",80)
      s2.addNewCourse("English",80)
      s2.addNewCourse("Sport",90)
      println(s2.stuName + "\t" + s2.age)
      
      for(c <- s2.courseList){
        println(c.couseName)
        println(c.grade)
      }
        
        
      
    }
  }
