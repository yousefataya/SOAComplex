package com.dimensions.mw.utils.errorManagement.inMemoryData;

import com.dimensions.mw.utils.OFMException;
import com.dimensions.mw.utils.connectionManagement.ConnectionManager;
import com.dimensions.mw.utils.sqlManagement.QueriesManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ErrorDB {
    public Map<String, ErrorDefinitionBean> loadErrorDefinitionMap() throws Exception {
        Connection connection = null;
        ResultSet resultset = null;
        PreparedStatement preparedStatement = null;
        HashMap<String, ErrorDefinitionBean> errorDefinitionMap = null;
        try {
            connection = ConnectionManager.getOFMConnection();
            QueriesManager queryManager = new QueriesManager();
            String sql = queryManager.getQuery("SQ-ErrorDB-loadErrorDefinitionMap-01");
            errorDefinitionMap = new HashMap<String, ErrorDefinitionBean>();
            preparedStatement = connection.prepareStatement(sql);
            resultset = preparedStatement.executeQuery();
            while (resultset.next()) {
                ErrorDefinitionBean errorDefinitionBean = new ErrorDefinitionBean();
                errorDefinitionBean.setErrorCode(resultset.getString("ERROR_CODE"));
                errorDefinitionBean.setErrorBussinessCode(resultset.getString("ERROR_BUS_CODE"));
                errorDefinitionBean.setErrorBussinessMessage(resultset.getString("ERROR_BUS_MESSAGE"));
                errorDefinitionBean.setErrorTechCode(resultset.getString("ERROR_TECH_CODE"));
                errorDefinitionBean.setErrorTechMessage(resultset.getString("ERROR_TECH_MESSAGE"));
                errorDefinitionMap.put(errorDefinitionBean.getErrorCode(), errorDefinitionBean);
            }
            try {
                resultset.close();
            }
            catch (Exception exception) {
                // empty catch block
            }
            try {
                preparedStatement.close();
            }
            catch (Exception exception) {
                // empty catch block
            }
            try {
                connection.close();
            }
            catch (Exception exception) {
                // empty catch block
            }
            return errorDefinitionMap;
        }
        catch (Exception e22) {
            //OFMException e22;
            try {
                resultset.close();
            }
            catch (Exception sql) {
                // empty catch block
            }
            try {
                preparedStatement.close();
            }
            catch (Exception sql) {
                // empty catch block
            }
            try {
                connection.close();
            }
            catch (Exception sql) {
                // empty catch block
            }
            if (!(e22 instanceof OFMException)) {
                e22 = new OFMException("OFM RunTime : Unable to Load OFM Error Definition Mapping Data", e22);
            } else {
                ((OFMException)e22).setTechMessage("OFM RunTime : Unable to Load OFM Error Definition Mapping Data | " + ((OFMException)e22).getTechMessage());
            }
            throw e22;
        }
    }

    public Map<String, Map<String, Map<String, ArrayList<ErrorCriteriaBean>>>> loadErrorCriteriaList() throws Exception {
        Connection connection = null;
        ResultSet resultset = null;
        PreparedStatement preparedStatement = null;
        HashMap errorCriteriaMap = null;
        try {
            connection = ConnectionManager.getOFMConnection();
            QueriesManager queryManager = new QueriesManager();
            String sql = queryManager.getQuery("SQ-ErrorDB-loadErrorCriteriaList-01");
            errorCriteriaMap = new HashMap();
            preparedStatement = connection.prepareStatement(sql);
            resultset = preparedStatement.executeQuery();
            while (resultset.next()) {
                ErrorCriteriaBean errorCriteriaBean = new ErrorCriteriaBean();
                errorCriteriaBean.setErrorCode(resultset.getString("ERROR_CODE"));
                errorCriteriaBean.setErrorString(resultset.getString("ERROR_STRING"));
                errorCriteriaBean.setSystem(resultset.getString("SYSTEM"));
                errorCriteriaBean.setOperation(resultset.getString("OPERATION"));
                errorCriteriaBean.setProcessName(resultset.getString("PROCESSNAME"));
                String system = errorCriteriaBean.getSystem();
                String operation = errorCriteriaBean.getOperation();
                String processName = errorCriteriaBean.getProcessName();
                if (!errorCriteriaMap.containsKey(system)) {
                    errorCriteriaMap.put(system, new HashMap());
                    ((Map)errorCriteriaMap.get(system)).put(operation, new HashMap());
                    ((Map)((Map)errorCriteriaMap.get(system)).get(operation)).put(processName, new ArrayList());
                } else if (!((Map)errorCriteriaMap.get(system)).containsKey(operation)) {
                    ((Map)errorCriteriaMap.get(system)).put(operation, new HashMap());
                    ((Map)((Map)errorCriteriaMap.get(system)).get(operation)).put(processName, new ArrayList());
                } else if (!((Map)((Map)errorCriteriaMap.get(system)).get(operation)).containsKey(processName)) {
                    ((Map)((Map)errorCriteriaMap.get(system)).get(operation)).put(processName, new ArrayList());
                }
                ((ArrayList)((Map)((Map)errorCriteriaMap.get(system)).get(operation)).get(processName)).add(errorCriteriaBean);
            }
            resultset.close();
            preparedStatement.close();
            connection.close();
            return Collections.unmodifiableMap(errorCriteriaMap);
        }
        catch (Exception e22) {
            try {
                resultset.close();
            }
            catch (Exception sql) {
                // empty catch block
            }
            try {
                preparedStatement.close();
            }
            catch (Exception sql) {
                // empty catch block
            }
            try {
                connection.close();
            }
            catch (Exception sql) {
                // empty catch block
            }
            if (!(e22 instanceof OFMException)) {
                e22 = new OFMException("OFM RunTime : Unable to Load OFM Error Criteria Data", e22);
            } else {
                ((OFMException)e22).setTechMessage("OFM RunTime : Unable to Load OFM Error Criteria Data | " + ((OFMException)e22).getTechMessage());
            }
            throw e22;
        }
    }
}

