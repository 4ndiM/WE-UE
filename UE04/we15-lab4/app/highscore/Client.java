package highscore;

import highscore.data.*;
import models.JeopardyGame;
import models.JeopardyUser;
import models.Player;
import play.Logger;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.util.GregorianCalendar;


public class Client {

    private JeopardyGame jeopardyGame;
    private highscore.data.ObjectFactory factory;
    private UserDataType udt = null;

    public Client(JeopardyGame jeopardyGame) {
        this.jeopardyGame = jeopardyGame;
        this.factory = new highscore.data.ObjectFactory();
    }

    public String uuidWebService() {

        HighScoreRequestType requestType;

        setValues(jeopardyGame.getMarvinPlayer());
        setValues(jeopardyGame.getHumanPlayer());


        requestType = factory.createHighScoreRequestType();
        requestType.setUserData(udt);
        requestType.setUserKey("3ke93-gue34-dkeu9");

        PublishHighScoreService service = new PublishHighScoreService();
        PublishHighScoreEndpoint endpoint =  service.getPublishHighScorePort();
        try {
            String str = endpoint.publishHighScore(requestType);
            Logger.info(str);
            return str;
        } catch (Failure failure) {
            /*TODO: replace stacktrace!*/
            Logger.error("Failed to retrieve UUID.");
            failure.printStackTrace();
        }

        return null;
    }

    private String setValues(Player player){
        JeopardyUser user = player.getUser();

        UserType utype;

        utype = factory.createUserType();

        utype.setFirstName(user.getFirstName());
        utype.setLastName(user.getLastName());
        utype.setGender(GenderType.fromValue(user.getGender().toString()));
        utype.setPassword("");

        utype.setPoints(player.getProfit());

        GregorianCalendar c = new GregorianCalendar();
        c.setTime(user.getBirthDate());
        try {
            utype.setBirthDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
        } catch (DatatypeConfigurationException e) {
            e.getMessage();
        }

        udt = factory.createUserDataType();

        if(jeopardyGame.getWinner() == player){
            udt.setWinner(utype);
        } else {
            udt.setLoser(utype);
        }

        return null;
    }
}
