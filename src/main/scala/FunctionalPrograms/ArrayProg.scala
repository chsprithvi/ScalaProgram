package FunctionalPrograms

import scala.io.StdIn.readLine

object ArrayProg {
  def main(args: Array[String]): Unit = {
    try {
      val row = readLine("Number of rows:").toInt
      val column = readLine("Number of columns:").toInt
      val myArray = Array.ofDim[Int](row, column)
      for (rowLoop <- 0 until row) {
        for (columnLoop <- 0 until column) {
          myArray(rowLoop)(columnLoop) = readLine("Matrix location--(" + rowLoop +"," + columnLoop+"):").toInt
        }
      }
      println("The matrix is:")
      for (rowLoop <- 0 until row) {
        for (columnLoop <- 0 until  column) {
          print(myArray(rowLoop)(columnLoop)+"\t")
        }
        println("\n")
      }
    }
    catch {
      case _:ArrayIndexOutOfBoundsException=>println("Enter in range")
    }
  }
}