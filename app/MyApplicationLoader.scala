import play.api._
import play.api.ApplicationLoader.Context
import play.filters.HttpFiltersComponents
import router.Routes
import com.softwaremill.macwire._
import play.api.routing.Router

class MyApplicationLoader extends ApplicationLoader {
  def load(context: Context) = {
    new MyComponents(context).application
  }
}

class MyComponents(context: Context) extends BuiltInComponentsFromContext(context) with HttpFiltersComponents {
  val prefix: String      = "/"
  lazy val router: Router = wire[Routes]
}
