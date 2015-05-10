package controllers;

import play.*;
import play.mvc.*;
import play.mvc.Http.*;


/**
 * Created by nechtan on 10.05.15.
 */
public class Secure extends Security.Authenticator {

    @Override
    public String getUsername(Context ctx) {
        System.out.println("security ok");return ctx.session().get("username");
    }

    @Override
    public Result onUnauthorized(Http.Context ctx) {
        return redirect(routes.Application.index());

    }
}
