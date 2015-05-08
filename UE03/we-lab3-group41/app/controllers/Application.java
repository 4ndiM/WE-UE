package controllers;

import at.ac.tuwien.big.we15.lab2.api.*;
import at.ac.tuwien.big.we15.lab2.api.impl.PlayJeopardyFactory;
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

	public static Result index() {
		return ok(authentication.render(Form.form(RealUser.class)));
	}


	public static Result registerPage() {
		return ok(registration.render(Form.form(RealUser.class)));
	}

	@play.db.jpa.Transactional
	public static Result register(){

		/*** Custom DataBinder ***/
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
		// System.out.println(userform.toString());
		if (userform.hasErrors()) {
			return badRequest(registration.render(userform));
		} else {
			RealUser realUser = userform.get();
			JPA.em().persist(realUser);
		}
		return redirect(routes.Application.index());
	}


	public static Result signin(){
		/*TODO: Get and check input, somehow???*/

		userform = Form.form(RealUser.class).bindFromRequest();
		if(true){
			JeopardyFactory factory = new PlayJeopardyFactory("data.de.json");
			User test = new RealUser();
			test.setName("sadasdf");
			test.setAvatar(Avatar.getAvatar("cyclops"));
			JeopardyGame game = factory.createGame(test);
			return ok(jeopardy.render(game));
		}
		return unauthorized();
	}
}
