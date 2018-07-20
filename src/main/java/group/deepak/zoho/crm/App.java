package group.deepak.zoho.crm;

import com.google.common.collect.Lists;
import com.zoho.crm.library.api.response.BulkAPIResponse;
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
        Records.touchRecordsOf("Sales");
    }
}
