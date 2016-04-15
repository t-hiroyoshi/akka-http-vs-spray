package akka.server

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

object Boot extends App {
  implicit lazy val system = ActorSystem("akka-server")
  implicit lazy val materializer = ActorMaterializer()
  implicit val ec = system.dispatcher

  private val route =
    pathSingleSlash {
      get {
        complete("Hello world!")
      }
    }

  Http().bindAndHandle(route, "localhost", 8080)
}
