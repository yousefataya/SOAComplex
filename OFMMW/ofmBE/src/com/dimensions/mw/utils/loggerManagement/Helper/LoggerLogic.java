package com.dimensions.mw.utils.loggerManagement.Helper;

import com.dimensions.mw.utils.compositeManagement.inMemoryData.CompositeBean;
import com.dimensions.mw.utils.compositeManagement.inMemoryData.CompositeSingleton;

public class LoggerLogic {
    public static void insertProcessInstance(String compositeName, String ofmExecutionID, String sourceAppCode, String sourceExecutionId, String sourceAppUsername, String executionInput, String compositeId, String domainName, String managedServerName, String businessKey) {
        CompositeBean bean = new CompositeBean();
        try {
            bean = CompositeSingleton.getInstance().getCompositeDataMap().get(compositeName);
            if (bean != null && bean.getDbLog().equals("Y")) {
                LoggerDB dbLogger = new LoggerDB();
                dbLogger.insertProcessInstance(compositeName, ofmExecutionID, sourceAppCode, sourceExecutionId, sourceAppUsername, executionInput, compositeId, domainName, managedServerName, businessKey);
            }
        }
        catch (Exception dbLogger) {
            // empty catch block
        }
    }

    public static void updateProcessInstance(String ofmTransactionId, String executionOut, String status, String compositeName) {
        try {
            CompositeBean bean = new CompositeBean();
            bean = CompositeSingleton.getInstance().getCompositeDataMap().get(compositeName);
            if (bean != null && bean.getDbLog().equals("Y")) {
                LoggerDB dbLogger = new LoggerDB();
                dbLogger.updateProcessInstance(ofmTransactionId, executionOut, status, compositeName);
            }
        }
        catch (Exception bean) {
            // empty catch block
        }
    }
}

