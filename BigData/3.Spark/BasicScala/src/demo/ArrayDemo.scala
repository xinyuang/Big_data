package demo

import scala.collection.mutable.ArrayBuffer

object ArrayDemo {
  def main(args: Array[String]): Unit = {
    val a = new Array[Int](10)    
    val b = new Array[String](5)
    val c = ArrayBuffer[Int]()
    for( i <- 0 until 10) {
      a(i) = i
      println(a(i))
      c += i
      println(c)
    }
    
    c.trimEnd(2)
    println(c)
    println(c.max)
    println(c.min)
    println(c.sortWith(_ > _))
    println(c.sortWith(_ < _))

    val d = Array("Tom","Mike","Marry")
    d.foreach(println)
    
    val matrix = Array.ofDim[Int](3,4)
    matrix(1)(2) = 10
    println(matrix.deep.mkString("\n"))
    
    val matrix1 = Array.fill(2,2)(0)
    println(matrix1.deep.mkString("\n"))
    
    val triangle = new Array[Array[Int]](10)
    for(i <- 0 until triangle.length) triangle(i) = new Array[Int](i+1)
    println(triangle.deep.mkString("\n"))
  }
}