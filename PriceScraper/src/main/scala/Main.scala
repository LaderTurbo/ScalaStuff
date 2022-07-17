import java.io.File
import scala.collection.mutable.ListBuffer
import scala.io.Source
import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL.Parse._
import net.ruippeixotog.scalascraper.model._
import slick.jdbc.JdbcBackend.Database
import slick.util.AsyncExecutor

import java.sql.{Connection, DriverManager, ResultSet}
import scala.Function.const
import scala.language.postfixOps


object Main {
  def main(args: Array[String]): Unit = {
    val file = new File(getClass.getClassLoader.getResource("urls.txt").getPath)
    val postGresConnection = new PostGresConnection().connection
    val stm = postGresConnection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)

    for (line <- Source.fromFile(file).getLines()) {
      println(AlternateLegoPrices(line).getInsert)
      var alternateLegoPricesInsert = AlternateLegoPrices(line).getInsert
      stm.addBatch(alternateLegoPricesInsert)
    }
    stm.executeBatch()
    postGresConnection.close()
    //        val rs = stm.executeQuery("SELECT * from prices")

    //        while(rs.next) {
    //          println(rs.getString("price"))
    //        }


  }
}

//<span class="price ">€ 157,90</span>