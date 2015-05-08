
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
object jeopardy extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[at.ac.tuwien.big.we15.lab2.api.JeopardyGame,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(game:at.ac.tuwien.big.we15.lab2.api.JeopardyGame):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.52*/("""
"""),format.raw/*2.1*/("""<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="de" lang="de">
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Business Informatics Group Jeopardy! - Fragenauswahl</title>
        <link rel="stylesheet" type="text/css" href=""""),_display_(/*9.55*/routes/*9.61*/.Assets.at("stylesheets/base.css")),format.raw/*9.95*/("""" />
        <link rel="stylesheet" type="text/css" href=""""),_display_(/*10.55*/routes/*10.61*/.Assets.at("stylesheets/screen.css")),format.raw/*10.97*/(""""
        <script src=""""),_display_(/*11.23*/routes/*11.29*/.Assets.at("javascripts/jquery.js")),format.raw/*11.64*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*12.23*/routes/*12.29*/.Assets.at("javascripts/framework.js")),format.raw/*12.67*/("""" type="text/javascript"></script>
   </head>
   <body id="selection-page">
      <a class="accessibility" href="#question-selection">Zur Fragenauswahl springen</a>
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
				<li><a class="orangelink navigationlink" id="logoutlink" title="Klicke hier um dich abzumelden" href="#" accesskey="l">Abmelden</a></li>
			</ul>
		</nav>
      
      <!-- Content -->
      <div role="main"> 
         <!-- info -->
         <section id="gameinfo" aria-labelledby="gameinfoinfoheading">
            <h2 id="gameinfoinfoheading" class="accessibility">Spielinformationen</h2>
            <section id="firstplayer" class="playerinfo leader" aria-labelledby="firstplayerheading">
               <h3 id="firstplayerheading" class="accessibility">Führender Spieler</h3>
               <img class="avatar" src=""""),_display_(/*38.42*/routes/*38.48*/.Assets.at("images/avatar/" + game.getHuman().getAvatar().getImageHead())),format.raw/*38.121*/("""" alt="Spieler-Avatar """),_display_(/*38.144*/game/*38.148*/.getHuman().getName()),format.raw/*38.169*/("""" />
               <table>
                  <tr>
                     <th class="accessibility">Spielername</th>
                     <td class="playername">"""),_display_(/*42.46*/game/*42.50*/.getHuman().getName()),format.raw/*42.71*/("""</td>
                  </tr>
                  <tr>
                     <th class="accessibility">Spielerpunkte</th>
                     <td class="playerpoints">"""),_display_(/*46.48*/game/*46.52*/.getHumanPlayer.getProfit()),format.raw/*46.79*/(""" """),format.raw/*46.80*/("""€</td>
                  </tr>
               </table>
            </section>
            <section id="secondplayer" class="playerinfo" aria-labelledby="secondplayerheading">
               <h3 id="secondplayerheading" class="accessibility">Zweiter Spieler</h3>
               <img class="avatar" src=""""),_display_(/*52.42*/routes/*52.48*/.Assets.at("images/avatar/" + game.getMarvin().getAvatar().getImageHead())),format.raw/*52.122*/("""" alt="Spieler-Avatar """),_display_(/*52.145*/game/*52.149*/.getMarvin().getName()),format.raw/*52.171*/("""" />
               <table>
                  <tr>
                     <th class="accessibility">Spielername</th>
                     <td class="playername">"""),_display_(/*56.46*/game/*56.50*/.getMarvin().getName()),format.raw/*56.72*/("""</td>
                  </tr>
                  <tr>
                     <th class="accessibility">Spielerpunkte</th>
                     <td class="playerpoints">"""),_display_(/*60.48*/game/*60.52*/.getMarvinPlayer.getProfit()),format.raw/*60.80*/(""" """),format.raw/*60.81*/("""€</td>
                  </tr>
               </table>
            </section>
            <p id="round">Fragen: 2 / """),_display_(/*64.40*/game/*64.44*/.getMaxQuestions()),format.raw/*64.62*/("""</p>
         </section>

         <!-- Question -->
         <section id="question-selection" aria-labelledby="questionheading">
            <h2 id="questionheading" class="black accessibility">Jeopardy</h2>
             """),_display_(/*70.15*/if(!game.isRoundStart())/*70.39*/ {_display_(Seq[Any](format.raw/*70.41*/("""
                """),_display_(/*71.18*/if(game.getHumanPlayer().getLatestProfitChange() > 0)/*71.71*/ {_display_(Seq[Any](format.raw/*71.73*/("""
                 """),format.raw/*72.18*/("""<p class="realUser-info positive-change">Du hast richtig geantwortet: +"""),_display_(/*72.90*/game/*72.94*/.getHumanPlayer().getLatestProfitChange()),format.raw/*72.135*/(""" """),format.raw/*72.136*/("""€</p>
                """)))}/*73.19*/else/*73.24*/{_display_(Seq[Any](format.raw/*73.25*/("""
                 """),format.raw/*74.18*/("""<p class="realUser-info negative-change">Du hast falsch geantwortet: """),_display_(/*74.88*/game/*74.92*/.getHumanPlayer().getLatestProfitChange()),format.raw/*74.133*/(""" """),format.raw/*74.134*/("""€</p>
                """)))}),format.raw/*75.18*/("""

                 """),_display_(/*77.19*/if(game.getMarvinPlayer().getLatestProfitChange() > 0)/*77.73*/ {_display_(Seq[Any](format.raw/*77.75*/("""
                 """),format.raw/*78.18*/("""<p class="realUser-info positive-change">"""),_display_(/*78.60*/game/*78.64*/.getMarvin().getName()),format.raw/*78.86*/(""" """),format.raw/*78.87*/("""hat richtig geantwortet: +"""),_display_(/*78.114*/game/*78.118*/.getMarvinPlayer().getLatestProfitChange()),format.raw/*78.160*/(""" """),format.raw/*78.161*/("""€</p>
                 """)))}/*79.20*/else/*79.25*/{_display_(Seq[Any](format.raw/*79.26*/("""
                 """),format.raw/*80.18*/("""<p class="realUser-info negative-change">"""),_display_(/*80.60*/game/*80.64*/.getMarvin().getName()),format.raw/*80.86*/(""" """),format.raw/*80.87*/("""hat falsch geantwortet: """),_display_(/*80.112*/game/*80.116*/.getMarvinPlayer().getLatestProfitChange()),format.raw/*80.158*/(""" """),format.raw/*80.159*/("""€</p>
                 """)))}),format.raw/*81.19*/("""
             """)))}),format.raw/*82.15*/("""
            """),format.raw/*83.13*/("""<!--<p class="realUser-info positive-change">Du hast richtig geantwortet: +1000 €</p>
            <p class="realUser-info negative-change">Deadpool hat falsch geantwortet: -500 €</p>
            <p class="realUser-info">Deadpool hat TUWIEN für € 1000 gewählt.</p>-->
            <form id="questionform" action="question.xhtml" method="post">
               <fieldset>
               <legend class="accessibility">Fragenauswahl</legend>


               """),_display_(/*91.17*/for(c <- game.getCategories()) yield /*91.47*/ {_display_(Seq[Any](format.raw/*91.49*/("""
               """),format.raw/*92.16*/("""<section class="questioncategory" aria-labelledby="tvheading">
                   <h3 id="tvheading" class="tile category-title"><span class="accessibility">Kategorie: </span>"""),_display_(/*93.114*/c/*93.115*/.getName()),format.raw/*93.125*/("""</h3>
                   <ol class="category_questions">
                       """),_display_(/*95.25*/for(q <- c.getQuestions()) yield /*95.51*/ {_display_(Seq[Any](format.raw/*95.53*/("""
                       """),format.raw/*96.24*/("""<li>
                           <input name="question_selection" id="question_"""),_display_(/*97.75*/q/*97.76*/.getId()),format.raw/*97.84*/("""" value=""""),_display_(/*97.94*/q/*97.95*/.getId()),format.raw/*97.103*/("""" type="radio" """),_display_(/*97.119*/if(game.hasBeenChosen(q))/*97.144*/ {_display_(Seq[Any](format.raw/*97.146*/(""" """),format.raw/*97.147*/("""disabled="disabled" """)))}),format.raw/*97.168*/("""/>
                           <label class="tile clickable" for="question_"""),_display_(/*98.73*/q/*98.74*/.getId()),format.raw/*98.82*/("""">€ """),_display_(/*98.87*/q/*98.88*/.getValue()),format.raw/*98.99*/("""</label>
                       </li>
                       """)))}),format.raw/*100.25*/("""
                   """),format.raw/*101.20*/("""</ol>
               </section>
               """)))}),format.raw/*103.17*/("""


               """),format.raw/*106.16*/("""<!--<section class="questioncategory" aria-labelledby="tvheading">
                  <h3 id="tvheading" class="tile category-title"><span class="accessibility">Kategorie: </span>TV</h3>
                  <ol class="category_questions">
                     <li><input name="question_selection" id="question_1" value="1" type="radio" disabled="disabled" /><label class="tile clickable" for="question_1">€ 100</label></li>
                     <li><input name="question_selection" id="question_2" value="2" type="radio"/><label class="tile clickable" for="question_2">€ 200</label></li>
                     <li><input name="question_selection" id="question_3" value="3" type="radio"/><label class="tile clickable" for="question_3">€ 500</label></li>
                     <li><input name="question_selection" id="question_4" value="4" type="radio"/><label class="tile clickable" for="question_4">€ 750</label></li>
                  </ol>
               </section>
               <section class="questioncategory" aria-labelledby="ssdheading">
                  <h3 id="ssdheading" class="tile category-title"><span class="accessibility">Kategorie: </span>SSD</h3>
                  <ol class="category_questions">
                     <li><input name="question_selection" id="question_5" value="5" type="radio" /><label class="tile clickable" for="question_5">€ 100</label></li>
                     <li><input name="question_selection" id="question_6" value="6" type="radio" /><label class="tile clickable" for="question_6">€ 200</label></li>
                     <li><input name="question_selection" id="question_7" value="7" type="radio" /><label class="tile clickable" for="question_7">€ 500</label></li>
                     <li><input name="question_selection" id="question_8" value="8" type="radio" /><label class="tile clickable" for="question_8">€ 750</label></li>
                     <li><input name="question_selection" id="question_9" value="9" type="radio" /><label class="tile clickable" for="question_9">€ 1000</label></li>
                  </ol>
               </section>
               <section class="questioncategory" aria-labelledby="webheading">
                  <h3 id="webheading" class="tile category-title"><span class="accessibility">Kategorie: </span>Web</h3>
                  <ol class="category_questions">
                     <li><input name="question_selection" id="question_10" value="10" type="radio" /><label class="tile clickable" for="question_10">€ 100</label></li>
                     <li><input name="question_selection" id="question_11" value="11" type="radio" /><label class="tile clickable" for="question_11">€ 200</label></li>
                     <li><input name="question_selection" id="question_12" value="12" type="radio" disabled="disabled" /><label class="tile clickable" for="question_12">€ 500</label></li>
                     <li><input name="question_selection" id="question_13" value="13" type="radio" /><label class="tile clickable" for="question_13">€ 750</label></li>
                     <li><input name="question_selection" id="question_14" value="14" type="radio" /><label class="tile clickable" for="question_14">€ 1000</label></li>
                  </ol>
               </section>
               <section class="questioncategory" aria-labelledby="sportheading">
                  <h3 id="sportheading" class="tile category-title"><span class="accessibility">Kategorie: </span>Sport</h3>
                  <ol class="category_questions">
                     <li><input name="question_selection" id="question_15" value="15" type="radio" /><label class="tile clickable" for="question_15">€ 100</label></li>
                     <li><input name="question_selection" id="question_16" value="16" type="radio" disabled="disabled" /><label class="tile clickable" for="question_16">€ 200</label></li>
                     <li><input name="question_selection" id="question_17" value="17" type="radio" /><label class="tile clickable" for="question_17">€ 500</label></li>
                     <li><input name="question_selection" id="question_18" value="18" type="radio" /><label class="tile clickable" for="question_18">€ 750</label></li>
                  </ol>
               </section>
               <section class="questioncategory" aria-labelledby="tuwienheading">
                  <h3 id="tuwienheading" class="tile category-title"><span class="accessibility">Kategorie: </span>TUWIEN</h3>
                  <ol class="category_questions">
                     <li><input name="question_selection" id="question_19" value="19" type="radio" /><label class="tile clickable" for="question_19">€ 100</label></li>
                     <li><input name="question_selection" id="question_20" value="20" type="radio" /><label class="tile clickable" for="question_20">€ 200</label></li>
                     <li><input name="question_selection" id="question_21" value="21" type="radio" /><label class="tile clickable" for="question_21">€ 500</label></li>
                     <li><input name="question_selection" id="question_22" value="22" type="radio" /><label class="tile clickable" for="question_22">€ 750</label></li>
                     <li><input name="question_selection" id="question_23" value="23" type="radio" disabled="disabled" /><label class="tile clickable" for="question_23">€ 1000</label></li>
                  </ol>
               </section> -->
               </fieldset>               
               <input class="greenlink formlink clickable" name="question_submit" id="next" type="submit" value="wählen" accesskey="s" />
            </form>
         </section>
         
         <section id="lastgame" aria-labelledby="lastgameheading">
            <h2 id="lastgameheading" class="accessibility">Letztes Spielinfo</h2>
            <p>Letztes Spiel: Nie</p>
         </section>
		</div>
		
      <!-- footer -->
      <footer role="contentinfo">© 2015 BIG Jeopardy!</footer>
	  
	  <script type="text/javascript">
            //<![CDATA[
            
            // initialize time
            $(document).ready(function() """),format.raw/*172.42*/("""{"""),format.raw/*172.43*/("""
                """),format.raw/*173.17*/("""// set last game
                if(supportsLocalStorage()) """),format.raw/*174.44*/("""{"""),format.raw/*174.45*/("""
	                """),format.raw/*175.18*/("""var lastGameMillis = parseInt(localStorage['lastGame'])
	                if(!isNaN(parseInt(localStorage['lastGame'])))"""),format.raw/*176.64*/("""{"""),format.raw/*176.65*/("""
	                    """),format.raw/*177.22*/("""var lastGame = new Date(lastGameMillis);
	                	$("#lastgame p").replaceWith('<p>Letztes Spiel: <time datetime="'
	                			+ lastGame.toUTCString()
	                			+ '">'
	                			+ lastGame.toLocaleString()
	                			+ '</time></p>')
	                """),format.raw/*183.18*/("""}"""),format.raw/*183.19*/("""
            	"""),format.raw/*184.14*/("""}"""),format.raw/*184.15*/("""
            """),format.raw/*185.13*/("""}"""),format.raw/*185.14*/(""");            
            //]]>
        </script>
    </body>
</html>
"""))}
  }

  def render(game:at.ac.tuwien.big.we15.lab2.api.JeopardyGame): play.twirl.api.HtmlFormat.Appendable = apply(game)

  def f:((at.ac.tuwien.big.we15.lab2.api.JeopardyGame) => play.twirl.api.HtmlFormat.Appendable) = (game) => apply(game)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Fri May 08 18:42:48 CEST 2015
                  SOURCE: /Volumes/BoxCryptor/Uni/Aktuell/Web Engineering/WE-UE/UE03/we-lab3-group41/app/views/jeopardy.scala.html
                  HASH: acdd2eba3771e00fc6b2b1f4968c1807f3d81874
                  MATRIX: 829->1|967->51|994->52|1397->429|1411->435|1465->469|1551->528|1566->534|1623->570|1674->594|1689->600|1745->635|1829->692|1844->698|1903->736|3140->1946|3155->1952|3250->2025|3301->2048|3315->2052|3358->2073|3545->2233|3558->2237|3600->2258|3793->2424|3806->2428|3854->2455|3883->2456|4213->2759|4228->2765|4324->2839|4375->2862|4389->2866|4433->2888|4620->3048|4633->3052|4676->3074|4869->3240|4882->3244|4931->3272|4960->3273|5104->3390|5117->3394|5156->3412|5406->3635|5439->3659|5479->3661|5524->3679|5586->3732|5626->3734|5672->3752|5771->3824|5784->3828|5847->3869|5877->3870|5919->3894|5932->3899|5971->3900|6017->3918|6114->3988|6127->3992|6190->4033|6220->4034|6274->4057|6321->4077|6384->4131|6424->4133|6470->4151|6539->4193|6552->4197|6595->4219|6624->4220|6679->4247|6693->4251|6757->4293|6787->4294|6830->4319|6843->4324|6882->4325|6928->4343|6997->4385|7010->4389|7053->4411|7082->4412|7135->4437|7149->4441|7213->4483|7243->4484|7298->4508|7344->4523|7385->4536|7866->4990|7912->5020|7952->5022|7996->5038|8200->5214|8211->5215|8243->5225|8351->5306|8393->5332|8433->5334|8485->5358|8591->5437|8601->5438|8630->5446|8667->5456|8677->5457|8707->5465|8751->5481|8786->5506|8827->5508|8857->5509|8910->5530|9012->5605|9022->5606|9051->5614|9083->5619|9093->5620|9125->5631|9219->5693|9268->5713|9348->5761|9395->5779|15528->11883|15558->11884|15604->11901|15693->11961|15723->11962|15770->11980|15918->12099|15948->12100|15999->12122|16327->12421|16357->12422|16400->12436|16430->12437|16472->12450|16502->12451
                  LINES: 28->1|31->1|32->2|39->9|39->9|39->9|40->10|40->10|40->10|41->11|41->11|41->11|42->12|42->12|42->12|68->38|68->38|68->38|68->38|68->38|68->38|72->42|72->42|72->42|76->46|76->46|76->46|76->46|82->52|82->52|82->52|82->52|82->52|82->52|86->56|86->56|86->56|90->60|90->60|90->60|90->60|94->64|94->64|94->64|100->70|100->70|100->70|101->71|101->71|101->71|102->72|102->72|102->72|102->72|102->72|103->73|103->73|103->73|104->74|104->74|104->74|104->74|104->74|105->75|107->77|107->77|107->77|108->78|108->78|108->78|108->78|108->78|108->78|108->78|108->78|108->78|109->79|109->79|109->79|110->80|110->80|110->80|110->80|110->80|110->80|110->80|110->80|110->80|111->81|112->82|113->83|121->91|121->91|121->91|122->92|123->93|123->93|123->93|125->95|125->95|125->95|126->96|127->97|127->97|127->97|127->97|127->97|127->97|127->97|127->97|127->97|127->97|127->97|128->98|128->98|128->98|128->98|128->98|128->98|130->100|131->101|133->103|136->106|202->172|202->172|203->173|204->174|204->174|205->175|206->176|206->176|207->177|213->183|213->183|214->184|214->184|215->185|215->185
                  -- GENERATED --
              */
          