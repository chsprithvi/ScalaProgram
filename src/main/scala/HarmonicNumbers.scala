import scala.io.StdIn.readLine

object HarmonicNumbers {
    def main(args: Array[String]): Unit = {
      var number = readLine("Enter a number: ").toFloat
      var result: Float = 0
      while (number != 0){
        result = (1/number) + result
        number -= 1
      }
      println(result)
    }
}
