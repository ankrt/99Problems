name := "99Problems"

version := "1.0"

scalaVersion := "2.12.2"

libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.1" % "test"

scalacOptions ++= Seq(
  "-feature"
  , "-language:implicitConversions"
)
