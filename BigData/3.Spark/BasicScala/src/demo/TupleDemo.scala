package demo

object TupleDemo {
  def main(args: Array[String]): Unit = {
    val t1 = Tuple3(1,3.14,"Hello")
    println(t1)
    val t2 = (2,"world")
    println(t2)
    println(t2._1)
    
    t1.productIterator.foreach(println)
    }
}