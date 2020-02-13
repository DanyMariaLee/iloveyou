name := "iloveyou"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  "net.sf.sociaal" % "freetts" % "1.2.2",
  "org.scalatest" %% "scalatest" % "3.1.0" % "test"
)

enablePlugins(JavaAppPackaging)