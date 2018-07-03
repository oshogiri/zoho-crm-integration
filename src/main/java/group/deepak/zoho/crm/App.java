package group.deepak.zoho.crm;

import com.zoho.crm.library.crud.ZCRMModule;
import com.zoho.crm.library.crud.ZCRMRecord;
import com.zoho.crm.library.setup.restclient.ZCRMRestClient;
import com.zoho.oauth.client.ZohoOAuthClient;
import com.zoho.oauth.common.ZohoOAuthException;
import com.zoho.oauth.contract.ZohoOAuthTokens;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            ZCRMRestClient.initialize();
            ZCRMRestClient.setCurrentUser("osho@linkwok.com");
            ZohoOAuthClient cli = ZohoOAuthClient.getInstance();
            String grantToken = "1000.8888cb7b0444bf00036d0c84145f1234.34cbd288be453bf01b84430196b96914";
            ZohoOAuthTokens tokens = cli.generateAccessToken(grantToken);
            String accessToken = tokens.getAccessToken();
            String refreshToken = tokens.getRefreshToken();
            System.out.println("access token = " + accessToken + " & refresh token = " + refreshToken);

            ZCRMModule testModule = ZCRMModule.getInstance("Tests");

            List<ZCRMRecord> zcrmRecords = new ArrayList<>();
            ZCRMRecord zcrmRecord;
            HashMap<String, Object> recordDetails;

            for (int i = 1; i <= 100; i++) {
                zcrmRecord = new ZCRMRecord("Tests");
                recordDetails = new HashMap<>();
                recordDetails.put("Name", "Testing " + i);
                zcrmRecord.setData(recordDetails);
                zcrmRecords.add(zcrmRecord);
            }

            testModule.createRecords(zcrmRecords);
        } catch (ZohoOAuthException exception) {
            System.out.println(exception.getMessage());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
