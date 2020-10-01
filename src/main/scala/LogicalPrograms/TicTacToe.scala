package LogicalPrograms

import scala.io.StdIn.readLine
import scala.util.Random

object TicTacToe {
  var row = 3
  var column =3
  var arrayIntial=0
  var arrLength: Int =row*column
  var board = new Array[String](arrLength)
  var playerValue:String = _
  var computerValue:String = _
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
  //function to consider player choice
  def playerChoice(): Unit = {
    while (true){
      playerValue = readLine("Enter your Choice either 'X' or 'O'").toUpperCase
      playerValue match {
        case "X" => println("Your Choice:" + playerValue)
          computerValue = "O"
          return false
        case "O" => println("Your Choice:" + playerValue)
          computerValue = "X"
          return false
        case _ =>println("Not a valid input")
      }
    }
  }

  //function for computer choice
  def computerChoice(): Unit = {
    val computerChoice = Random.nextInt(2)
    //option 1 = PLAYER </> option 2 = COMPUTER
    if (computerChoice == 1) {
      computerValue = "X"
      println("Computer choice:" + computerValue)
      playerValue = "O"
    }
    else {
      computerValue = "O"
      println("Computer Choice:" + computerValue)
      playerValue = "X"
    }
  }

  //function to start game after initial toss and play
  def gamePlay(tossResult: Int): Unit = {
    var tossResultCheck = tossResult
    while (true) {
      if (tossResultCheck == 1) {
        var check: Boolean = true
        while (check) {
          try {
            var move = readLine("Enter the move in range[1-9]").toInt
            move -= 1
            if (moveValid(move)) {
              board(move) = playerValue
              playerPosition.append(move)
              check=false
            }

          } catch {
            case _: NumberFormatException => print("Enter a number only")
            case _: ArrayIndexOutOfBoundsException => println("Enter in certain range")
          }
        }
      } else {
        println("Computer Turn")
        computerMove()
      }
      display()
      val resultWinner = checkWinner
      if (resultWinner != null) {
        println(resultWinner)
        if (resultWinner == computerValue) println("The winner is Computer")
        else if (resultWinner == playerValue) println("The winner is Player")
        else if (resultWinner=="gameOver") println("The Game is Draw")
        else println("game Struck")
        display()
        exit
      }
      if (tossResultCheck==1) tossResultCheck = 0
      else tossResultCheck= 1
    }
  }
  def computerMove(): Unit = {
    var move = checkWinningPosition(computerPosition)
    if (move != -1 && moveValid(move)) {
      board(move) = computerValue
      computerPosition.append(move)
      return
    }
    val blockMove = checkWinningPosition(playerPosition)
    if (blockMove != -1 && moveValid(blockMove)) {
      board(blockMove) = computerValue
      computerPosition.append(blockMove)
      return
    }
    val cornerPositions: Array[Int] = Array(0, 2, 6, 8)
    for (cornerMove <- cornerPositions) {
      if (moveValid(cornerMove)) {
        board(cornerMove) = computerValue
        computerPosition.append(cornerMove)
        return
      }
    }
    move = 4
    if (moveValid(move)) {
      board(move) = computerValue
      computerPosition.append(move)
      return
    }
    val sidePositions: Array[Int] = Array(1, 3, 5, 7)
    for (sideMove <- sidePositions) {
      if (moveValid(sideMove)) {
        board(sideMove) = computerValue
        computerPosition.append(sideMove)
        return
      }
    }
  }
  def main(args: Array[String]): Unit = {
    println(" %%%%%%% TicTakToe %%%%%%% ")
    play
  }
}
