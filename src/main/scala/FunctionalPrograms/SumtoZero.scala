package FunctionalPrograms

import scala.io.StdIn.readLine

object SumtoZero {
  def main(args: Array[String]): Unit = {
    val Arraysize = readLine("Size of array:").toInt
    val myArray = new Array[Int](Arraysize)
    var sumZeroCounter = 0
    for (loop <- 0.until(Arraysize)) {
      myArray(loop) = readLine("Enter "+loop+" Element:").toInt
    }
    for (elementOne <- 0 until Arraysize) {
      for (elemrntTwo <- 0 until Arraysize-1) {
        for (elemrntThree <- 0 until Arraysize-2) {
          if (myArray(elementOne) + myArray(elemrntTwo) + myArray(elemrntThree) == 0) {
            sumZeroCounter += 1
            println(myArray(elementOne), myArray(elemrntTwo), myArray(elemrntThree))
          }
        }
      }
    }
    println("Number of Triplets:" + sumZeroCounter)
  }
}


