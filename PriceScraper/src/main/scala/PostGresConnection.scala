import java.sql.{Connection, DriverManager, ResultSet}

class PostGresConnection {
  val con_str = "jdbc:postgresql://localhost:5432/PriceScraper?user=postgres"
  def connection = DriverManager.getConnection(con_str)

}
