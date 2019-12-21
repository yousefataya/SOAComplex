package com.dimensions.mw.utils.loggerManagement.Helper;

import com.dimensions.mw.utils.connectionManagement.ConnectionManager;
import com.dimensions.mw.utils.emailManagement.EmailManager;
import com.dimensions.mw.utils.emailManagement.Helper.EmailDB;
import com.dimensions.mw.utils.emailManagement.Helper.EmailTemplateBean;
import com.dimensions.mw.utils.sqlManagement.QueriesManager;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LoggerDB {
    public void insertProcessInstance(String compositeName, String ofmTransactionId, String sourceAppCode, String sourceTransactionId, String sourceAppUsername, String executionInput, String compositeTransactionId, String domainName, String managedServerName, String businessKey) {
        Connection con = null;
        PreparedStatement prest = null;
        QueriesManager queryManager = null;
        try {
            queryManager = new QueriesManager();
            con = ConnectionManager.getOFMConnection();
            String sql = queryManager.getQuery("SQ-LoggerDB-insertProcessInstance-01");
            SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss, SSS");
            Date now = new Date();
            String strDate = sdfDate.format(now);
            prest = con.prepareStatement(sql);
            prest.setString(1, compositeName);
            prest.setString(2, ofmTransactionId);
            prest.setString(3, sourceAppCode);
            prest.setString(4, sourceTransactionId);
            prest.setString(5, sourceAppUsername);
            byte[] bindata = executionInput.getBytes();
            ByteArrayInputStream bais = new ByteArrayInputStream(bindata);
            prest.setBinaryStream(6, (InputStream)bais, bindata.length);
            prest.setString(7, "N");
            prest.setString(8, strDate);
            prest.setString(9, compositeTransactionId);
            prest.setString(10, domainName);
            prest.setString(11, managedServerName);
            prest.setString(12, businessKey);
            prest.executeUpdate();
            con.commit();
            try {
                prest.close();
            }
            catch (Exception exception) {
                // empty catch block
            }
            try {
                con.close();
            }
            catch (Exception exception) {}
        }
        catch (Exception ex) {
            try {
                prest.close();
            }
            catch (Exception sdfDate) {
                // empty catch block
            }
            try {
                con.close();
            }
            catch (Exception sdfDate) {
                // empty catch block
            }
            EmailTemplateBean emailBean = new EmailTemplateBean();
            EmailDB emailDB = new EmailDB();
            emailBean = emailDB.getEmailTemplateByID("3");
            String emailBody = emailBean.getEmailBody();
            emailBody = String.format(emailBody, "inserting");
            emailBean.setEmailBody(emailBody);
            String emailSubject = emailBean.getEmailSubject();
            emailSubject = String.format(emailSubject, compositeName);
            emailBean.setEmailSubject(emailSubject);
            ArrayList<String> attachments = new ArrayList<String>();
            emailBean.setAttachments(attachments);
            EmailManager emailManager = new EmailManager();
            emailManager.asyncProcessEmail(compositeName, ofmTransactionId, emailBean);
        }
    }

    public void updateProcessInstance(String ofmTransactionId, String executionOutput, String status, String compositeName) {
        Connection con = null;
        PreparedStatement prest = null;
        try {
            con = ConnectionManager.getOFMConnection();
            QueriesManager queryManager = new QueriesManager();
            String sql = queryManager.getQuery("SQ-LoggerDB-updateProcessInstance-01");
            SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss, SSS");
            Date now = new Date();
            String endDate = sdfDate.format(now);
            prest = con.prepareStatement(sql);
            prest.setString(1, endDate);
            byte[] bindata = executionOutput.getBytes();
            ByteArrayInputStream bais = new ByteArrayInputStream(bindata);
            prest.setBinaryStream(2, (InputStream)bais, bindata.length);
            prest.setString(3, status);
            prest.setString(4, ofmTransactionId);
            prest.executeUpdate();
            con.commit();
            try {
                prest.close();
            }
            catch (Exception exception) {
                // empty catch block
            }
            try {
                con.close();
            }
            catch (Exception exception) {}
        }
        catch (Exception ex) {
            try {
                prest.close();
            }
            catch (Exception sql) {
                // empty catch block
            }
            try {
                con.close();
            }
            catch (Exception sql) {
                // empty catch block
            }
            EmailTemplateBean emailBean = new EmailTemplateBean();
            EmailDB emailDB = new EmailDB();
            emailBean = emailDB.getEmailTemplateByID("3");
            String emailBody = emailBean.getEmailBody();
            emailBody = String.format(emailBody, "updating");
            emailBean.setEmailBody(emailBody);
            String emailSubject = emailBean.getEmailSubject();
            emailSubject = String.format(emailSubject, compositeName);
            emailBean.setEmailSubject(emailSubject);
            ArrayList<String> attachments = new ArrayList<String>();
            emailBean.setAttachments(attachments);
            EmailManager emailManager = new EmailManager();
            emailManager.asyncProcessEmail(compositeName, ofmTransactionId, emailBean);
        }
    }
}

