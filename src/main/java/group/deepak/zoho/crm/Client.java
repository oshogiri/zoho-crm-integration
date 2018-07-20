package group.deepak.zoho.crm;

import com.zoho.crm.library.setup.restclient.ZCRMRestClient;
import com.zoho.oauth.client.ZohoOAuthClient;
import com.zoho.oauth.common.ZohoOAuthException;
import com.zoho.oauth.contract.ZohoOAuthTokens;

public class Client {
    public static boolean initialize() {
        return initialize(null);
    }

    public static boolean initialize(String grantToken) {
        try {
            ZCRMRestClient.initialize();
            ZCRMRestClient.setCurrentUser("osho@linkwok.com");
            if (grantToken != null) {
                ZohoOAuthClient zohoOAuthClient = ZohoOAuthClient.getInstance();
                ZohoOAuthTokens zohoOAuthTokens = zohoOAuthClient.generateAccessToken(grantToken);
                System.out.println("Access Token = " + zohoOAuthTokens.getAccessToken() + " & Refresh Token = " + zohoOAuthTokens.getRefreshToken());
            }
            return true;
        } catch (ZohoOAuthException exception) {
            System.out.println(exception.getMessage());
            return false;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }
}
