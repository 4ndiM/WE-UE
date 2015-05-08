// @SOURCE:/Volumes/BoxCryptor/Uni/Aktuell/Web Engineering/WE-UE/UE03/we-lab3-group41/conf/routes
// @HASH:458d112984df950a624be0d2b4a8ca5442ecacc9
// @DATE:Fri May 08 11:10:29 CEST 2015


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String): Unit = {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
controllers.Application.index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
        

// @LINE:7
private[this] lazy val controllers_Application_registerPage1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("register"))))
private[this] lazy val controllers_Application_registerPage1_invoker = createInvoker(
controllers.Application.registerPage(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "registerPage", Nil,"GET", """""", Routes.prefix + """register"""))
        

// @LINE:9
private[this] lazy val controllers_Application_signin2_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("jeopardy"))))
private[this] lazy val controllers_Application_signin2_invoker = createInvoker(
controllers.Application.signin(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "signin", Nil,"POST", """""", Routes.prefix + """jeopardy"""))
        

// @LINE:10
private[this] lazy val controllers_Application_register3_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("register"))))
private[this] lazy val controllers_Application_register3_invoker = createInvoker(
controllers.Application.register(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "register", Nil,"POST", """""", Routes.prefix + """register"""))
        

// @LINE:13
private[this] lazy val controllers_Assets_at4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at4_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """register""","""controllers.Application.registerPage()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """jeopardy""","""controllers.Application.signin()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """register""","""controllers.Application.register()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(controllers.Application.index())
   }
}
        

// @LINE:7
case controllers_Application_registerPage1_route(params) => {
   call { 
        controllers_Application_registerPage1_invoker.call(controllers.Application.registerPage())
   }
}
        

// @LINE:9
case controllers_Application_signin2_route(params) => {
   call { 
        controllers_Application_signin2_invoker.call(controllers.Application.signin())
   }
}
        

// @LINE:10
case controllers_Application_register3_route(params) => {
   call { 
        controllers_Application_register3_invoker.call(controllers.Application.register())
   }
}
        

// @LINE:13
case controllers_Assets_at4_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at4_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     