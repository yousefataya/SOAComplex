package com.dimensions.mw.utils.emailManagement.Helper;

import com.dimensions.mw.utils.connectionManagement.ConnectionManager;
import com.dimensions.mw.utils.sqlManagement.QueriesManager;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmailDB {
    public EmailTemplateBean getEmailTemplateByID(String templateID) {
        EmailTemplateBean emailTemplate = null;
        Connection connection = null;
        QueriesManager queryManager = null;
        ResultSet resultset = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionManager.getOFMConnection();
            queryManager = new QueriesManager();
            String sql = queryManager.getQuery("SQ-EmailDB-getEmailTemplateByID-01");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, templateID);
            resultset = preparedStatement.executeQuery();
            if (resultset.next()) {
                emailTemplate = new EmailTemplateBean();
                emailTemplate.setTemplateID(resultset.getString("TEMP_ID"));
                emailTemplate.setEmailTo(resultset.getString("EMAIL_TO"));
                emailTemplate.setEmailCC(resultset.getString("EMAIL_CC"));
                emailTemplate.setEmailBCC(resultset.getString("EMAIL_BCC"));
                emailTemplate.setEmailSubject(resultset.getString("EMAIL_SUBJECT"));
                emailTemplate.setEmailBody(resultset.getString("EMAIL_BODY"));
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
            if (emailTemplate == null) {
                throw new Exception();
            }
        }
        catch (Exception e) {
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
        }
        return emailTemplate;
    }

    public void insertEmailLogData(String ofmProcessName, String ofmTransactionID, String tempID, String to, String cc, String bcc, String subject, String body) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Connection con = ConnectionManager.getOFMConnection();
            QueriesManager queryManager = new QueriesManager();
            String sql = queryManager.getQuery("SQ-EmailDB-insertEmailLogData-01");
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, ofmProcessName);
            preparedStatement.setString(2, ofmTransactionID);
            preparedStatement.setString(3, tempID);
            preparedStatement.setString(4, to);
            preparedStatement.setString(5, cc);
            preparedStatement.setString(6, bcc);
            preparedStatement.setString(7, subject);
            byte[] bindata = body.getBytes();
            ByteArrayInputStream bais = new ByteArrayInputStream(bindata);
            preparedStatement.setBinaryStream(8, (InputStream)bais, bindata.length);
            preparedStatement.setString(9, "S");
            SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss, SSS");
            Date now = new Date();
            String executionDate = sdfDate.format(now);
            preparedStatement.setString(10, executionDate);
            bindata = "".getBytes();
            bais = new ByteArrayInputStream(bindata);
            preparedStatement.setBinaryStream(11, (InputStream)bais, bindata.length);
            preparedStatement.executeUpdate();
            con.commit();
            preparedStatement.close();
            con.close();
        }
        catch (Exception e) {
            try {
                preparedStatement.close();
            }
            catch (Exception bais) {
                // empty catch block
            }
            try {
                connection.close();
            }
            catch (Exception bais) {
                // empty catch block
            }
            e.printStackTrace();
        }
    }

    public void updateEmailLogData(String ofmProcessName, String ofmTransactionID, String errorMessage) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionManager.getOFMConnection();
            QueriesManager queryManager = new QueriesManager();
            String sql = queryManager.getQuery("SQ-EmailDB-updateEmailLogData-01");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "F");
            byte[] bindata = errorMessage.getBytes();
            ByteArrayInputStream bais = new ByteArrayInputStream(bindata);
            preparedStatement.setBinaryStream(2, (InputStream)bais, bindata.length);
            preparedStatement.setString(3, ofmProcessName);
            preparedStatement.setString(4, ofmTransactionID);
            preparedStatement.executeUpdate();
            connection.commit();
            preparedStatement.close();
            connection.close();
        }
        catch (Exception e) {
            try {
                preparedStatement.close();
            }
            catch (Exception bais) {
                // empty catch block
            }
            try {
                connection.close();
            }
            catch (Exception bais) {
                // empty catch block
            }
            e.printStackTrace();
        }
    }
}

