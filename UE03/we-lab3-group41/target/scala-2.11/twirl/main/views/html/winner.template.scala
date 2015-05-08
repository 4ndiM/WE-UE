
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
object winner extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="de" lang="de">
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Business Informatics Group Jeopardy! - Gewinnanzeige</title>
        <link rel="stylesheet" type="text/css" href="style/base.css" />
        <link rel="stylesheet" type="text/css" href="style/screen.css" />
		  <script src="js/jquery.js" type="text/javascript"></script>
        <script src="js/framework.js" type="text/javascript"></script>
    </head>
    <body id="winner-page">
      <a class="accessibility" href="#winner">Zur Gewinnanzeige springen</a>
      <!-- Header -->
      <header role="banner" aria-labelledby="bannerheading">
         <h1 id="bannerheading">
            <span class="accessibility">Business Informatics Group </span><span class="gametitle">Jeopardy!</span>
         </h1>
      </header>
      
      <!-- Navigation -->
		<nav role="navigation" aria-labelledby="navheading">
			<h2 id="navheading" class="accessibility">Navigation</h2>
			<ul>
				<li><a class="orangelink navigationlink" id="logoutlink" title="Klicke hier um dich abzumelden" href="login.xhtml" accesskey="l">Abmelden</a></li>
			</ul>
		</nav>
      
      <!-- Content -->
      <div role="main">
         <section id="gameinfo" aria-labelledby="winnerinfoheading">
            <h2 id="winnerinfoheading" class="accessibility">Gewinnerinformationen</h2>
            <p class="realUser-info positive-change">Du hast richtig geantwortet: +1000 €</p>
            <p class="realUser-info negative-change">Deadpool hat falsch geantwortet: -500 €</p>
            <section class="playerinfo leader" aria-labelledby="winnerannouncement">
               <h3 id="winnerannouncement">Gewinner: Black Widow</h3>
               <img class="avatar" src="img/avatar/black-widow.png" alt="Spieler-Avatar Black Widow" />
               <table>
                  <tr>
                     <th class="accessibility">Spielername</th>
                     <td class="playername">Black Widow</td>
                  </tr>
                  <tr>
                     <th class="accessibility">Spielerpunkte</th>
                     <td class="playerpoints">€ 2000</td>
                  </tr>
               </table>
            </section>
            <section class="playerinfo" aria-labelledby="loserheading">
               <h3 id="loserheading" class="accessibility">Verlierer: Deadpool</h3>
               <img class="avatar" src="img/avatar/deadpool_head.png" alt="Spieler-Avatar Deadpool" />
               <table>
                  <tr>
                     <th class="accessibility">Spielername</th>
                     <td class="playername">Deadpool</td>
                  </tr>
                  <tr>
                     <th class="accessibility">Spielerpunkte</th>
                     <td class="playerpoints">€ 400</td>
                  </tr>
               </table>
            </section>
         </section>
         <section id="newgame" aria-labelledby="newgameheading">
             <h2 id="newgameheading" class="accessibility">Neues Spiel</h2>
         	<form action="jeopardy.xhtml" method="post">
               	<input class="clickable orangelink contentlink" id="new_game" type="submit" name="restart" value="Neues Spiel" />
            </form>
         </section>
      </div>
        <!-- footer -->
        <footer role="contentinfo">© 2015 BIG Jeopardy</footer>  
		<script type="text/javascript">
        //<![CDATA[
           $(document).ready(function()"""),format.raw/*76.40*/("""{"""),format.raw/*76.41*/("""
         	   """),format.raw/*77.14*/("""if(supportsLocalStorage())"""),format.raw/*77.40*/("""{"""),format.raw/*77.41*/("""
         		   """),format.raw/*78.15*/("""localStorage["lastGame"] = new Date().getTime();
         	   """),format.raw/*79.14*/("""}"""),format.raw/*79.15*/("""
           """),format.raw/*80.12*/("""}"""),format.raw/*80.13*/(""");
        //]]>
        </script>  
    </body>
</html>
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Fri May 08 11:10:35 CEST 2015
                  SOURCE: /Volumes/BoxCryptor/Uni/Aktuell/Web Engineering/WE-UE/UE03/we-lab3-group41/app/views/winner.scala.html
                  HASH: e1ca0f76797f538fbba88d3a5052acedab467102
                  MATRIX: 865->0|4526->3633|4555->3634|4597->3648|4651->3674|4680->3675|4723->3690|4813->3752|4842->3753|4882->3765|4911->3766
                  LINES: 31->1|106->76|106->76|107->77|107->77|107->77|108->78|109->79|109->79|110->80|110->80
                  -- GENERATED --
              */
          