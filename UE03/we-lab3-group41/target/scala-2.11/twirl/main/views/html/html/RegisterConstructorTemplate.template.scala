
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
object RegisterConstructorTemplate extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[views.html.helper.FieldElements,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(elements: views.html.helper.FieldElements):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import views.html.helper._

Seq[Any](format.raw/*1.45*/("""
"""),format.raw/*3.1*/("""
"""),_display_(/*4.2*/if(elements.id == "gender")/*4.29*/{_display_(Seq[Any](format.raw/*4.30*/("""
"""),format.raw/*5.1*/("""<fieldset class="inputset">
    """),_display_(/*6.6*/elements/*6.14*/.input),format.raw/*6.20*/("""
    """),format.raw/*7.5*/("""</fieldset>
""")))}/*8.3*/else/*8.8*/{_display_(_display_(/*8.10*/if(elements.id == "username" || elements.id == "password")/*8.68*/{_display_(Seq[Any](format.raw/*8.69*/("""
"""),format.raw/*9.1*/("""<label for=""""),_display_(/*9.14*/elements/*9.22*/.id),format.raw/*9.25*/("""">"""),_display_(/*9.28*/elements/*9.36*/.label),format.raw/*9.42*/("""*:</label>
"""),_display_(/*10.2*/elements/*10.10*/.input),format.raw/*10.16*/("""
""")))}/*11.3*/else/*11.8*/{_display_(Seq[Any](format.raw/*11.9*/("""
"""),format.raw/*12.1*/("""<label for=""""),_display_(/*12.14*/elements/*12.22*/.id),format.raw/*12.25*/("""">"""),_display_(/*12.28*/elements/*12.36*/.label),format.raw/*12.42*/(""": </label>
"""),_display_(/*13.2*/elements/*13.10*/.input),format.raw/*13.16*/("""
""")))}))}))}
  }

  def render(elements:views.html.helper.FieldElements): play.twirl.api.HtmlFormat.Appendable = apply(elements)

  def f:((views.html.helper.FieldElements) => play.twirl.api.HtmlFormat.Appendable) = (elements) => apply(elements)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Fri May 08 15:16:12 CEST 2015
                  SOURCE: /Volumes/BoxCryptor/Uni/Aktuell/Web Engineering/WE-UE/UE03/we-lab3-group41/app/views/html/RegisterConstructorTemplate.scala.html
                  HASH: 2a21f91c4088a7f9ceb5ba0479acf832c042fd79
                  MATRIX: 841->1|998->44|1025->73|1052->75|1087->102|1125->103|1152->104|1210->137|1226->145|1252->151|1283->156|1313->170|1324->175|1353->177|1419->235|1457->236|1484->237|1523->250|1539->258|1562->261|1591->264|1607->272|1633->278|1671->290|1688->298|1715->304|1735->307|1747->312|1785->313|1813->314|1853->327|1870->335|1894->338|1924->341|1941->349|1968->355|2006->367|2023->375|2050->381
                  LINES: 28->1|31->1|32->3|33->4|33->4|33->4|34->5|35->6|35->6|35->6|36->7|37->8|37->8|37->8|37->8|37->8|38->9|38->9|38->9|38->9|38->9|38->9|38->9|39->10|39->10|39->10|40->11|40->11|40->11|41->12|41->12|41->12|41->12|41->12|41->12|41->12|42->13|42->13|42->13
                  -- GENERATED --
              */
          