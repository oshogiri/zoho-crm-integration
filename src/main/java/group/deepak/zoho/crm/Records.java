package group.deepak.zoho.crm;

import com.google.common.collect.Lists;
import com.zoho.crm.library.api.response.BulkAPIResponse;
import com.zoho.crm.library.crud.ZCRMModule;
import com.zoho.crm.library.crud.ZCRMRecord;
import com.zoho.crm.library.exception.ZCRMException;

import java.util.List;

public class Records {
    public static void touchRecordsOf(String moduleName) {
        try {
            if (Client.initialize()) {
                ZCRMModule zcrmModule = ZCRMModule.getInstance("Collections");
                for (int i = 0; i < 22; i++) {
                    System.out.println("Running: " + (i + 1));
                    BulkAPIResponse bulkAPIResponse = zcrmModule.getRecords(new Long("3337335000000333536"));

                    List<ZCRMRecord> zcrmRecords = (List<ZCRMRecord>) bulkAPIResponse.getData();
                    for (List<ZCRMRecord> zcrmRecords_100 : Lists.partition(zcrmRecords, 100))
                        zcrmModule.upsertRecords(zcrmRecords_100);
                }
            }
        } catch (ZCRMException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
