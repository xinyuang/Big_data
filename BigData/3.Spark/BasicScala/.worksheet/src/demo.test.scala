package demo

object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(71); 
  println("Welcome to the Scala worksheet");$skip(25); 
  var name = List(1,2,3);System.out.println("""name  : List[Int] = """ + $show(name ));$skip(30); 
  val v = Vector(1,2,3,4,5,6);System.out.println("""v  : scala.collection.immutable.Vector[Int] = """ + $show(v ));$skip(26); 
  val name2 = List(1,2,3);System.out.println("""name2  : List[Int] = """ + $show(name2 ));$skip(20); 
  print(Range(0,5));$skip(16); 
  print(0 to 4);$skip(19); 
  print(0 until 5);$skip(25); 
  var s1 = Set(1,2,10,8);System.out.println("""s1  : scala.collection.immutable.Set[Int] = """ + $show(s1 ));$skip(9); val res$0 = 
  s1 + 3;System.out.println("""res0: scala.collection.immutable.Set[Int] = """ + $show(res$0));$skip(59); 
  var s2 = scala.collection.mutable.SortedSet(1,3,2,7,6,5);System.out.println("""s2  : scala.collection.mutable.SortedSet[Int] = """ + $show(s2 ));$skip(14); val res$1 = 
  s1 union s2;System.out.println("""res1: scala.collection.immutable.Set[Int] = """ + $show(res$1));$skip(18); val res$2 = 
  s1 intersect s2;System.out.println("""res2: scala.collection.immutable.Set[Int] = """ + $show(res$2))}
  
  
  
  
}
