name := "play-pac4j-scala-demo"

version := "7.0.1-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.2"

val playPac4jVersion = "7.0.1"
val pac4jVersion = "3.6.1"
val playVersion = "2.6.6"

libraryDependencies ++= Seq(
  guice,
  ehcache, // or cacheApi
  ws,
  filters,
  specs2 % Test,
  "com.softwaremill.macwire" %% "macros" % "2.3.1" % "provided",
  "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.1" % Test,
  "javax.xml.bind" % "jaxb-api" % "2.2.12",
  "org.pac4j" %% "play-pac4j" % playPac4jVersion,
  "org.pac4j" % "pac4j-http" % pac4jVersion,
  "org.pac4j" % "pac4j-cas" % pac4jVersion,
  "org.pac4j" % "pac4j-openid" % pac4jVersion exclude("xml-apis", "xml-apis"),
  "org.pac4j" % "pac4j-oauth" % pac4jVersion,
  "org.pac4j" % "pac4j-saml" % pac4jVersion,
  "org.pac4j" % "pac4j-oidc" % pac4jVersion exclude("commons-io", "commons-io"),
  "org.pac4j" % "pac4j-gae" % pac4jVersion,
  "org.pac4j" % "pac4j-jwt" % pac4jVersion exclude("commons-io", "commons-io"),
  "org.pac4j" % "pac4j-ldap" % pac4jVersion,
  "org.pac4j" % "pac4j-sql" % pac4jVersion,
  "org.pac4j" % "pac4j-mongo" % pac4jVersion,
  "org.pac4j" % "pac4j-kerberos" % pac4jVersion,
  "org.pac4j" % "pac4j-couch" % pac4jVersion,
  "org.apache.shiro" % "shiro-core" % "1.4.0",
  "com.typesafe.play" % "play-cache_2.12" % playVersion,
  "commons-io" % "commons-io" % "2.5"
)

resolvers ++= Seq(
  Resolver.mavenLocal,
  "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases",
  "Sonatype snapshots repository" at "https://oss.sonatype.org/content/repositories/snapshots/",
  "Shibboleth releases" at "https://build.shibboleth.net/nexus/content/repositories/releases/",
  "MuleSoft" at "https://repository.mulesoft.org/nexus/content/repositories/public/"
)

routesGenerator := InjectedRoutesGenerator

fork in run := true