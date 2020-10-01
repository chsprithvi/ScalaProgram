package LogicalPrograms

object TicTacToe {
  var row = 3
  var column =3
  var arrayIntial=0
  var arrLength: Int =row*column
  var board = new Array[String](arrLength)

  def resetBoard(): Unit = {
    for (position <- arrayIntial until arrLength){
      board(position)=" "
    }
  }
  def main(args: Array[String]): Unit = {
    println(" %%%%%%% TicTakToe %%%%%%% ")
    resetBoard()
  }
}
