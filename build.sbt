// Initial build based largely on https://github.com/schmmd/helloworld-scala-servlet

name := "random-album-cover"

version := "1.0"

scalaVersion := "2.9.1"

// Import web settings from plugin
seq(webSettings :_*)

libraryDependencies ++= Seq(
  "org.eclipse.jetty" % "jetty-webapp" % "8.0.4.v20111024" % "container",
  "javax.servlet" % "servlet-api" % "2.5" % "provided"
)
