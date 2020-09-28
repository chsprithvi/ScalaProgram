package LogicalPrograms

import scala.io.StdIn.readLine
import scala.util.Random

object Gambler {
  def main(args: Array[String]): Unit = {
    println("******Welcome To Gambling******")
    var stake = readLine("Enter Stake Amount:").toInt
    val goal = readLine("Enter Maximum Amount of the day:").toInt
    val number = readLine("Enter Number of time you want to play:").toInt
    var playCount = 0
    var winCount = 0
    var lostCount = 0
    while(stake<=goal && stake>=0 && playCount<number){
      val checkRandom=Random.nextInt(2)
      if(checkRandom==0){
        winCount += 1
        stake += 1
      }
      else{
        lostCount += 1
        stake -= 1
      }
      playCount += 1
    }
    val winPercent= winCount*100/playCount.toFloat
    val lostPercent= lostCount*100/playCount.toFloat
    println(s"PlayCount=$playCount,WinCount=$winCount,LostCount=$lostCount")
    println(s"Win percentage: $winPercent%, Lost Percentage: $lostPercent%")
  }
}
