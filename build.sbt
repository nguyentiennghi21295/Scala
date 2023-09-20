ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"

lazy val root = (project in file("."))
  .settings(
    name := "Scala-project-1"
  )
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test"