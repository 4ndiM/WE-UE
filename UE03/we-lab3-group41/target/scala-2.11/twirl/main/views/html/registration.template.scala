
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
object registration extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[RealUser],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(userform: Form[RealUser]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {
implicit def /*2.2*/implicitField/*2.15*/ = {{ helper.FieldConstructor(html.RegisterConstructorTemplate.f) }};
Seq[Any](format.raw/*1.28*/("""
"""),format.raw/*2.82*/("""


"""),format.raw/*5.1*/("""<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="de" lang="de">
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Business Informatics Group Jeopardy! - Registrieren</title>
        <link rel="stylesheet" type="text/css" href=""""),_display_(/*12.55*/routes/*12.61*/.Assets.at("stylesheets/base.css")),format.raw/*12.95*/("""" />
        <link rel="stylesheet" type="text/css" href=""""),_display_(/*13.55*/routes/*13.61*/.Assets.at("stylesheets/screen.css")),format.raw/*13.97*/("""" />
        <script src=""""),_display_(/*14.23*/routes/*14.29*/.Assets.at("javascripts/jquery.js")),format.raw/*14.64*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*15.23*/routes/*15.29*/.Assets.at("javascripts/framework.js")),format.raw/*15.67*/("""" type="text/javascript"></script>
    </head>
    <body id="register-page">
      <a title="Zur Registrierung springen" class="accessibility" href="#register">Zur Registrierung springen</a>
      
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
				<li><a class="orangelink navigationlink" id="loginlink" title="Klicke hier um dich anzumelden" href="/" accesskey="l">Anmelden</a></li>
			</ul>
		</nav>
      
      <!-- Content -->
      <div id="register" role="main"> 
            <!-- Register section -->
            <h2 id="registerheading" class="accessibility">Registrierung</h2>
            <fieldset>
                <legend>Persönliche Daten</legend>
            """),_display_(/*41.14*/helper/*41.20*/.form(action= routes.Application.register())/*41.64*/{_display_(Seq[Any](format.raw/*41.65*/("""
                """),_display_(/*42.18*/helper/*42.24*/.inputText(userform("firstname"), '_label -> "Vorname")),format.raw/*42.79*/("""
                """),_display_(/*43.18*/helper/*43.24*/.inputText(userform("lastname"), '_label -> "Nachname")),format.raw/*43.79*/("""
                """),_display_(/*44.18*/helper/*44.24*/.inputDate(userform("birthdate"), '_label -> "Geburtstag")),format.raw/*44.82*/("""

                """),_display_(/*46.18*/helper/*46.24*/.inputRadioGroup(userform("gender"), options = Seq(("m"->"Männlich"),
                                                                        ("f"->"Weiblich")), '_label -> "Geschlecht")),format.raw/*47.117*/("""
                """),format.raw/*48.17*/("""</fieldset>
                <fieldset>
                <legend>Spielerdaten</legend>
                    <label for="avatar">Avatar:</label>
                <select name="avatar">
                    """),_display_(/*53.22*/for(av <- at.ac.tuwien.big.we15.lab2.api.Avatar.values()) yield /*53.79*/{_display_(Seq[Any](format.raw/*53.80*/("""
                    """),format.raw/*54.21*/("""<option value=""""),_display_(/*54.37*/av/*54.39*/.getId()),format.raw/*54.47*/("""">"""),_display_(/*54.50*/av/*54.52*/.getName()),format.raw/*54.62*/("""</option>
                    """)))}),format.raw/*55.22*/("""
                """),format.raw/*56.17*/("""</select>
                """),_display_(/*57.18*/helper/*57.24*/.inputText(userform("username"), '_label -> "Benutzername")),format.raw/*57.83*/("""

                """),_display_(/*59.18*/helper/*59.24*/.inputPassword(userform("password"), '_label -> "Passwort")),format.raw/*59.83*/("""

                """),format.raw/*61.17*/("""<input class="greenlink formlink" type="submit" value="Registrieren" accesskey="s"/>
                <p id="requiredhint">Mit "*" gekennzeichnete Felder sind Pflichtfelder</p>
            """)))}),format.raw/*63.14*/("""
                """),format.raw/*64.17*/("""</fieldset>
            <!--<form action=""""),_display_(/*65.32*/routes/*65.38*/.Application.register()),format.raw/*65.61*/("""" method="post">
                <fieldset>
                    <legend>Persönliche Daten</legend>
                    <label for="firstname">Vorname:</label>
                    <input id="firstname" type="text" name="firstname"/>
                    
                    <label for="lastname">Nachname:</label>
                    <input id="lastname" type="text" name="lastname"/>
                    
                    <label for="birthdate">Geburtstag:</label>
                    <input id="birthdate" type="date" name="birthdate"/>
                    <div id="error_msg_birthdate" class="hide" role="alert">Verwenden Sie bitte folgendes Datumsformat: dd.mm.yyyy (z.B. 24.12.2010).</div>
                    
                    <label>Geschlecht:</label>
                    <fieldset class="inputset">
                        <input type="radio" name="gender" id="male" value="m" checked="checked" />
                        <label for="male">Männlich</label>
                        <input type="radio" name="gender" id="female" value="f" />
                        <label for="female">Weiblich</label>
                    </fieldset>
                    
                    
                </fieldset>
                <fieldset>
                    <legend>Spielerdaten</legend>
                    <label for="avatar">Avatar:</label>
                    <select id="avatar" name="avatar">
                        <option value="aldrich-killian">Aldrich Killian</option>
                        <option value="beetle">Beetle</option>
						<option value="black-widow">Black Widow</option>
						<option value="captain-america">Captain America</option>
						<option value="cyclops">Cyclops</option>
						<option value="deadpool">Deadpool</option>
						<option value="doctor-doom">Doctor Doom</option>
						<option value="doctor-octopus">Doctor Octopus</option>
						<option value="drax">Drax</option>
						<option value="electro">Electro</option>
						<option value="extremis-soldier">Extremis Soldier</option>
						<option value="falcon">Falcon</option>
						<option value="gamora">Gamora</option>
						<option value="green-goblin">Green Goblin</option>
						<option value="groot">Groot</option>
						<option value="hawkeye">Hawkeye</option>
						<option value="hulk">Hulk</option>
						<option value="hydra-henchman">Hydra Henchman</option>
						<option value="iron-fist">Iron Fist</option>
						<option value="iron-man">Iron Man</option>
						<option value="j-jonah-jameson">J. Jonah Jameson</option>
						<option value="loki">Loki</option>
						<option value="magneto">Magneto</option>
						<option value="mary-jane-watson">Mary Jane Watson</option>
						<option value="modok">MODOK</option>
						<option value="nebula">Nebula</option>
						<option value="nick-fury">Nick Fury</option>
						<option value="nova">Nova</option>
						<option value="pepper-potts">Pepper Potts</option>
						<option value="power-man">Power Man</option>
						<option value="red-skull">Red Skull</option>
						<option value="rocket">Rocket Raccoon</option>
						<option value="ronan">Ronan</option>
						<option value="spiderman">Spiderman</option>
						<option value="starlord">Starlord</option>
						<option value="taskmaster">Taskmaster</option>
						<option value="the-mandarin">The Mandarin</option>
						<option value="thor">Thor</option>
						<option value="tony-stark">Tony Stark</option>
						<option value="venom">Venom</option>
						<option value="war-machine">War Machine</option>
						<option value="wolverine">Wolverine</option>
                    </select>
					
					<label for="username">Benutzername*:</label>
                    <input id="username" type="text" required="required" pattern="\w"""),format.raw/*137.85*/("""{"""),format.raw/*137.86*/("""4,8"""),format.raw/*137.89*/("""}"""),format.raw/*137.90*/("""" name="username"/>
                    <div id="error_msg_username" class="hide" role="alert">Der Benutzername muss mindestens 4 Zeichen und darf maximal 8 Zeichen enthalten.</div>
                    
                    <label for="password">Passwort*:</label>
                    <input id="password" type="password" required="required" pattern="\w"""),format.raw/*141.89*/("""{"""),format.raw/*141.90*/("""4,8"""),format.raw/*141.93*/("""}"""),format.raw/*141.94*/("""" name="password"/>
                    <div id="error_msg_password" class="hide" role="alert">Das Passwort muss mindestens 4 Zeichen und darf maximal 8 Zeichen enthalten.</div>
                    <input class="greenlink formlink" type="submit" value="Registrieren" accesskey="s"/>
                    <p id="requiredhint">Mit "*" gekennzeichnete Felder sind Pflichtfelder</p>
                </fieldset>
            </form>
        </div>-->
        <!-- Footer -->
        <footer role="contentinfo">© 2015 BIG Jeopardy</footer>
        
        <script type="text/javascript">
            //<![CDATA[
            
            $(document).ready(function() """),format.raw/*154.42*/("""{"""),format.raw/*154.43*/("""
                """),format.raw/*155.17*/("""if (areAllFieldsValid()) """),format.raw/*155.42*/("""{"""),format.raw/*155.43*/("""
                    """),format.raw/*156.21*/("""$('input[type="submit"]').removeAttr('disabled');
                """),format.raw/*157.17*/("""}"""),format.raw/*157.18*/("""else"""),format.raw/*157.22*/("""{"""),format.raw/*157.23*/("""
                    """),format.raw/*158.21*/("""$('input[type="submit"]').attr('disabled', 'disabled');
                """),format.raw/*159.17*/("""}"""),format.raw/*159.18*/("""
            """),format.raw/*160.13*/("""}"""),format.raw/*160.14*/(""");
            
            function areAllFieldsValid() """),format.raw/*162.42*/("""{"""),format.raw/*162.43*/("""
                """),format.raw/*163.17*/("""var valid;
                if(hasFormValidation())"""),format.raw/*164.40*/("""{"""),format.raw/*164.41*/("""
                    """),format.raw/*165.21*/("""valid = $('form')[0].checkValidity();
                """),format.raw/*166.17*/("""}"""),format.raw/*166.18*/("""else"""),format.raw/*166.22*/("""{"""),format.raw/*166.23*/("""
                    """),format.raw/*167.21*/("""valid = !(isUsernameInvalid($("#username").val()) || isPasswordInvalid($("#password").val()));
                """),format.raw/*168.17*/("""}"""),format.raw/*168.18*/("""
                """),format.raw/*169.17*/("""if(!hasNativeDateInput())"""),format.raw/*169.42*/("""{"""),format.raw/*169.43*/("""
                    """),format.raw/*170.21*/("""valid = valid && !isBirthdayInvalid("birthdate");
                """),format.raw/*171.17*/("""}"""),format.raw/*171.18*/("""
                """),format.raw/*172.17*/("""return valid;
            """),format.raw/*173.13*/("""}"""),format.raw/*173.14*/("""
            
            """),format.raw/*175.13*/("""function updateSubmitState() """),format.raw/*175.42*/("""{"""),format.raw/*175.43*/("""
                """),format.raw/*176.17*/("""if (areAllFieldsValid()) """),format.raw/*176.42*/("""{"""),format.raw/*176.43*/("""
                    """),format.raw/*177.21*/("""$('input[type="submit"]').removeAttr('disabled');
                """),format.raw/*178.17*/("""}"""),format.raw/*178.18*/("""else"""),format.raw/*178.22*/("""{"""),format.raw/*178.23*/("""
                    """),format.raw/*179.21*/("""$('input[type="submit"]').attr('disabled', 'disabled');
                """),format.raw/*180.17*/("""}"""),format.raw/*180.18*/("""
            """),format.raw/*181.13*/("""}"""),format.raw/*181.14*/("""

			"""),format.raw/*183.4*/("""function updateFieldValidity(isInvalid, fieldSelector, messageSelector) """),format.raw/*183.76*/("""{"""),format.raw/*183.77*/("""
                """),format.raw/*184.17*/("""if(isInvalid) """),format.raw/*184.31*/("""{"""),format.raw/*184.32*/("""
                  """),format.raw/*185.19*/("""$(fieldSelector).addClass('error');
                  $(messageSelector).removeClass('hide');
                """),format.raw/*187.17*/("""}"""),format.raw/*187.18*/(""" """),format.raw/*187.19*/("""else """),format.raw/*187.24*/("""{"""),format.raw/*187.25*/("""
                   """),format.raw/*188.20*/("""$(fieldSelector).removeClass('error');
                   $(messageSelector).addClass('hide');
                """),format.raw/*190.17*/("""}"""),format.raw/*190.18*/("""
            """),format.raw/*191.13*/("""}"""),format.raw/*191.14*/("""
            
			"""),format.raw/*193.4*/("""/*
             * Birth Date
             */
            $("#birthdate").keyup(function (event) """),format.raw/*196.52*/("""{"""),format.raw/*196.53*/("""
                """),format.raw/*197.17*/("""if(hasFormValidation())"""),format.raw/*197.40*/("""{"""),format.raw/*197.41*/("""
                    """),format.raw/*198.21*/("""this.setCustomValidity("");
                """),format.raw/*199.17*/("""}"""),format.raw/*199.18*/("""
                
                """),format.raw/*201.17*/("""var isInvalid;
                if(!hasFormValidation() || !hasNativeDateInput())"""),format.raw/*202.66*/("""{"""),format.raw/*202.67*/("""
                    """),format.raw/*203.21*/("""isInvalid = isBirthdayInvalid("birthdate");
                """),format.raw/*204.17*/("""}"""),format.raw/*204.18*/("""else"""),format.raw/*204.22*/("""{"""),format.raw/*204.23*/("""
                    """),format.raw/*205.21*/("""isInvalid = !this.validity.valid;
                """),format.raw/*206.17*/("""}"""),format.raw/*206.18*/("""
                
                """),format.raw/*208.17*/("""updateFieldValidity(isInvalid, "#birthdate", "#error_msg_birthdate");
                updateSubmitState();
            """),format.raw/*210.13*/("""}"""),format.raw/*210.14*/(""");
            
			/*
             * Checks if the input with the given id is a valid birthdate or not
             */
            function isBirthdayInvalid(id)"""),format.raw/*215.43*/("""{"""),format.raw/*215.44*/("""
                """),format.raw/*216.17*/("""re = /^(\d"""),format.raw/*216.27*/("""{"""),format.raw/*216.28*/("""1,2"""),format.raw/*216.31*/("""}"""),format.raw/*216.32*/(""")\.(\d"""),format.raw/*216.38*/("""{"""),format.raw/*216.39*/("""1,2"""),format.raw/*216.42*/("""}"""),format.raw/*216.43*/(""")\.(\d"""),format.raw/*216.49*/("""{"""),format.raw/*216.50*/("""4"""),format.raw/*216.51*/("""}"""),format.raw/*216.52*/(""")$/;
                value = getNormalizedDateString("#"+id);
                console.log(value);
                if (value != '') """),format.raw/*219.34*/("""{"""),format.raw/*219.35*/("""
                    """),format.raw/*220.21*/("""if (regs = value.match(re)) """),format.raw/*220.49*/("""{"""),format.raw/*220.50*/("""
                        """),format.raw/*221.25*/("""if (regs[1] < 1 || regs[1] > 31) """),format.raw/*221.58*/("""{"""),format.raw/*221.59*/("""
                            """),format.raw/*222.29*/("""return true;
                        """),format.raw/*223.25*/("""}"""),format.raw/*223.26*/("""
                        """),format.raw/*224.25*/("""if (regs[2] < 1 || regs[2] > 12) """),format.raw/*224.58*/("""{"""),format.raw/*224.59*/("""
                            """),format.raw/*225.29*/("""return true;
                        """),format.raw/*226.25*/("""}"""),format.raw/*226.26*/("""
                        """),format.raw/*227.25*/("""if (regs[3] < 1902 || regs[3] > (new Date()).getFullYear() + 100) """),format.raw/*227.91*/("""{"""),format.raw/*227.92*/("""
                            """),format.raw/*228.29*/("""return true;
                        """),format.raw/*229.25*/("""}"""),format.raw/*229.26*/("""
                        """),format.raw/*230.25*/("""return false;
                    """),format.raw/*231.21*/("""}"""),format.raw/*231.22*/("""else"""),format.raw/*231.26*/("""{"""),format.raw/*231.27*/("""
                        """),format.raw/*232.25*/("""return true;
                    """),format.raw/*233.21*/("""}"""),format.raw/*233.22*/("""
                """),format.raw/*234.17*/("""}"""),format.raw/*234.18*/(""" """),format.raw/*234.19*/("""else """),format.raw/*234.24*/("""{"""),format.raw/*234.25*/("""
                    """),format.raw/*235.21*/("""return false;
                """),format.raw/*236.17*/("""}"""),format.raw/*236.18*/("""
            """),format.raw/*237.13*/("""}"""),format.raw/*237.14*/("""
            
            """),format.raw/*239.13*/("""/*
             * User Name
             */
            $("#username").keyup(function (event)"""),format.raw/*242.50*/("""{"""),format.raw/*242.51*/("""
                """),format.raw/*243.17*/("""if(hasFormValidation())"""),format.raw/*243.40*/("""{"""),format.raw/*243.41*/("""
                    """),format.raw/*244.21*/("""this.setCustomValidity("");
                """),format.raw/*245.17*/("""}"""),format.raw/*245.18*/("""
                
                """),format.raw/*247.17*/("""var isInvalid;
                if(!hasFormValidation())"""),format.raw/*248.41*/("""{"""),format.raw/*248.42*/("""
                    """),format.raw/*249.21*/("""isInvalid = isUsernameInvalid($(event.target).val());
                """),format.raw/*250.17*/("""}"""),format.raw/*250.18*/("""else"""),format.raw/*250.22*/("""{"""),format.raw/*250.23*/("""
                    """),format.raw/*251.21*/("""isInvalid = !this.validity.valid;
                """),format.raw/*252.17*/("""}"""),format.raw/*252.18*/("""
                
                """),format.raw/*254.17*/("""updateFieldValidity(isInvalid, "#username", "#error_msg_username");                
                updateSubmitState();
            """),format.raw/*256.13*/("""}"""),format.raw/*256.14*/(""");
            
            /*
             *  checks if the given input value is a valid username or not
             */
            function isUsernameInvalid(value) """),format.raw/*261.47*/("""{"""),format.raw/*261.48*/("""
                """),format.raw/*262.17*/("""return value.length < 4 || value.length > 8;
            """),format.raw/*263.13*/("""}"""),format.raw/*263.14*/("""
            
			"""),format.raw/*265.4*/("""/*
             * Password
             */
            $("#password").keyup(function (event)"""),format.raw/*268.50*/("""{"""),format.raw/*268.51*/("""
                """),format.raw/*269.17*/("""if(hasFormValidation())"""),format.raw/*269.40*/("""{"""),format.raw/*269.41*/("""
                    """),format.raw/*270.21*/("""this.setCustomValidity("");
                """),format.raw/*271.17*/("""}"""),format.raw/*271.18*/("""
                
                """),format.raw/*273.17*/("""var isInvalid;
                if(!hasFormValidation())"""),format.raw/*274.41*/("""{"""),format.raw/*274.42*/("""
                    """),format.raw/*275.21*/("""isInvalid = isPasswordInvalid($(event.target).val());
                """),format.raw/*276.17*/("""}"""),format.raw/*276.18*/("""else"""),format.raw/*276.22*/("""{"""),format.raw/*276.23*/("""
                    """),format.raw/*277.21*/("""isInvalid = !this.validity.valid;
                """),format.raw/*278.17*/("""}"""),format.raw/*278.18*/("""
                
                """),format.raw/*280.17*/("""updateFieldValidity(isInvalid, "#password", "#error_msg_password");                
                updateSubmitState();
            """),format.raw/*282.13*/("""}"""),format.raw/*282.14*/(""");
            
            /*
             *   checks if the given input value is a valid username or not
             */
            function isPasswordInvalid(value) """),format.raw/*287.47*/("""{"""),format.raw/*287.48*/("""
                """),format.raw/*288.17*/("""return value.length < 4 || value.length > 8;
            """),format.raw/*289.13*/("""}"""),format.raw/*289.14*/("""
            """),format.raw/*290.13*/("""//]]>
        </script>
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
                  DATE: Fri May 08 15:16:12 CEST 2015
                  SOURCE: /Volumes/BoxCryptor/Uni/Aktuell/Web Engineering/WE-UE/UE03/we-lab3-group41/app/views/registration.scala.html
                  HASH: 54304fb2bc7bf508b720ec29c9277fd0839522ce
                  MATRIX: 804->1|910->29|931->42|1028->27|1056->109|1085->112|1488->488|1503->494|1558->528|1644->587|1659->593|1716->629|1770->656|1785->662|1841->697|1925->754|1940->760|1999->798|3073->1845|3088->1851|3141->1895|3180->1896|3225->1914|3240->1920|3316->1975|3361->1993|3376->1999|3452->2054|3497->2072|3512->2078|3591->2136|3637->2155|3652->2161|3860->2347|3905->2364|4133->2565|4206->2622|4245->2623|4294->2644|4337->2660|4348->2662|4377->2670|4407->2673|4418->2675|4449->2685|4511->2716|4556->2733|4610->2760|4625->2766|4705->2825|4751->2844|4766->2850|4846->2909|4892->2927|5112->3116|5157->3133|5227->3176|5242->3182|5286->3205|9061->6951|9091->6952|9123->6955|9153->6956|9534->7308|9564->7309|9596->7312|9626->7313|10314->7972|10344->7973|10390->7990|10444->8015|10474->8016|10524->8037|10619->8103|10649->8104|10682->8108|10712->8109|10762->8130|10863->8202|10893->8203|10935->8216|10965->8217|11051->8274|11081->8275|11127->8292|11206->8342|11236->8343|11286->8364|11369->8418|11399->8419|11432->8423|11462->8424|11512->8445|11652->8556|11682->8557|11728->8574|11782->8599|11812->8600|11862->8621|11957->8687|11987->8688|12033->8705|12088->8731|12118->8732|12173->8758|12231->8787|12261->8788|12307->8805|12361->8830|12391->8831|12441->8852|12536->8918|12566->8919|12599->8923|12629->8924|12679->8945|12780->9017|12810->9018|12852->9031|12882->9032|12915->9037|13016->9109|13046->9110|13092->9127|13135->9141|13165->9142|13213->9161|13352->9271|13382->9272|13412->9273|13446->9278|13476->9279|13525->9299|13665->9410|13695->9411|13737->9424|13767->9425|13812->9442|13937->9538|13967->9539|14013->9556|14065->9579|14095->9580|14145->9601|14218->9645|14248->9646|14311->9680|14420->9760|14450->9761|14500->9782|14589->9842|14619->9843|14652->9847|14682->9848|14732->9869|14811->9919|14841->9920|14904->9954|15052->10073|15082->10074|15272->10235|15302->10236|15348->10253|15387->10263|15417->10264|15449->10267|15479->10268|15514->10274|15544->10275|15576->10278|15606->10279|15641->10285|15671->10286|15701->10287|15731->10288|15891->10419|15921->10420|15971->10441|16028->10469|16058->10470|16112->10495|16174->10528|16204->10529|16262->10558|16328->10595|16358->10596|16412->10621|16474->10654|16504->10655|16562->10684|16628->10721|16658->10722|16712->10747|16807->10813|16837->10814|16895->10843|16961->10880|16991->10881|17045->10906|17108->10940|17138->10941|17171->10945|17201->10946|17255->10971|17317->11004|17347->11005|17393->11022|17423->11023|17453->11024|17487->11029|17517->11030|17567->11051|17626->11081|17656->11082|17698->11095|17728->11096|17783->11122|17905->11215|17935->11216|17981->11233|18033->11256|18063->11257|18113->11278|18186->11322|18216->11323|18279->11357|18363->11412|18393->11413|18443->11434|18542->11504|18572->11505|18605->11509|18635->11510|18685->11531|18764->11581|18794->11582|18857->11616|19019->11749|19049->11750|19246->11918|19276->11919|19322->11936|19408->11993|19438->11994|19483->12011|19604->12103|19634->12104|19680->12121|19732->12144|19762->12145|19812->12166|19885->12210|19915->12211|19978->12245|20062->12300|20092->12301|20142->12322|20241->12392|20271->12393|20304->12397|20334->12398|20384->12419|20463->12469|20493->12470|20556->12504|20718->12637|20748->12638|20946->12807|20976->12808|21022->12825|21108->12882|21138->12883|21180->12896
                  LINES: 28->1|30->2|30->2|31->1|32->2|35->5|42->12|42->12|42->12|43->13|43->13|43->13|44->14|44->14|44->14|45->15|45->15|45->15|71->41|71->41|71->41|71->41|72->42|72->42|72->42|73->43|73->43|73->43|74->44|74->44|74->44|76->46|76->46|77->47|78->48|83->53|83->53|83->53|84->54|84->54|84->54|84->54|84->54|84->54|84->54|85->55|86->56|87->57|87->57|87->57|89->59|89->59|89->59|91->61|93->63|94->64|95->65|95->65|95->65|167->137|167->137|167->137|167->137|171->141|171->141|171->141|171->141|184->154|184->154|185->155|185->155|185->155|186->156|187->157|187->157|187->157|187->157|188->158|189->159|189->159|190->160|190->160|192->162|192->162|193->163|194->164|194->164|195->165|196->166|196->166|196->166|196->166|197->167|198->168|198->168|199->169|199->169|199->169|200->170|201->171|201->171|202->172|203->173|203->173|205->175|205->175|205->175|206->176|206->176|206->176|207->177|208->178|208->178|208->178|208->178|209->179|210->180|210->180|211->181|211->181|213->183|213->183|213->183|214->184|214->184|214->184|215->185|217->187|217->187|217->187|217->187|217->187|218->188|220->190|220->190|221->191|221->191|223->193|226->196|226->196|227->197|227->197|227->197|228->198|229->199|229->199|231->201|232->202|232->202|233->203|234->204|234->204|234->204|234->204|235->205|236->206|236->206|238->208|240->210|240->210|245->215|245->215|246->216|246->216|246->216|246->216|246->216|246->216|246->216|246->216|246->216|246->216|246->216|246->216|246->216|249->219|249->219|250->220|250->220|250->220|251->221|251->221|251->221|252->222|253->223|253->223|254->224|254->224|254->224|255->225|256->226|256->226|257->227|257->227|257->227|258->228|259->229|259->229|260->230|261->231|261->231|261->231|261->231|262->232|263->233|263->233|264->234|264->234|264->234|264->234|264->234|265->235|266->236|266->236|267->237|267->237|269->239|272->242|272->242|273->243|273->243|273->243|274->244|275->245|275->245|277->247|278->248|278->248|279->249|280->250|280->250|280->250|280->250|281->251|282->252|282->252|284->254|286->256|286->256|291->261|291->261|292->262|293->263|293->263|295->265|298->268|298->268|299->269|299->269|299->269|300->270|301->271|301->271|303->273|304->274|304->274|305->275|306->276|306->276|306->276|306->276|307->277|308->278|308->278|310->280|312->282|312->282|317->287|317->287|318->288|319->289|319->289|320->290
                  -- GENERATED --
              */
          