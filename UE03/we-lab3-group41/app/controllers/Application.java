package controllers;

import at.ac.tuwien.big.we15.lab2.api.*;
import play.data.Form;
import play.data.format.Formatters;
import play.mvc.*;
import play.db.jpa.JPA;

import views.html.*;

import models.RealUser;

import java.text.ParseException;
import java.util.Locale;


public class Application extends Controller {

	//private static Form<RealUser> userform = Form.form(RealUser.class);
	//private static RealUser usr = null;

	public static Result index() {
		session().clear();
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

		Form<RealUser> userform = Form.form(RealUser.class).bindFromRequest();
		if (userform.hasErrors()) {
			return badRequest(registration.render(userform));}
			RealUser realUser = userform.get();
			//TODO: hash/encode password
			JPA.em().persist(realUser);
		return redirect(routes.Application.index());
	}

	@play.db.jpa.Transactional
	public static Result login(){
		Form<RealUser> userform = Form.form(RealUser.class).bindFromRequest();
		if (userform.hasErrors()) {
			return badRequest(authentication.render(userform));}

		RealUser usr = validate(userform.get());
		//if(validate(userform.get())){
		if(usr != null){
			session().clear();
			session("username", usr.getName());
			return redirect(routes.Game.game());

		}
		userform.error("Wrong login credentials, pleas try again");
		return badRequest(authentication.render(userform));
	}



	public static RealUser validate(RealUser user) {
		RealUser usr = JPA.em().find(RealUser.class, user.username);

		if(usr != null && usr.password.equals(user.password)){ /*TODO: use hashedPwd(user.password)*/
			return usr;
		}
		return null;
	}

	private static boolean getForm(){
		Form<RealUser> userform = Form.form(RealUser.class).bindFromRequest();
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