import java.io.File
import scala.collection.mutable.ListBuffer
import scala.io.Source


object Main {
  def main(args: Array[String]): Unit = {
    val file = new File(getClass.getClassLoader.getResource("urls.txt").getPath)
    val listOfUrls: ListBuffer[Connection] = ListBuffer.empty
    for (line <- Source.fromFile(file).getLines()){
      listOfUrls.+=:(Connection(line))
    }
    listOfUrls.foreach(println)
  }

}

//<span class="price ">€ 157,90</span>