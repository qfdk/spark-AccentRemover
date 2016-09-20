package org.apache.spark.ml.feature

import org.apache.spark.sql.types.{ DataType, StringType, ArrayType }
import org.apache.spark.ml.util.Identifiable
import org.apache.spark.ml.param.{ Param, ParamMap }
import org.apache.spark.ml.UnaryTransformer

class AccentRemover(override val uid: String) extends UnaryTransformer[Seq[String], Seq[String], AccentRemover] {

  def this() = this(Identifiable.randomUID("mot"))

  override protected def createTransformFunc: Seq[String] => Seq[String] = {
    originStr =>
      try {
        originStr.map(f =>
          f.replaceAll("ā|á|â|à|ä", "a")
            .replaceAll("é|è|ê|ë", "e")
            .replaceAll("ī|í|î|ì|ï", "i")
            .replaceAll("û|ü|ù", "u")
            .replaceAll("ô|ö", "o"))
      } catch {
        case e: Exception => originStr
      }

  }
  override protected def validateInputType(inputType: DataType): Unit = {
    require(inputType.sameType(ArrayType(StringType)), s"Input type must be string type but got $inputType.")
  }
  override protected def outputDataType: DataType = new ArrayType(StringType, true)
  override def copy(extra: ParamMap): AccentRemover = defaultCopy(extra)
}
