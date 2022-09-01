ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.13" % "test"
)

lazy val root = (project in file("."))
  .settings(
    name := "shopping-cart"
  )
