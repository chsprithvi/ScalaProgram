package FunctionalPrograms

import scala.io.StdIn.readLine
import scala.math.sqrt

object Quadratic {
  def main(args: Array[String]): Unit = {
    print("to get roots of aX2+bX+c=0")
    val a = readLine("Enter a: ").toInt
    val b = readLine("Enter b: ").toInt
    val c = readLine("Enter c: ").toInt
    val delta = (b * b) - (4 * a * c)
    if (delta < 0)
      print("There are no real roots ")
    else {
      val root1 = (-b + sqrt(delta)) / (2 * a)
      val root2 = (-b - sqrt(delta)) / (2 * a)
      print(s"The roots are $root1 and $root2")
    }
  }
}
