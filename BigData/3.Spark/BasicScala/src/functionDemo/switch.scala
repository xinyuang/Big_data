package functionDemo

object switch {
  def main(args: Array[String]): Unit = {
    var sign = 0
    var ch1 = '-'
    ch1 match {
      case '+' => sign = 1
      case '-' => sign = -1
      case _=> sign = 0
    }
    println(sign)
    
    var ch2 = '6'
    var digit:Int = -1
    ch2 match {
      case '+' => println("this is plus")
      case '-' => println("this is substract")
      case _ if Character.isDigit(ch2)=> digit = Character.digit(ch2,10)
      case _ => print("others")
    }
    println(digit)
    
    var mystr = "Hello World"
    mystr(7) match {
      case '+' => println("this is plus")
      case '-' => println("this is substract")
      case any => println("this is " + any)
    }
    
    var v4:Any = 100
    v4 match {
      case x:Int => println("int")
      case x:String => println("String")
      case _ => print("other")
    }
    
    var myArray = Array(1,2,3)
    myArray match {
      case Array(0) => println("only 0")
      case Array(x,y) => println(" two elem")
      case Array(x,y,z) => println("three elem")
      case Array(x,_*) => println("more than 3")     
    }
    
    var myList = List(1,2,3,0)
    myList match {
      case List(0) => println("only 0")
      case List(x,y) => println(" two elem")
      case List(x,y,z) => println("three elem")
      case List(x,_*) => println("more than 3")     
    }  
    
    class Fruit
    case class Apple(name:String) extends Fruit
    case class Banana(name:String) extends Fruit
    var a:Fruit= new Apple("apple")
    var b:Fruit = new Banana("banana")
    println(a.isInstanceOf[Fruit])
    println(a.isInstanceOf[Apple])
    println(a.isInstanceOf[Banana])
    
    b match {
      case Apple(name) => println("apple " + name)
      case Banana(name) => println("banana " + name)
      case _ => println("other")
    }
    
        
  }
}