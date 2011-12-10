// Initial build based largely on https://github.com/schmmd/helloworld-scala-servlet

name := "random-album-cover"

version := "1.0"

scalaVersion := "2.9.1"

// Import web settings from plugin
seq(webSettings :_*)

libraryDependencies ++= Seq(
  "org.scalatra" %% "scalatra" % "2.0.2",
  "org.scalatra" %% "scalatra-scalate" % "2.0.2",
  "org.scalatra" %% "scalatra-specs2" % "2.0.2" % "test",
  "ch.qos.logback" % "logback-classic" % "1.0.0" % "runtime",
  "net.databinder" %% "dispatch-http" % "0.8.6",
  "org.eclipse.jetty" % "jetty-webapp" % "8.0.4.v20111024" % "container",
  "javax.servlet" % "servlet-api" % "2.5" % "provided"
)

resolvers += "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"
