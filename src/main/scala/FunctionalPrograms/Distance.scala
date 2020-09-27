package FunctionalPrograms

import scala.io.StdIn.readLine
import scala.math.{pow, sqrt}

object Distance {
  def main(args: Array[String]): Unit = {
    val x = readLine("Enter x: ").toInt
    val y = readLine("Enter y: ").toInt
    val distance = sqrt(pow(x,2) + pow(y,2))
    print(s"Distance between (0,0) and ($x,$y):$distance")
  }
}
