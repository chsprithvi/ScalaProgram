import scala.io.StdIn.readLine

object LeapYear {
  def main(args: Array[String]): Unit = {
    val year = readLine("Enter year: ").toInt
    if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
      println("It is a leap year")
    }
    else {
      println("Not a leap year")
    }
  }
}
