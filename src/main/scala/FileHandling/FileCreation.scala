package FileHandling

import java.io.{File, PrintWriter}

object FileCreation {
  def main(args:Array[String])
  {
    // Creating a file
    val file_Object = new File("abc.txt" )

    // Passing reference of file to the printwriter
    val print_Writer = new PrintWriter(file_Object)

    // Writing to the file
    print_Writer.write("Hello, This is Siddhartha")

    // Closing printwriter
    print_Writer.close()
  }
}
