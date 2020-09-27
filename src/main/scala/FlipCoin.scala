import scala.io.StdIn.readLine
import scala.sys.exit
import scala.util.Random

object FlipCoin {
  def main(args: Array[String]): Unit = {
    var totalCount : Float = 0
    var headCount : Float = 0
    var tailCount : Float = 0
    var headPercentage : Float = 0
    var tailPercentage : Float = 0

    while(true) {
      val tossCount: Int = readLine("Enter the number of times you want to toss: ").toInt
      if (tossCount>0){
        while(totalCount < tossCount) {
        var tossValue = Random.nextInt(2)
        if (tossValue == 0) {
         headCount += 1
        }
        else {
          tailCount +=1
        }
        totalCount += 1
        }

        println("head count:"+headCount)
        println("tail count:"+tailCount)
        headPercentage = (headCount / totalCount) * 100
        tailPercentage = (tailCount / totalCount) * 100
        println("The Head count percentage is "+headPercentage)
        println("The tail count percentage is "+tailPercentage)
        exit
      }
      println("Enter a positive value")
    }
  }
}
