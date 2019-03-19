package classDemo

object HelloWorld extends App{
//  def main(args: Array[String]): Unit = {
//    println("Hello World")
//  }
  println("Hello World")
  if(args.length > 0) {
    println("inputs")
  } else {
    println("no input")
  }
}