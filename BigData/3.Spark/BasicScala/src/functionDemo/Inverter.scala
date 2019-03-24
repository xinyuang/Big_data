package functionDemo

//inverter -T 
class Animals

class Birds extends Animals
class Sparrows extends Birds

// +T allow parent class accept child class
class Eats[-T](t:T)

object Inverter {
    var c1:Eats[Birds] = new Eats[Birds](new Birds)
    var c2:Eats[Sparrows] = c1
    var c3:Eats[Sparrows] = new Eats[Sparrows](new Sparrows)
}