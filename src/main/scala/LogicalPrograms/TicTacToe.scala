package LogicalPrograms

import scala.util.Random

object TicTacToe {
  var row = 3
  var column =3
  var arrayIntial=0
  var arrLength: Int =row*column
  var board = new Array[String](arrLength)
  val tossValue: Int = toss
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
  //Function play to start game
  def play(): Unit = {
    resetBoard()
    display()
    if (tossValue == 1) playerChoice()
    else computerChoice()
  }
  //function to check if player or computer chance
  def toss: Int = {
    // Generating a random number b/w 0 and 1
    val checkOption = Random.nextInt(2)
    //option 1 = PLAYER <> option 2 = COMPUTER
    if (checkOption == 1) println("Player Chance to Play")
    else println("Computer Chance to Play")
    checkOption
  }
  def main(args: Array[String]): Unit = {
    println(" %%%%%%% TicTakToe %%%%%%% ")
    play
  }
}
