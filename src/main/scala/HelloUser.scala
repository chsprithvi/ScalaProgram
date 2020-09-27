import scala.io.StdIn.readLine
import scala.sys.exit

object HelloUser {
  def main(args: Array[String]): Unit = {
    while(true){
      val userName: String = readLine("Enter Your Name: ")
      if(userName.length>=3) {
        println("Hello " + userName + ",How are you?")
        exit
      }
      println("Enter at-least 3 characters")
    }
  }
}