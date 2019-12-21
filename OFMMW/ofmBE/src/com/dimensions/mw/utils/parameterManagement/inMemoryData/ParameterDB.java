package com.dimensions.mw.utils.parameterManagement.inMemoryData;

import com.dimensions.mw.utils.OFMException;
import com.dimensions.mw.utils.connectionManagement.ConnectionManager;
import com.dimensions.mw.utils.sqlManagement.QueriesManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ParameterDB {
    public Map<String, ParameterBean> loadParameters() throws Exception {
        HashMap<String, ParameterBean> paramBeanMap;
        Connection connection = null;
        QueriesManager queryManager = null;
        ResultSet resultset = null;
        PreparedStatement preparedStatement = null;
        ParameterBean paramBean = null;
        try {
            connection = ConnectionManager.getOFMConnection();
            queryManager = new QueriesManager();
            paramBeanMap = new HashMap<String, ParameterBean>();
            String sql = queryManager.getQuery("SQ-ParameterDB-loadParameters-01");
            preparedStatement = connection.prepareStatement(sql);
            resultset = preparedStatement.executeQuery();
            while (resultset.next()) {
                paramBean = new ParameterBean();
                paramBean.setParamName(resultset.getString("PARAM_NAME"));
                paramBean.setParamDefaultValue(resultset.getString("PARAM_DEF_VALUE"));
                paramBean.setParamValue(resultset.getString("PARAM_VALUE"));
                paramBean.setParamAttribute1(resultset.getString("PARAM_ATTR1"));
                paramBean.setParamAttribute2(resultset.getString("PARAM_ATTR2"));
                paramBean.setParamAttribute3(resultset.getString("PARAM_ATTR3"));
                paramBeanMap.put(paramBean.getParamName(), paramBean);
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
          //  OFMException e22;
            Object paramBeanMap2 = null;
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
            if (!(e22 instanceof OFMException)) {
                e22 = new OFMException("OFM RunTime : Unable to Load OFM Parameter", e22);
            } else {
                ((OFMException)e22).setTechMessage("OFM RunTime : Unable to Load OFM Parameter | " + ((OFMException)e22).getTechMessage());
            }
            throw e22;
        }
        return Collections.unmodifiableMap(paramBeanMap);
    }
}

