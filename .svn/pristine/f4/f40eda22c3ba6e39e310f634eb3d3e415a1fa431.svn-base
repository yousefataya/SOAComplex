package com.dimensions.mw.utils.mappingManagement.inMemoryData;

import com.dimensions.mw.utils.OFMException;
import com.dimensions.mw.utils.connectionManagement.ConnectionManager;
import com.dimensions.mw.utils.sqlManagement.QueriesManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MappingDB {
    public Map<String, MappingBean> loadMapping() throws Exception {
        ResultSet resultset = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        MappingBean mappingBean = null;
        try {
            QueriesManager queryManager = new QueriesManager();
            connection = ConnectionManager.getOFMConnection();
            HashMap<String, MappingBean> mapBeanMap = new HashMap<String, MappingBean>();
            String sql = queryManager.getQuery("SQ-MappingDB-loadMapping-01");
            preparedStatement = connection.prepareStatement(sql);
            resultset = preparedStatement.executeQuery();
            while (resultset.next()) {
                mappingBean = new MappingBean();
                mappingBean.setMappingKey(resultset.getString("KEY"));
                mappingBean.setMappingValue(resultset.getString("VALUE"));
                mappingBean.setDescription(resultset.getString("DESCRIPTION"));
                mapBeanMap.put(mappingBean.getMappingKey(), mappingBean);
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
            return Collections.unmodifiableMap(mapBeanMap);
        }
        catch (Exception e22) {
           // OFMException e22;
            if (!(e22 instanceof OFMException)) {
                e22 = new OFMException("OFM RunTime : Unable to Load OFM Mapping's", e22);
            } else {
                ((OFMException)e22).setTechMessage("OFM RunTime : Unable to Load OFM Mapping's | " + ((OFMException)e22).getTechMessage());
            }
            try {
                resultset.close();
            }
            catch (Exception mapBeanMap) {
                // empty catch block
            }
            try {
                preparedStatement.close();
            }
            catch (Exception mapBeanMap) {
                // empty catch block
            }
            try {
                connection.close();
            }
            catch (Exception mapBeanMap) {
                // empty catch block
            }
            throw e22;
        }
    }
}

