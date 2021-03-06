package demo

object forwhile {
  def main(args: Array[String]): Unit = {
    
    var list = List("marry","Tom","mike")
    System.out.println("*********for case 1 *************")
    for(s <- list) println(s)
    
    System.out.println("*********for case 2 *************")
    for{
      s <- list
      if(s.length() > 3)
    }println(s)
    
    System.out.println("*********for case 3 *************")
    for(s <- list if s.length() <= 3) println(s)
    
    System.out.println("*********for case 4 *************")
    var newList = for{
      s <- list
      s1 = s.toUpperCase()
    }yield(s1)
    println(newList)
    
    System.out.println("*********while case 1 *************")
    var i = 0
    while(i < list.length){
      println(list(i))
      i += 1
    }
    
    System.out.println("*********while case 2 *************")
    var j = 0
    do {
      println(list(j))
      j += 1
    } while(j < list.length)
    
    System.out.println("********* foreach (no return)*************")
    list.foreach(println)
    
    System.out.println("********* map (has return)*************")
    var list2 = list.map(
        s => {
          var s1 = s.toUpperCase()
          (s1)
        }
    )
    println(list2)
    
  }
}