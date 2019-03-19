package functionDemo

object closure {
  def main(args: Array[String]): Unit = {
      def mulBy(factor:Int)= (x:Int) => x*factor
      val triple = mulBy(3)
      println(triple(4))
      
      def factorial(x:Int):Int = {
        if (x == 1) x
        else {
          x * factorial(x - 1)
        }
      }
      println(factorial(5))
      
      //currying function
      def add(x:Int)(y:Int):Int = x + y
      print(add(1)(1))
  }

}