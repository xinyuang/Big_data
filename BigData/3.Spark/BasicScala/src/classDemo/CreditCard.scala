package classDemo

object CreditCard {
  private[this] var creditCardNumber:Long = 0
  def generateCCNumber():Long = {
    creditCardNumber += 1
    creditCardNumber
  }
  
  def main(args: Array[String]): Unit = {
    println(CreditCard.generateCCNumber())
    println(CreditCard.generateCCNumber())
    println(CreditCard.generateCCNumber())
    println(CreditCard.generateCCNumber())
    
  }
}