package LogicalPrograms

import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readLine
import scala.util.Random

object CouponNumber {
  def main(args: Array[String]): Unit = {
    var number = readLine("Enter the number of coupons to Generate:").toInt
    var couponList = new ListBuffer[String]()
    while(number != 0) {
      val randomCoupon = Random.nextInt(100)
      val randomValue=randomCoupon.toString
      if (!couponList.contains(randomValue)) {
        couponList += randomValue
        number -= 1
      }
    }
    println(couponList)
  }
}

