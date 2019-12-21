package com.dimensions.mw.utils.loggerManagement;

import com.dimensions.mw.utils.loggerManagement.Helper.LoggerLogic;

public class LoggerManager {
    public static void main(String[] args) throws Exception {
    }

    public static void insertProcessInstance(String compositeName, String ofmExecutionID, String sourceAppCode, String sourceExecutionId, String sourceAppUsername, String executionInput, String compositeId, String domainName, String managedServerName, String businessKey) {
        LoggerLogic.insertProcessInstance(compositeName, ofmExecutionID, sourceAppCode, sourceExecutionId, sourceAppUsername, executionInput, compositeId, domainName, managedServerName, businessKey);
    }

    public static void updateProcessInstance(String ofmTransactionId, String executionOut, String status, String compositeName) {
        LoggerLogic.updateProcessInstance(ofmTransactionId, executionOut, status, compositeName);
    }
}

