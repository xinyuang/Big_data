package functionDemo

class Fruit(name:String){
  def getFruitName():String = name
}

class Monkey(f:Fruit){
  def say() = {println("Monkey like " + f.getFruitName())}
}
  
object Implicit {
      
  def main(args: Array[String]): Unit = {
    implicit def fuit2Monkey(f:Fruit):Monkey = {
      new Monkey(f)
    }
    var f:Fruit = new Fruit("Banana")
    f.say()
    
    def testParam(implicit name:String) = println("The value is " + name) 
    implicit val name:String = "bbb"
    testParam("aaa")
    testParam
    
    implicit class Calc(x:Int){
      def add(y:Int):Int = x + y
    }
    
    println(1.add(2))

  }
  
  
}