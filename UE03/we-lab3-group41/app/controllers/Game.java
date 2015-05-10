package controllers;

import play.mvc.*;
import play.mvc.Http.*;
import play.db.jpa.JPA;

public class Game extends Security.Authenticator {


    @Override
    public String getUsername(Context ctx) {
        System.out.println("security ok");return ctx.session().get("username");
    }

    @Override
    public Result onUnauthorized(Context ctx) {
        return redirect(routes.Application.index());
    }
}
