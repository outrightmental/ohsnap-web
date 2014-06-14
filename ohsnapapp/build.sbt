name := "ohsnapapp"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "org.facebook4j" % "facebook4j-core" % "2.1.0"
)     

play.Project.playScalaSettings
