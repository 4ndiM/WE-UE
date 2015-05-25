package twitter;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;


public class TwitterClient implements ITwitterClient {

    private static final String CONSUMER_KEY = "GZ6tiy1XyB9W0P4xEJudQ";
    private static final String CONSUMER_SECRET = "gaJDlW0vf7en46JwHAOkZsTHvtAiZ3QUd2mD1x26J9w";
    private static final String ACCESS_TOKEN = "1366513208-MutXEbBMAVOwrbFmZtj1r4Ih2vcoHGHE2207002";
    private static final String ACCESS_TOKEN_SECRET = "RMPWOePlus3xtURWRVnv1TgrjTyK7Zk33evp4KKyA";

    private Twitter twitter;

    public TwitterClient(){
        TwitterFactory factory = new TwitterFactory();

        this.twitter = factory.getInstance();

        twitter.setOAuthAccessToken(new AccessToken(ACCESS_TOKEN, ACCESS_TOKEN_SECRET));
    }

    @Override
    public void publishUuid(TwitterStatusMessage message) throws Exception {
        twitter.updateStatus(message.getTwitterPublicationString());
    }
}