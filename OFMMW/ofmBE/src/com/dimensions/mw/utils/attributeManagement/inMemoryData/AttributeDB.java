package com.dimensions.mw.utils.attributeManagement.inMemoryData;

import com.dimensions.mw.utils.OFMException;
import com.dimensions.mw.utils.connectionManagement.ConnectionManager;
import com.dimensions.mw.utils.sqlManagement.QueriesManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AttributeDB {
    
    public Map<String, AttributeBean> loadAttributes() throws Exception {
          ResultSet resultset = null;
          Connection connection = null;
          PreparedStatement preparedStatement = null;
          AttributeBean attributeBean = null;
          try {
              QueriesManager queryManager = new QueriesManager();
              connection = ConnectionManager.getOFMConnection();
              HashMap<String, AttributeBean> attributeBeanMap = new HashMap<String, AttributeBean>();
              String sql = queryManager.getQuery("SQ-AttributeDB-loadAttributes-01");
              preparedStatement = connection.prepareStatement(sql);
              resultset = preparedStatement.executeQuery();
              while (resultset.next()) {
                  attributeBean = new AttributeBean();
                  attributeBean.setAttributeName(resultset.getString("ATTRIBUTE_NAME"));
                  attributeBean.setDataType(resultset.getString("DATA_TYPE"));
                  attributeBean.setDataPrefix(resultset.getString("DATA_PREFIX"));
                  attributeBean.setDataLength(resultset.getString("DATA_LENGTH"));
                  attributeBean.setDataValues(resultset.getString("DATA_VALUES"));
                  attributeBean.setExtraCheck(resultset.getString("EXTRA_CHECK"));
                  attributeBean.setRegex(resultset.getString("REGEX"));
                  attributeBean.setBussinessMessage(resultset.getString("BUSSINESS_MESSAGE"));
                  attributeBean.setDesscription(resultset.getString("DESCRIPTION"));
                  attributeBeanMap.put(attributeBean.getAttributeName(), attributeBean);
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
              return Collections.unmodifiableMap(attributeBeanMap);
          }
          catch (Exception e22) {
              // OFMException e22;
              if (!(e22 instanceof OFMException)) {
                  e22 = new OFMException("OFM RunTime : Unable to Load OFM Attributes's", e22);
              } else {
                  ((OFMException)e22).setTechMessage("OFM RunTime : Unable to Load OFM Attributes's | " + ((OFMException)e22).getTechMessage());
              }
              try {
                  resultset.close();
              } catch (Exception attributeBeanMap) {
                  // empty catch block
              }
              try {
                  preparedStatement.close();
              } catch (Exception attributeBeanMap) {
                  // empty catch block
              }
              try {
                  connection.close();
              } catch (Exception attributeBeanMap) {
                  // empty catch block
              }
              throw e22;
          }
      }
}

