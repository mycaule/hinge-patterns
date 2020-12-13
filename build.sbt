import sbt._

import scalariform.formatter.preferences._

scalariformPreferences := scalariformPreferences.value
    .setPreference(AlignSingleLineCaseStatements, true)
    .setPreference(DoubleIndentConstructorArguments, true)
    .setPreference(DanglingCloseParenthesis, Preserve)

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "hinge",
      scalaVersion := "2.13.0",
      version      := "1.0.0"
    )),
    name := "hinge",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.0.8" % Test,
      "org.scala-lang.modules" %% "scala-parallel-collections" % "0.2.0"
    )
  )
