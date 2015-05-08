
package views.html.html

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
object AuthConstructorTemplate extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[views.html.helper.FieldElements,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(elements: views.html.helper.FieldElements):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import views.html.helper._

Seq[Any](format.raw/*1.45*/("""
"""),format.raw/*3.1*/("""
  """),format.raw/*4.3*/("""<!--  """),_display_(/*4.10*/if(elements.id == "username")/*4.39*/{_display_(Seq[Any](format.raw/*4.40*/("""
        """),format.raw/*5.9*/("""<label for=""""),_display_(/*5.22*/elements/*5.30*/.id),format.raw/*5.33*/("""">Benutzername: </label>
    """)))}/*6.6*/else/*6.11*/{_display_(Seq[Any](format.raw/*6.12*/("""
        """),format.raw/*7.9*/("""<label for=""""),_display_(/*7.22*/elements/*7.30*/.id),format.raw/*7.33*/("""">Passwort: </label>

    """)))}),format.raw/*9.6*/("""
    """),_display_(/*10.6*/elements/*10.14*/.input),format.raw/*10.20*/("""-->

<label for=""""),_display_(/*12.14*/elements/*12.22*/.id),format.raw/*12.25*/("""">"""),_display_(/*12.28*/elements/*12.36*/.label),format.raw/*12.42*/(""" """),format.raw/*12.43*/("""</label>
"""),_display_(/*13.2*/elements/*13.10*/.input))}
  }

  def render(elements:views.html.helper.FieldElements): play.twirl.api.HtmlFormat.Appendable = apply(elements)

  def f:((views.html.helper.FieldElements) => play.twirl.api.HtmlFormat.Appendable) = (elements) => apply(elements)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Fri May 08 14:16:52 CEST 2015
                  SOURCE: /Volumes/BoxCryptor/Uni/Aktuell/Web Engineering/WE-UE/UE03/we-lab3-group41/app/views/html/AuthConstructorTemplate.scala.html
                  HASH: 1e7b7247627651680e9ff38dabb6697a2784b75a
                  MATRIX: 837->1|994->44|1021->73|1050->76|1083->83|1120->112|1158->113|1193->122|1232->135|1248->143|1271->146|1318->176|1330->181|1368->182|1403->191|1442->204|1458->212|1481->215|1537->242|1569->248|1586->256|1613->262|1658->280|1675->288|1699->291|1729->294|1746->302|1773->308|1802->309|1838->319|1855->327
                  LINES: 28->1|31->1|32->3|33->4|33->4|33->4|33->4|34->5|34->5|34->5|34->5|35->6|35->6|35->6|36->7|36->7|36->7|36->7|38->9|39->10|39->10|39->10|41->12|41->12|41->12|41->12|41->12|41->12|41->12|42->13|42->13
                  -- GENERATED --
              */
          