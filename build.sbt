name := "spark-accentremover"

organization := "jouve.bigdata2016"

version := "1.0.0"


scalaVersion := "2.10.6"


libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-sql" % "1.6.1",
  "org.apache.spark" %% "spark-mllib" % "1.6.1"
)