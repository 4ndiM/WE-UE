package controllers;

import at.ac.tuwien.big.we15.lab2.api.Avatar;
import at.ac.tuwien.big.we15.lab2.api.JeopardyFactory;
import at.ac.tuwien.big.we15.lab2.api.JeopardyGame;
import at.ac.tuwien.big.we15.lab2.api.User;
import at.ac.tuwien.big.we15.lab2.api.impl.PlayJeopardyFactory;
import models.RealUser;
import play.cache.Cache;
import play.data.DynamicForm;
import play.data.Form;
import play.db.jpa.JPA;
import play.mvc.*;
import views.html.jeopardy;
import views.html.question;
import views.html.winner;

import java.util.ArrayList;

@Security.Authenticated(Secure.class)
public class Game extends Controller {

    @play.db.jpa.Transactional
    public static Result game(){

        String username = session().get("username");
        RealUser usr = JPA.em().find(RealUser.class, username);

        if(usr == null)
            return noContent();

        JeopardyFactory factory = new PlayJeopardyFactory("data.de.json");
        usr.setAvatar(Avatar.getAvatar(usr.getAvId()));
        JeopardyGame game = factory.createGame(usr);
        Cache.set("game_" + usr.getName(), game);
        return ok(jeopardy.render(game));
    }

    public static Result selectQuestion() {
        DynamicForm form = Form.form().bindFromRequest();
        if(form.data().get("question_selection") != null){
            int questionSelection = Integer.parseInt(form.data().get("question_selection"));

            String username = session().get("username");
            JeopardyGame game = (JeopardyGame) Cache.get("game_" + username);
            if (game != null) {
                game.chooseHumanQuestion(questionSelection);
                return ok(question.render(game));
            }
        }
        return noContent();
    }

    public static Result selectAnswer() {
        String[] answersAsString = request().body().asFormUrlEncoded().get("answers");
        ArrayList<Integer> answers = new ArrayList<>();
        if(answersAsString != null) {
            for (String a : answersAsString) {
                answers.add(Integer.parseInt(a));
            }
        }
        String username = session().get("username");
        JeopardyGame game = (JeopardyGame) Cache.get("game_"+username);

        game.answerHumanQuestion(answers);

        if(game.isGameOver()) {
            return ok(winner.render(game));
        }

        return ok(jeopardy.render(game));
    }

}
