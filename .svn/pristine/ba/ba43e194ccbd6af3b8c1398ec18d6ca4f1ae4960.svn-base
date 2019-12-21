package com.dimensions.mw.utils.sqlManagement;

import com.dimensions.mw.utils.OFMException;
import com.dimensions.mw.utils.parameterManagement.ParameterManager;
import com.dimensions.mw.utils.sqlManagement.inMemoryData.QuerySingleton;

public class QueriesManager {
    public void destroyInstance() {
        try {
            QuerySingleton instance = QuerySingleton.getInstance();
            if (instance != null) {
                instance.destroyInstance();
            }
        }
        catch (Exception instance) {
            // empty catch block
        }
    }

    public String getQuery(String queryKey) throws Exception {
        String sql = null;
        sql = QuerySingleton.getInstance().getQueryMap().get(queryKey);
        ParameterManager parameterManager = new ParameterManager();
        String dayNum = null;
        try {
            dayNum = parameterManager.getMandatoryParamValue("OFM_PARTISION_NUMBER_OF_DAY");
        }
        catch (Exception ex) {
            dayNum = "7";
        }
        sql = sql.replaceAll("#DAYNUM#", dayNum);
        if (sql == null) {
            throw new OFMException("OFM Application : Unable to Find SQL for  [ " + queryKey + " ] , SQL Entry not Found", null);
        }
        return sql;
    }
}

