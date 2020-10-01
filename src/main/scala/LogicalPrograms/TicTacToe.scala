package LogicalPrograms

object TicTacToe {
  var row = 3
  var column =3
  var arrayIntial=0
  var arrLength: Int =row*column
  var board = new Array[String](arrLength)
 //function to reset board
  def resetBoard(): Unit = {
    for (position <- arrayIntial until arrLength){
      board(position)=" "
    }
  }
  //function to display
  def display(): Unit = {
    println("| " + board(0) + " | " + board(1) + " | " + board(2) + " |\n|-----------|\n| " + board(3) + " | " + board(4) + " | " + board(5) + " |\n|-----------|\n| " + board(6) + " | " + board(7) + " | " + board(8) + " |")
  }
  def main(args: Array[String]): Unit = {
    println(" %%%%%%% TicTakToe %%%%%%% ")
    resetBoard()
    display()
  }
}
