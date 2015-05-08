
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
object question extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="de" lang="de">
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Business Informatics Group Jeopardy! - Fragenbeantwortung</title>
        <link rel="stylesheet" type="text/css" href="style/base.css" />
        <link rel="stylesheet" type="text/css" href="style/screen.css" />
        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="js/framework.js" type="text/javascript"></script>
    </head>
    <body id="question-page">
      <a class="accessibility" href="#questions">Zur Fragenauswahl springen</a>
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
         <!-- info -->
         <section id="gameinfo" aria-labelledby="gameinfoinfoheading">
            <h2 id="gameinfoinfoheading" class="accessibility">Spielinformationen</h2>
            <section id="firstplayer" class="playerinfo leader" aria-labelledby="firstplayerheading">
               <h3 id="firstplayerheading" class="accessibility">Führender Spieler</h3>
               <img class="avatar" src="img/avatar/black-widow_head.png" alt="Spieler-Avatar Black Widow" />
               <table>
                  <tr>
                     <th class="accessibility">Spielername</th>
                     <td class="playername">Black Widow (Du)</td>
                  </tr>
                  <tr>
                     <th class="accessibility">Spielerpunkte</th>
                     <td class="playerpoints">2000 €</td>
                  </tr>
               </table>
            </section>
            <section id="secondplayer" class="playerinfo" aria-labelledby="secondplayerheading">
               <h3 id="secondplayerheading" class="accessibility">Zweiter Spieler</h3>
               <img class="avatar" src="img/avatar/deadpool_head.png" alt="Spieler-Avatar Deadpool" />
               <table>
                  <tr>
                     <th class="accessibility">Spielername</th>
                     <td class="playername">Deadpool</td>
                  </tr>
                  <tr>
                     <th class="accessibility">Spielerpunkte</th>
                     <td class="playerpoints">400 €</td>
                  </tr>
               </table>
            </section>
            <p id="round">Frage: 3 / 10</p>
         </section>
            
      <!-- Question -->
      <section id="question" aria-labelledby="questionheading">
            <form id="questionform" action="jeopardy.xhtml" method="get">
               <h2 id="questionheading" class="accessibility">Frage</h2>
               <p id="questiontype">TUWIEN für € 300</p>
               <p id="questiontext">Diese Lehrveranstaltungen bilden das Modul EWA.</p>
               <ul id="answers">
                  <li><input name="answers" id="answer_1" value="1" type="checkbox"/><label class="tile clickable" for="answer_1">Was ist IT Strategie?</label></li>
                  <li><input name="answers" id="answer_2" value="2" type="checkbox"/><label class="tile clickable" for="answer_2">Was ist Web Engineering?</label></li>
                  <li><input name="answers" id="answer_3" value="3" type="checkbox"/><label class="tile clickable" for="answer_3">Was ist Semistrukturierte Daten?</label></li>
                  <li><input name="answers" id="answer_4" value="4" type="checkbox"/><label class="tile clickable" for="answer_4">Was ist Objektorientierte Modellierung?</label></li>
               </ul>
               <input id="timeleftvalue" type="hidden" value="100"/>
               <input class="greenlink formlink clickable" name="answer_submit" id="next" type="submit" value="antworten" accesskey="s"/>
            </form>
         </section>
            
         <section id="timer" aria-labelledby="timerheading">
            <h2 id="timerheading" class="accessibility">Timer</h2>
            <p><span id="timeleftlabel">Verbleibende Zeit:</span> <time id="timeleft">00:30</time></p>
            <meter id="timermeter" min="0" low="20" value="100" max="100"/>
         </section>
      </div>

      <!-- footer -->
      <footer role="contentinfo">© 2015 BIG Jeopardy!</footer>
        
      <script type="text/javascript">
            //<![CDATA[
            
            // initialize time
            $(document).ready(function() """),format.raw/*97.42*/("""{"""),format.raw/*97.43*/("""
                """),format.raw/*98.17*/("""var maxtime = 30;
                var hiddenInput = $("#timeleftvalue");
                var meter = $("#timer meter");
                var timeleft = $("#timeleft");
                
                hiddenInput.val(maxtime);
                meter.val(maxtime);
                meter.attr('max', maxtime);
                meter.attr('low', maxtime/100*20);
                timeleft.text(secToMMSS(maxtime));
            """),format.raw/*108.13*/("""}"""),format.raw/*108.14*/(""");
            
            // update time
            function timeStep() """),format.raw/*111.33*/("""{"""),format.raw/*111.34*/("""
                """),format.raw/*112.17*/("""var hiddenInput = $("#timeleftvalue");
                var meter = $("#timer meter");
                var timeleft = $("#timeleft");
                
                var value = $("#timeleftvalue").val();
                if(value > 0) """),format.raw/*117.31*/("""{"""),format.raw/*117.32*/("""
                    """),format.raw/*118.21*/("""value = value - 1;   
                """),format.raw/*119.17*/("""}"""),format.raw/*119.18*/("""
                
                """),format.raw/*121.17*/("""hiddenInput.val(value);
                meter.val(value);
                timeleft.text(secToMMSS(value));
                
                if(value <= 0) """),format.raw/*125.32*/("""{"""),format.raw/*125.33*/("""
                    """),format.raw/*126.21*/("""$('#questionform').submit();
                """),format.raw/*127.17*/("""}"""),format.raw/*127.18*/("""
            """),format.raw/*128.13*/("""}"""),format.raw/*128.14*/("""
            
            """),format.raw/*130.13*/("""window.setInterval(timeStep, 1000);
            
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
                  DATE: Fri May 08 11:10:33 CEST 2015
                  SOURCE: /Volumes/BoxCryptor/Uni/Aktuell/Web Engineering/WE-UE/UE03/we-lab3-group41/app/views/question.scala.html
                  HASH: 611734912d3b9688f21a5fe8fc937200787f8db3
                  MATRIX: 867->0|5912->5017|5941->5018|5986->5035|6435->5455|6465->5456|6569->5531|6599->5532|6645->5549|6909->5784|6939->5785|6989->5806|7056->5844|7086->5845|7149->5879|7333->6034|7363->6035|7413->6056|7487->6101|7517->6102|7559->6115|7589->6116|7644->6142
                  LINES: 31->1|127->97|127->97|128->98|138->108|138->108|141->111|141->111|142->112|147->117|147->117|148->118|149->119|149->119|151->121|155->125|155->125|156->126|157->127|157->127|158->128|158->128|160->130
                  -- GENERATED --
              */
          