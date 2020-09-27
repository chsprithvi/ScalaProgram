import scala.io.StdIn.readLine
import scala.math.pow

object Power2 {
  def main(args: Array[String]): Unit = {
    val number = readLine("Enter a number: ").toInt
    val maxNumber = pow(2, number)
    var result: Int = 0
    var loopCount: Int = 0
    if (number >= 0  && number < 31) {
      while (result<maxNumber){
        result=pow(2, loopCount).toInt
        loopCount += 1
        println(result)
      }
    }
  }
}