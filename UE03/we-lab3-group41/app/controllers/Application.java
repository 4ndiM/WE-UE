package controllers;

import at.ac.tuwien.big.we15.lab2.api.impl.*;
import at.ac.tuwien.big.we15.lab2.api.*;
import play.cache.Cache;
import play.data.Form;
import play.data.format.Formatters;
import play.mvc.*;
import play.db.jpa.JPA;

import views.html.*;

import models.RealUser;

import java.text.ParseException;
import java.util.Locale;


public class Application extends Controller {

	private static Form<RealUser> userform = Form.form(RealUser.class);
	private static RealUser usr = null;

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
			return badRequest(registration.render(userform));}
			RealUser realUser = userform.get();
			//TODO: hash/encode password
			JPA.em().persist(realUser);
		return redirect(routes.Application.index());
	}

	@play.db.jpa.Transactional
	public static Result login(){
		userform = Form.form(RealUser.class).bindFromRequest();
		if (userform.hasErrors()) {
			return badRequest(authentication.render(userform));}

		if(validate(userform.get())){
			session().clear();
			session("username", userform.get().username);
			return redirect(routes.Application.game());

		}
		userform.error("Wrong login credentials, pleas try again");
		return badRequest(authentication.render(userform));
	}

	@Security.Authenticated(Secure.class)
	public static Result game(){
		JeopardyFactory factory = new PlayJeopardyFactory("data.de.json");

		usr.setAvatar(Avatar.getAvatar(usr.getAvId()));
		JeopardyGame game = factory.createGame(usr);
		Cache.set("game_"+usr.getName(), game);
		return ok(jeopardy.render(game));
	}

	public static boolean validate(RealUser user) {
		usr = JPA.em().find(RealUser.class, user.username);

		if(usr != null && usr.password.equals(user.password)){ /*TODO: use hashedPwd(user.password)*/
			return true;
		}
		return false;
	}

	private static boolean getForm(){
		userform = Form.form(RealUser.class).bindFromRequest();
		if (userform.hasErrors()) {
			return false;
		}
		return true;
	}

	/*TODO: Implement this*/
/*	private String hashedPwd(String pwd){

			try {
				MessageDigest digest = MessageDigest.getInstance("SHA-256");
				realUser.password = digest.digest(realUser.password.getBytes("UTF-8")).toString();
			} catch(Exception e){
				System.out.println("An error occurred while storing the password");
				return badRequest(registration.render(userform));
			}
		return null;
	}*/
}