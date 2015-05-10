package controllers;

import play.mvc.*;
import play.mvc.Http.*;


public class Secure extends Security.Authenticator {

    @Override
    public String getUsername(Context ctx) {
        return ctx.session().get("username");
    }

    @Override
    public Result onUnauthorized(Http.Context ctx) {
        return redirect(routes.Application.index());

    }
}
