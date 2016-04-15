package spray.server

import akka.actor.Actor
import spray.routing._
import spray.http._

class ServiceActor extends Actor with HttpService {
  private val route =
    pathSingleSlash {
      get {
        complete("Hello world!")
      }
    }

  def actorRefFactory = context
  def receive = runRoute(route)
}
