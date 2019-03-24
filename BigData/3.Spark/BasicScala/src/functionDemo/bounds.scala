package functionDemo

class Vehicle{
  def drive() = {println("driving")}
}

class Car extends Vehicle{
  override def drive() = {println("car driving")}
}

class Bike extends Vehicle{
  override def drive() = {println("bike driving")}
}

object bounds {
  def main(args: Array[String]): Unit = {
    def takeVehicle[T <: Vehicle](v:T) = {v.drive()}
    var v:Vehicle = new Vehicle
    takeVehicle(v)
    
    var c:Car = new Car
    takeVehicle(c)
    
    def addTwoString[T <% String](x:T,y:T) = {println(x + "***" + y)}
    implicit def int2String(n:Int):String = {n.toString}
    addTwoString(1,2)
  }
}