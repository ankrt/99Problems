name := "99Problems"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

scalacOptions ++= Seq(
  "-feature"
  , "-language:implicitConversions"
)
