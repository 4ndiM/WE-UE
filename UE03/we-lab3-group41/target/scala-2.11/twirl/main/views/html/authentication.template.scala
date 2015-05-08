
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
import scala.collection._
import at.ac.tuwien.big.we15.lab2.api._

/**/
object authentication extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[RealUser],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(userform: Form[RealUser]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {
implicit def /*2.2*/implicitField/*2.15*/ = {{ helper.FieldConstructor(html.AuthConstructorTemplate.f) }};
Seq[Any](format.raw/*1.28*/("""
"""),format.raw/*2.78*/("""

"""),format.raw/*4.1*/("""<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="de" lang="de">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Business Informatics Group Jeopardy! - Login</title>
    <link rel="stylesheet" type="text/css" href=""""),_display_(/*11.51*/routes/*11.57*/.Assets.at("stylesheets/base.css")),format.raw/*11.91*/("""" />
    <link rel="stylesheet" type="text/css" href=""""),_display_(/*12.51*/routes/*12.57*/.Assets.at("stylesheets/screen.css")),format.raw/*12.93*/("""" />
</head>

<body id="login-page">
<a class="accessibility" href="#login">Zum Login springen</a>
<a class="accessibility" title="Klicke hier um dich zu registrieren" href="register.xhtml" accesskey="r">Registrieren</a>
<!-- Header -->
<header role="banner" aria-labelledby="bannerheading">
    <h1 id="bannerheading">
        <span class="accessibility">Business Informatics Group </span><span class="gametitle">Jeopardy!</span>
    </h1>
</header>

<!-- Content -->
<div role="main">
    <section id="login" aria-labelledby="loginheading">
        <h2 id="loginheading" class="accessibility">Login</h2>
        <fieldset>
            """),_display_(/*30.14*/helper/*30.20*/.form(action= routes.Application.signin())/*30.62*/{_display_(Seq[Any](format.raw/*30.63*/("""
                """),format.raw/*31.17*/("""<legend id="logindata">Login</legend>
                """),_display_(/*32.18*/helper/*32.24*/.inputText(userform("username"), '_label -> "Benutzername:")),format.raw/*32.84*/("""
                """),_display_(/*33.18*/helper/*33.24*/.inputPassword(userform("password"), '_label -> "Passwort:")),format.raw/*33.84*/("""
                """),format.raw/*34.17*/("""<input name="login" id="loginsubmit" class="greenlink formlink clickable" type="submit" value="Anmelden"/>
        </fieldset>
        """)))}),format.raw/*36.10*/("""

        """),format.raw/*38.9*/("""<!--<form action="/signin" method="post">
            <fieldset>
                <legend id="logindata">Login</legend>
                <label for="username">Benutzername:</label>
                <input name="username" id="username" type="text" required="required"/>
                <label for="password">Passwort:</label>
                <input name="password" id="password" type="password" required="required"/>
                <input name="login" id="loginsubmit" class="greenlink formlink clickable" type="submit" value="Anmelden"/>
            </fieldset>
        </form>-->
    </section>
    <!-- Register section -->
    <section id="registerforward" aria-labelledby="registerheading">
        <h2 id="registerheading" class="accessibility">Registrierung</h2>
        <p id="registerhint">Nicht registriert?</p>
        <a class="contentlink orangelink" title="Klicke hier um dich zu registrieren" href="/register" accesskey="r">Zur Registrierung</a>
    </section>
</div>

<!-- footer -->
<footer role="contentinfo">© 2015 BIG Jeopardy</footer>
</body>
</html>
"""))}
  }

  def render(userform:Form[RealUser]): play.twirl.api.HtmlFormat.Appendable = apply(userform)

  def f:((Form[RealUser]) => play.twirl.api.HtmlFormat.Appendable) = (userform) => apply(userform)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Fri May 08 14:16:50 CEST 2015
                  SOURCE: /Volumes/BoxCryptor/Uni/Aktuell/Web Engineering/WE-UE/UE03/we-lab3-group41/app/views/authentication.scala.html
                  HASH: 0568203a97fc5fbf2d8a855faaa0b911dadac5cb
                  MATRIX: 806->1|912->29|933->42|1026->27|1054->105|1082->107|1458->456|1473->462|1528->496|1610->551|1625->557|1682->593|2347->1231|2362->1237|2413->1279|2452->1280|2497->1297|2579->1352|2594->1358|2675->1418|2720->1436|2735->1442|2816->1502|2861->1519|3028->1655|3065->1665
                  LINES: 28->1|30->2|30->2|31->1|32->2|34->4|41->11|41->11|41->11|42->12|42->12|42->12|60->30|60->30|60->30|60->30|61->31|62->32|62->32|62->32|63->33|63->33|63->33|64->34|66->36|68->38
                  -- GENERATED --
              */
          