package controllers;

import at.ac.tuwien.big.we15.lab2.api.impl.PlayJeopardyFactory;
import at.ac.tuwien.big.we15.lab2.api.Avatar;
import at.ac.tuwien.big.we15.lab2.api.JeopardyFactory;
import at.ac.tuwien.big.we15.lab2.api.JeopardyGame;
import at.ac.tuwien.big.we15.lab2.api.User;
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

		if(!getForm()){return badRequest(registration.render(userform));}
			RealUser realUser = userform.get();
			//TODO: hash/encode password
			JPA.em().persist(realUser);

		return redirect(routes.Application.index());
	}
	@Security.Authenticated(Game.class)
	public static Result login(){
		/*TODO: Get and check input, somehow???*/

		if(!getForm()){return badRequest(registration.render(userform));}

		if(validate(userform.get())){
			System.out.println("got validated");
			JeopardyFactory factory = new PlayJeopardyFactory("data.de.json");
			RealUser test = new RealUser();
			//test.setName("sadasdf");
			test.username = "sadasdf";
			test.setAvatar(Avatar.getAvatar("cyclops"));
			JeopardyGame game = factory.createGame(test);
			session().clear();
			session("username", userform.get().username);
			return ok(jeopardy.render(game));
		}
		System.out.println("did not...");
		return unauthorized();
	}

	@play.db.jpa.Transactional
	private static boolean validate(RealUser user) {
		RealUser usr = JPA.em().find(RealUser.class, user.username);
		if ( usr != null && usr.password == user.password){ /*TODO: use hashedPwd(user.password)*/
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