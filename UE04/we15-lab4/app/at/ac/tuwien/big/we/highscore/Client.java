package at.ac.tuwien.big.we.highscore;

import at.ac.tuwien.big.we.highscore.data.*;
import at.ac.tuwien.big.we.highscore.data.ObjectFactory;
import models.JeopardyGame;
import models.JeopardyUser;
import models.Player;
import play.Logger;

import javax.xml.bind.*;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.BindingProvider;
import java.io.File;
import java.util.GregorianCalendar;


public class Client {

    private JeopardyGame jeopardyGame;
    private at.ac.tuwien.big.we.highscore.data.ObjectFactory factory;
    private UserDataType udt = null;

    public Client(JeopardyGame jeopardyGame) {
        this.jeopardyGame = jeopardyGame;
        this.factory = new ObjectFactory();
        this.udt = factory.createUserDataType();

    }

    public String uuidWebService() {

        HighScoreRequestType requestType;


        setValues(jeopardyGame.getHumanPlayer());
        setValues(jeopardyGame.getMarvinPlayer());

        if(udt.getLoser() == null){
            System.out.println("no loser");

        }else if(udt.getWinner() == null){
            System.out.println("no winner");

        } else {
            System.out.println("both, winner and loser");

        }


        requestType = factory.createHighScoreRequestType();
        requestType.setUserData(udt);
        requestType.setUserKey("3ke93-gue34-dkeu9");


        try {
            JAXBContext jaxbContext = JAXBContext.newInstance( HighScoreRequestType.class );

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();


            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

            jaxbMarshaller.marshal( factory.createHighScoreRequest(requestType), new File( "simple.xml" ) );

            jaxbMarshaller.marshal( factory.createHighScoreRequest(requestType), System.out );
        } catch (JAXBException e) {
            e.printStackTrace();
        }


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

    private void setValues(Player player){
        JeopardyUser user = player.getUser();

        UserType utype;

        utype = factory.createUserType();

        utype.setFirstName(setString(user.getFirstName(), "firstname"));

        utype.setLastName(setString(user.getLastName(), "lastname"));
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





        if(jeopardyGame.getWinner() == player){
            System.out.println(player.getUser().getUserName());
            udt.setWinner(utype);
            System.out.println(udt.getWinner().getPoints());
        } else {
            udt.setLoser(utype);
        }
    }

    private String setString(String str1, String str2) {
        if (str1.isEmpty() || str1 == null){
            return str2;
        }
        return str1;
    }
}
