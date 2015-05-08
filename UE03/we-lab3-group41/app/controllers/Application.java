package controllers;

import at.ac.tuwien.big.we15.lab2.api.Avatar;
import at.ac.tuwien.big.we15.lab2.api.JeopardyFactory;
import at.ac.tuwien.big.we15.lab2.api.JeopardyGame;
import at.ac.tuwien.big.we15.lab2.api.User;
import at.ac.tuwien.big.we15.lab2.api.impl.PlayJeopardyFactory;
import at.ac.tuwien.big.we15.lab2.api.impl.SimpleUser;
import play.Play;
import play.data.Form;
import play.data.format.Formatters;
import play.mvc.*;
import play.db.jpa.JPA;

import views.html.*;

import models.RealUser;

import java.security.MessageDigest;
import java.text.ParseException;
import java.util.Locale;


public class Application extends Controller {

	private static Form<RealUser> userform = Form.form(RealUser.class);

	public static Result index() {
		return ok(authentication.render(Form.form(RealUser.class)));
	}


	public static Result registerPage() {
		return ok(registration.render(Form.form(RealUser.class)));
	}

	@play.db.jpa.Transactional
	public static Result register(){

		/*** Custom DataBinder to convert String from form to Avatar object ***/
		Formatters.register(Avatar.class, new Formatters.SimpleFormatter<Avatar>() {
			@Override
			public Avatar parse(String input, Locale arg1) throws ParseException {
				return Avatar.getAvatar(input);
			}

			@Override
			public String print(Avatar avatar, Locale arg1) {
				return avatar.toString();
			}
		});
		/*** Ends here ***/

		userform = Form.form(RealUser.class).bindFromRequest();
		if (userform.hasErrors()) {
			return badRequest(registration.render(userform));
		} else {
			RealUser realUser = userform.get();
			/*Verbesserungswürdig*/
			/*try {
				MessageDigest digest = MessageDigest.getInstance("SHA-256");
				realUser.password = digest.digest(realUser.password.getBytes("UTF-8")).toString();
			} catch(Exception e){
				System.out.println("An error occurred while hashing the password");
				return badRequest(registration.render(userform));
			}*/
			JPA.em().persist(realUser);
		}
		return redirect(routes.Application.index());
	}
	@Security.Authenticated(Game.class)
	public static Result login(){
		/*TODO: Get and check input, somehow???*/
		if(true){
			JeopardyFactory factory = new PlayJeopardyFactory("data.de.json");
			User test = new RealUser();
			test.setAvatar(Avatar.getAvatar("cyclops"));
			JeopardyGame game = factory.createGame(test);
			return ok(jeopardy.render());
		}
		return unauthorized();
	}
}
