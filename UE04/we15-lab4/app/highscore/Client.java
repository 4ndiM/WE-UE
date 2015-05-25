package highscore;

import highscore.data.*;
import models.JeopardyDAO;
import models.JeopardyGame;
import models.JeopardyUser;
import models.Player;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.util.GregorianCalendar;


public class Client {

    private JeopardyGame jeopardyGame;
    private JeopardyUser ju;

    public Client(JeopardyUser ju, JeopardyGame jeopardyGame) {
        this.ju = ju;
        this.jeopardyGame = jeopardyGame;
    }

    public void userInfoToWebService() {
        highscore.data.ObjectFactory of = new highscore.data.ObjectFactory();

        UserType ut = of.createUserType();

        ut.setFirstName(ju.getFirstName());
        ut.setLastName(ju.getLastName());
        ut.setGender(GenderType.fromValue(ju.getGender().toString()));
        ut.setPassword("");

        Player pl = jeopardyGame.getHumanPlayer();
        ut.setPoints(pl.getProfit());

        GregorianCalendar c = new GregorianCalendar();
        c.setTime(ju.getBirthDate());
        try {
            ut.setBirthDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
        } catch (DatatypeConfigurationException e) {
            e.getMessage();
        }

        UserDataType udt = of.createUserDataType();

        if(jeopardyGame.getWinner()== pl){
            udt.setWinner(ut);
        } else {
            udt.setLoser(ut);
        }

        HighScoreRequestType hsrt = of.createHighScoreRequestType();
        hsrt.setUserData(udt);
        hsrt.setUserKey("3ke93-gue34-dkeu9");
/*        of.createHighScoreRequest(hsrt);
        JAXBElement<String> uuid = of.createHighScoreResponse("3ke93-gue34-dkeu9");*/

        PublishHighScoreService service = new PublishHighScoreService();
        PublishHighScoreEndpoint endpoint =  service.getPublishHighScorePort();
        try {
            endpoint.publishHighScore(hsrt);
        } catch (Failure failure) {
            /*TODO: replace stacktrace!*/
            failure.printStackTrace();
        }
    }
}
