name := "Technogise-Apr-2021"

version := "0.1"

scalaVersion := "2.13.5"

libraryDependencies ++= Seq(
  "org.scoverage" %% "scalac-scoverage-runtime" % "1.4.2" % "provided",
  "org.scalatest" %% "scalatest" % "3.0.8" % Test
)

enablePlugins(JavaAppPackaging)

