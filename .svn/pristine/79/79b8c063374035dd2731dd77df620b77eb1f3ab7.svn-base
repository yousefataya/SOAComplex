package com.dimensions.mw.utils.validationManagement.inMemoryData;

import com.dimensions.mw.utils.OFMException;
import com.dimensions.mw.utils.connectionManagement.ConnectionManager;
import com.dimensions.mw.utils.sqlManagement.QueriesManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ValidationDB {
    public Map<String, ValidationBean> loadValidationMapping() throws Exception {
        ResultSet resultset = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        QueriesManager queryManager = new QueriesManager();
        String sql = queryManager.getQuery("SQ-ValidationDB-loadValidationMapping-01");
        HashMap<String, ValidationBean> validationMap = new HashMap<String, ValidationBean>();
        ValidationBean validationBean = null;
        try {
            connection = ConnectionManager.getOFMConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultset = preparedStatement.executeQuery();
            while (resultset.next()) {
                validationBean = new ValidationBean();
                validationBean.setSource(resultset.getString("SOURCE"));
                validationBean.setProcessName(resultset.getString("PROCESS_NAME"));
                validationBean.setElementName(resultset.getString("ELEMENET_NAME"));
                validationBean.setTargetValidations(resultset.getString("TARGET_VALIDATIONS"));
                validationMap.put(validationBean.getSource() + "_" + validationBean.getProcessName() + "_" + validationBean.getElementName(), validationBean);
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
            catch (Exception exception) {}
        }
        catch (Exception e22) {
            if (!(e22 instanceof OFMException)) {
                e22 = new OFMException("OFM RunTime : Unable to Load OFM Validation Data", e22);
            } else {
                ((OFMException)e22).setTechMessage("OFM RunTime : Unable to Load OFM Validation Data | " + ((OFMException)e22).getTechMessage());
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
            throw e22;
        }
        return Collections.unmodifiableMap(validationMap);
    }
}

