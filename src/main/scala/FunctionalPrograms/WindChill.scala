package FunctionalPrograms

import scala.io.StdIn.readLine
import scala.math.pow

object WindChill {
  def main(args: Array[String]): Unit = {
    println("Note:Values of  Temperature < 50 and velocity > 3 and velocity < 120")
    val temperature = readLine("Enter Temperature:").toFloat
    val velocity = readLine("Enter the velocity").toFloat
    val windChill = 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * pow(velocity,0.16)
    println("The value of Wind Chill is %1.2f"+windChill)
  }
}
