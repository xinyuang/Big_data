package classDemo

object abstractDemo {
  def main(args: Array[String]): Unit = {
    var v1:Vehicle = new Car
    println(v1.checkType())
    
    var v2:Vehicle = new Bike
    println(v2.checkType())
  }
}

abstract class Vehicle{
  def checkType():String
}

class Car extends Vehicle{
  def checkType():String = "Car"
}

class Bike extends Vehicle{
  def checkType():String = "Bike"
}

