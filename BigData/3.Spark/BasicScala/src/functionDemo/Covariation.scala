package functionDemo

class Animal

class Bird extends Animal
class Sparrow extends Bird
// +T allow parent class accept child class
class Eat[+T](t:T)

object Covariation {
  def main(args: Array[String]): Unit = {
    var c1:Eat[Bird] = new Eat[Bird](new Bird)
    var c2:Eat[Animal] = c1
    var c3:Eat[Sparrow] = new Eat[Sparrow](new Sparrow)
    var c4:Eat[Animal] = c3
    
  }
}