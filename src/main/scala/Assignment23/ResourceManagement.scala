import scala.util.{Using, Try, Success, Failure}
import java.io.{File, PrintWriter}
import scala.io.Source

object ResourceManagement {

  def writeFile(filename: String, content: String): Try[Unit] = {
    Using(new PrintWriter(new File(filename))) { writer =>
      writer.write(content)
    }
  }

  def readFile(filename: String): Try[String] = {
    Using(Source.fromFile(filename)) { source =>
      source.getLines().mkString("\n")
    }
  }

  def safeReadFile(filename: String): String = {
    readFile(filename).recover {
      case ex: java.io.FileNotFoundException => s"Error: File '$filename' not found."
      case ex: Exception => s"Error: An unexpected error occurred - ${ex.getMessage}"
    }.get
  }

  @main def run(): Unit = {
    val filename = "File.txt"

    // Writing to File
    writeFile(filename, "Welcome to the ScalaDay7 on topic Resource Management") match {
      case Success(_) => println(s"Successfully wrote to $filename")
      case Failure(ex) => println(s"Failed to write file: ${ex.getMessage}")
    }

    // Reading file
    println(safeReadFile(filename))
    println(safeReadFile("non_existent.txt"))
  }
}
