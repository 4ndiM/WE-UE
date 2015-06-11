package views.helper

//import views.html.helper.{FieldElements, FieldConstructor}
import play.api.templates.Html
import views.html.html.FormConstructorTemplate

object MyHelpers {
  import views.html.helper.FieldConstructor
  implicit val myFields = FieldConstructor(html.FormConstructorTemplate.f)
}


/*
object MyHelpers {
  import views.html.helper.FieldConstructor
  implicit val myFields = FieldConstructor(html.myFieldConstructorTemplate.f)
}*/
