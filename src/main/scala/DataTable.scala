import slick.driver.MySQLDriver.simple._
import scala.slick.collection.heterogenous._
import scala.slick.collection.heterogenous.syntax._
import scala.slick.jdbc._

// This is the large case class we are mapping -- 25 string fields:
case class BigData(
  field1: String,
  field2: String,
  field3: String,
  field4: String,
  field5: String,
  field6: String,
  field7: String,
  field8: String,
  field9: String,
  field10: String,
  field11: String,
  field12: String,
  field13: String,
  field14: String,
  field15: String,
  field16: String,
  field17: String,
  field18: String,
  field19: String,
  field20: String,
  field21: String,
  field22: String,
  field23: String,
  field24: String,
  field25: String
)

// The remainder of the code demonstrates mapping the `BigData` class using Slick:
object ExampleQueries {

  // This is the table for `BigData`. Because we have >22 fields,
  // we have to use Slick's `HList` mappings:
  class BigDataTable(tag: Tag) extends Table[BigData](tag, "bigdata") {
    def field1 = column[String]("field1")
    def field2 = column[String]("field2")
    def field3 = column[String]("field3")
    def field4 = column[String]("field4")
    def field5 = column[String]("field5")
    def field6 = column[String]("field6")
    def field7 = column[String]("field7")
    def field8 = column[String]("field8")
    def field9 = column[String]("field9")
    def field10 = column[String]("field10")
    def field11 = column[String]("field11")
    def field12 = column[String]("field12")
    def field13 = column[String]("field13")
    def field14 = column[String]("field14")
    def field15 = column[String]("field15")
    def field16 = column[String]("field16")
    def field17 = column[String]("field17")
    def field18 = column[String]("field18")
    def field19 = column[String]("field19")
    def field20 = column[String]("field20")
    def field21 = column[String]("field21")
    def field22 = column[String]("field22")
    def field23 = column[String]("field23")
    def field24 = column[String]("field24")
    def field25 = column[String]("field25")

    // The `*` projection uses `<>` to bidirectionally map the
    // `HList` to a `BigData` object.
    //
    // For clarity I have separated the mapping functions out
    // into separate methods below:
    def * = (
      field1 ::
      field2 ::
      field3 ::
      field4 ::
      field5 ::
      field6 ::
      field7 ::
      field8 ::
      field9 ::
      field10 ::
      field11 ::
      field12 ::
      field13 ::
      field14 ::
      field15 ::
      field16 ::
      field17 ::
      field18 ::
      field19 ::
      field20 ::
      field21 ::
      field22 ::
      field23 ::
      field24 ::
      field25 ::
      HNil
    ) <> (createBigData, extractBigData)

    // Here I'm defining the type of the HList so I don't have
    // to write it inline in the method definitions below:
    type BigDataHList =
      String ::
      String ::
      String ::
      String ::
      String ::
      String ::
      String ::
      String ::
      String ::
      String ::
      String ::
      String ::
      String ::
      String ::
      String ::
      String ::
      String ::
      String ::
      String ::
      String ::
      String ::
      String ::
      String ::
      String ::
      String ::
      HNil

    // Mapping from HList to BigData:
    def createBigData(data: BigDataHList): BigData = data match {
      case field1 ::
           field2 ::
           field3 ::
           field4 ::
           field5 ::
           field6 ::
           field7 ::
           field8 ::
           field9 ::
           field10 ::
           field11 ::
           field12 ::
           field13 ::
           field14 ::
           field15 ::
           field16 ::
           field17 ::
           field18 ::
           field19 ::
           field20 ::
           field21 ::
           field22 ::
           field23 ::
           field24 ::
           field25 ::
           HNil =>
        BigData(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18, field19, field20, field21, field22, field23, field24, field25)
    }

    // Mapping from BigData to HList:
    def extractBigData(data: BigData): Option[BigDataHList] = data match {
      case BigData(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18, field19, field20, field21, field22, field23, field24, field25) =>
        Some(
          field1 ::
          field2 ::
          field3 ::
          field4 ::
          field5 ::
          field6 ::
          field7 ::
          field8 ::
          field9 ::
          field10 ::
          field11 ::
          field12 ::
          field13 ::
          field14 ::
          field15 ::
          field16 ::
          field17 ::
          field18 ::
          field19 ::
          field20 ::
          field21 ::
          field22 ::
          field23 ::
          field24 ::
          field25 ::
          HNil
        )
    }
  }

  // Query singleton:
  val BigDataTable = TableQuery[BigDataTable]

  // And finally an example query. The important thing
  // here is that this returns a `List[BigData]` (and type checks):
  def findBigDataByField1(field1: String)(implicit session: Session): List[BigData] =
    BigDataTable.filter(_.field1 === field1).list
}

