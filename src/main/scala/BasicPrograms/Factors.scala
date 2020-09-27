import scala.io.StdIn.readLine

object Factors {
  def main(args: Array[String]): Unit = {
    var number = readLine("Enter a number for Factoring: ").toInt
    for (countLoop <- 1 to number) {
      if ((countLoop * countLoop <= number)&&(number % 1 == 0)) {
        print("Prime Factors:")
        println(countLoop+"\t")
      }
    }
  }
}
