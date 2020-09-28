package LogicalPrograms

import scala.concurrent.duration.DurationLong
import scala.io.StdIn.readLine

object StopWatch {
  def main(args: Array[String]): Unit = {
    val startKey= readLine("enter Y to start ").toUpperCase
    val startedAtNanos = System.nanoTime()
    if(startKey.equals("Y")){
      println("*****Stop-Watch*****\n Start Time: 0.0")
    }
    val stopKey= readLine("enter N to stop ").toUpperCase
    if(stopKey.equals("N")){
      val durationTime = ((System.nanoTime() - startedAtNanos)/1000000000).toFloat
      println("Stop Time:"+durationTime)
    }
  }
}
