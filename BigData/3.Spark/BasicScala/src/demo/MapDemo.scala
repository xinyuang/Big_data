package demo

object MapDemo {
  def main(args: Array[String]): Unit = {
    //immutable map
    val scores = Map("Tom"->80,"Marry"->85,"Mike"->82)
    println(scores)
    
    println(scores("Tom"))
    println(scores.get("Tom"))
    
    if(scores.contains("Bob")){
      println(scores("Bob"))
    } else {
      println("No this key")
    }
    
    println(scores.getOrElse("Tom", -1))
    println(scores.getOrElse("Bob", -1))
    
    //mutable map
    val math_scores = scala.collection.mutable.Map(("Alice",80),("Bob",95),("Marry",90))
    println(math_scores)
    math_scores("Alice") = 100
    println(math_scores)
    
    for(s <- math_scores) println(s)
    math_scores.foreach(println)
    
  }
}