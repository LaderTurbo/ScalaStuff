import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL._

import java.io.File
import scala.language.postfixOps

case class AlternateLegoPrices(url: String){

  def getPrice: Double ={
    val browser = JsoupBrowser()
    val doc = browser.get(url)
    val priceTag = doc >?> texts(".price")
    val price = priceTag.head.head.tail.replace(",",".").toDouble
    price
  }

  def getArticleName: String ={
    val browser = JsoupBrowser()
    val doc = browser.get(url)
    val titleTag = doc >?> text("title")
    titleTag.head.toString
  }

  def getInsert: String = {
    val insert = "INSERT INTO PRICES(article_name,link,price,its,uts) " +
      s"VALUES('$getArticleName','$url',$getPrice,current_timestamp,current_timestamp);"
    insert
  }

}
