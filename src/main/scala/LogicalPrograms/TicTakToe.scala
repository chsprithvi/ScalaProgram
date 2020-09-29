
import scala.io.StdIn.readLine
import scala.sys.exit
import scala.util.Random

object TicTakToe {
  def main(args: Array[String]): Unit = {
    println(" %%%%%%% TicTakToe %%%%%%% ")
    play()
  }
  var row = 3
  var column =3
  var board = new Array[String](row*column)
  var playerValue:String = _
  var computerValue:String = _
  var winner:String = _
  val tossValue: Int = toss

  //Function play to start game
  def play(): Unit = {
    for (position <- 0 until 9){
      board(position)=" "
    }
    display()
    if (tossValue == 1) playerChoice()
    else computerChoice()
    gamePlay(tossValue)
  }

  //function to display
  def display(): Unit = {
    System.out.println("| " + board(0) + " | " + board(1) + " | " + board(2) + " |")
    System.out.println("|-----------|")
    System.out.println("| " + board(3) + " | " + board(4) + " | " + board(5) + " |")
    System.out.println("|-----------|")
    System.out.println("| " + board(6) + " | " + board(7) + " | " + board(8) + " |")
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
    println("")
    playerValue = readLine("Enter your Choice either 'X' or 'O'")
    if (playerValue.equals("x")) {
      println("Your Choice:" + playerValue)
      computerValue = "O"
    }
    else if (playerValue.equals("o")) {
      println("Your Choice:" + playerValue)
      computerValue = "X"
    }
    else println("Wrong Input")
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
        var move = readLine("Enter the move in range[1-9]").toInt
        move -= 1
        if (!moveValid(move)) {
          println("Invalid Move Try Once More")
        }
        board(move)= playerValue

      }
      else {
        println("Computer Turn")
        computerMove()
      }
      display()
      val resultWinner = checkWinner
      if (resultWinner != null) {
        println(resultWinner)
        if (resultWinner == computerValue) println("The winner is Computer")
        else if (resultWinner == playerValue) println("The winner is Player")
        else println("The Game is Draw")
        display()
        exit
      }
      if (tossResultCheck==1) tossResultCheck = 0
      else tossResultCheck= 1
    }
  }

  //function to check valid or invalid move
  def moveValid(move: Int): Boolean = {
    if (board(move) equals " ") true
    else false
  }

  //function to play computer move
  def computerMove(): Unit = { //Random Sides
    while (true) {
      val moveCheck = Random.nextInt(9)
      if (moveValid(moveCheck)) {
        board(moveCheck) = computerValue
        return
      }
    }
  }
  //check winner function
  def checkWinner: String =  {
    isHorizontal()
    isVertical()
    isDiagonal()
    val drawCheck=draw
    if (drawCheck && winner == " ") "tie"
    else winner
  }
  var LoopListH: Array[Int] = Array(0,3,6)
  // horizontal
  def isHorizontal(): Unit = {
    for (position <- LoopListH) {
      if ((board(position) equals board(position+1)) && (board(position) equals board(position+2)) && (board(position)!=" "))
         winner = board(position)
    }
  }
  var LoopListV: Array[Int] = Array(0,1,2)
  // Vertical
  def isVertical(): Unit = {
    for (position <- LoopListV) {
      if ((board(position) equals board(position+3)) && (board(position) equals board(position+6)) && (board(position)!=" "))
        winner = board(position)
    }
  }

  // Diagonal
  def isDiagonal(): Unit = {
    if ((board(0) equals board(4))&&(board(0) equals board(8))&&(board(0)!=" ")) winner = board(0)
    if ((board(2) equals board(6))&&(board(2) equals board(4))&&(board(2)!=" ")) winner = board(2)
  }

  //Checking for draw
  def draw: Boolean = {
    for (position <- 0 until 9) {
      if (board(position) == " ") return false
    }
    true
  }
}