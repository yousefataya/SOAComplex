package com.dimensions.mw.utils.compositeManagement.inMemoryData;

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

public class CompositeDB {
    public Map<String, CompositeBean> loadCompositeDefinition() throws Exception {

        ResultSet resultset = null;
        ResultSet detailsResultSet = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement detailsPreparedStatement = null;
        QueriesManager queryManager = new QueriesManager();
        String sql = queryManager.getQuery("SQ-CompositeDB-loadCompositeDefinition-01");
        String detailsSQL = queryManager.getQuery("SQ-CompositeDB-loadCompositeDefinition-02");
        HashMap<String, CompositeBean> compositeMap = new HashMap<String, CompositeBean>();
        CompositeBean compositeBean = null;
        try {
            connection = ConnectionManager.getOFMConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultset = preparedStatement.executeQuery();
            detailsPreparedStatement = connection.prepareStatement(detailsSQL);
            ArrayList<CompositeAuthMatrixBean> authList = null;
            CompositeAuthMatrixBean compositeAuthMatrixBean = null;
            while (resultset.next()) {
                compositeBean = new CompositeBean();
                String compositeName = resultset.getString("COMPOSITE_NAME");
                compositeBean.setCompositeName(compositeName);
                compositeBean.setDbLog(resultset.getString("DB_LOG"));
                detailsPreparedStatement.setString(1, compositeName);
                detailsResultSet = detailsPreparedStatement.executeQuery();
                authList = new ArrayList<CompositeAuthMatrixBean>();
                while (detailsResultSet.next()) {
                    compositeAuthMatrixBean = new CompositeAuthMatrixBean();
                    compositeAuthMatrixBean.setCompositeName(compositeName);
                    compositeAuthMatrixBean.setSourceSystem(detailsResultSet.getString("SOURCE_SYSTEM"));
                    compositeAuthMatrixBean.setSourceIPAdress(detailsResultSet.getString("SOURCE_IP_ADDRESS"));
                    compositeAuthMatrixBean.setToken(detailsResultSet.getString("TOKEN"));
                    compositeAuthMatrixBean.setUserName(detailsResultSet.getString("USER_NAME"));
                    authList.add(compositeAuthMatrixBean);
                }
                compositeBean.setCompositeAuthMatrixBeanList(authList);
                compositeMap.put(compositeBean.getCompositeName(), compositeBean);
            }
            try {
                resultset.close();
            }
            catch (Exception compositeName) {
                // empty catch block
            }
            try {
                preparedStatement.close();
            }
            catch (Exception compositeName) {
                // empty catch block
            }
            try {
                connection.close();
            }
            catch (Exception compositeName) {}
        }
        catch (Exception e22) {
          //  OFMException e22;
            if (!(e22 instanceof OFMException)) {
                e22 = new OFMException("OFM RunTime : Unable to Load OFM Composite Data", e22);
            } else {
                ((OFMException)e22).setTechMessage("OFM RunTime : Unable to Load OFM Composite Data | " + ((OFMException)e22).getTechMessage());
            }
            try {
                resultset.close();
            }
            catch (Exception compositeAuthMatrixBean) {
                // empty catch block
            }
            try {
                preparedStatement.close();
            }
            catch (Exception compositeAuthMatrixBean) {
                // empty catch block
            }
            try {
                connection.close();
            }
            catch (Exception compositeAuthMatrixBean) {
                // empty catch block
            }
            throw e22;
        }
        return Collections.unmodifiableMap(compositeMap);
    }
}

