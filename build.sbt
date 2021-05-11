name := "Technogise-Apr-2021"

version := "0.1"

scalaVersion := "2.13.5"

libraryDependencies ++= Seq(
  "org.scoverage" %% "scalac-scoverage-runtime" % "1.4.2" % "provided",
  "org.scalatest" %% "scalatest" % "3.0.8" % Test
)

enablePlugins(JavaAppPackaging)

// heroku deployment configs
herokuAppName in Compile := "Technogise-Apr-2021" // unique Heroku app name
herokuJdkVersion in Compile := "1.8"
herokuConfigVars in Compile := Map(
  "HOST" -> "0.0.0.0"
)
herokuProcessTypes in Compile := Map(
  "web" -> "target/universal/stage/bin/Technogise-Apr-2021" // project name
)