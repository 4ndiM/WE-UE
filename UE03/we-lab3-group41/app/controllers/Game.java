package controllers;

import at.ac.tuwien.big.we15.lab2.api.JeopardyGame;
import play.cache.Cache;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;
import views.html.jeopardy;
import views.html.question;
import views.html.winner;

import java.util.ArrayList;

public class Game extends Controller {




    public static Result selectQuestion() {
        DynamicForm form = Form.form().bindFromRequest();
        int questionSelection = Integer.parseInt(form.data().get("question_selection"));
        String username = session().get("user");
        JeopardyGame game = (JeopardyGame) Cache.get("game_"+ username);
        game.chooseHumanQuestion(questionSelection);
        return ok(question.render(game));
    }

    public static Result selectAnswer() {
        String[] answersAsString = request().body().asFormUrlEncoded().get("answers");
        ArrayList<Integer> answers = new ArrayList<>();
        for(String a: answersAsString) {
            answers.add(Integer.parseInt(a));
        }
        String username = session().get("user");
        JeopardyGame game = (JeopardyGame) Cache.get("game_"+username);

        game.answerHumanQuestion(answers);

        if(game.isGameOver()) {
            return ok(winner.render(game));
        }

        return ok(jeopardy.render(game));
    }

}
