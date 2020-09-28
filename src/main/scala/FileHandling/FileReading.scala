package FileHandling

import scala.io.Source

object FileReading {
  def main(args : Array[String])
  {
    // file name
    val fname = "abc.txt"

    // creates iterable representation
    // of the source file
    val fSource = Source.fromFile(fname)
    for(line<-fSource.getLines)
    {
      println(line)
    }

    // closing file
    fSource.close()
  }
}
