import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readLine
import scala.sys.exit
import scala.util.Random

object TicTacToe {
  def main(args: Array[String]): Unit = {
    println(" %%%%%%%% TicTakToe %%%%%%% ")
    play()
  }
  var row = 3
  var column =3
  var arrayIntial=0
  var arrLength: Int =row*column
  var board = new Array[String](arrLength)
  var playerValue:String = _
  var computerValue:String = _
  val playerPosition = new ListBuffer[Int]()
  val computerPosition = new ListBuffer[Int]()
  var winner:String = _
  val tossValue: Int = toss
  //function to reset board
  def resetBoard(): Unit = {
    for (position <- arrayIntial until arrLength){
      board(position)=" "
    }
  }

  //Function play to start game
  def play(): Unit = {
    resetBoard()
    display()
    if (tossValue == 1) playerChoice()
    else computerChoice()
    gamePlay(tossValue)
  }

  //function to display
  def display(): Unit = {
    println("| " + board(0) + " | " + board(1) + " | " + board(2) + " |\n|-----------|\n| " + board(3) + " | " + board(4) + " | " + board(5) + " |\n|-----------|\n| " + board(6) + " | " + board(7) + " | " + board(8) + " |")
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

  //function to check valid or invalid move
  def moveValid(move: Int): Boolean = {
    if (board(move) equals " ") true
    else false
  }

  //function to play computer move
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
  //function to check any winning positions available
  def checkWinningPosition(position: ListBuffer[Int]): Int = {
    val winningPosition = Array(Array(0, 1, 2), Array(3, 4, 5), Array(6, 7, 8), Array(0, 3, 6), Array(1, 4, 7), Array(2, 5, 8), Array(0, 4, 8), Array(2, 4, 6))
    var arrayStart = 0
    val emptyPosition = new ListBuffer[Int]
    while (arrayStart < winningPosition.length) {
      var count = 0
      emptyPosition.clear()
      for (winningPositionStart <- arrayIntial until winningPosition(arrayStart).length) {
        if (position.contains(winningPosition(arrayStart)(winningPositionStart))) {
          count += 1
        }
        else {
          emptyPosition.append(winningPosition(arrayStart)(winningPositionStart))
        }
      }

      if (count == 2 && emptyPosition.length == 1 && board(emptyPosition.head) == " ") {
        return emptyPosition.head
      }
      arrayStart += 1
    }
    -1
  }
  //check winner function
  def checkWinner: String =  {
    isHorizontal()
    isVertical()
    isDiagonal()
    val tie="gameOver"
    val drawCheck=draw
    if (drawCheck && winner == null) tie
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
    for (position <- arrayIntial until arrLength) {
      if (board(position) == " ") return false
    }
    true
  }
}
