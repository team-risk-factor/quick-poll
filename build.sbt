name := "spring-boot-scala-web"

version := "1.0"

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  "javax.inject" % "javax.inject" % "1",
  "org.springframework.boot" % "spring-boot-starter-data-jpa" % "1.5.4.RELEASE",
  "org.springframework.boot" % "spring-boot-starter-web" % "1.5.4.RELEASE",
  "hsqldb" % "hsqldb" % "1.8.0.10"
)
