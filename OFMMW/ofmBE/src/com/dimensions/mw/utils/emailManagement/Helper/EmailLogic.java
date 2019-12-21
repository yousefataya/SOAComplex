package com.dimensions.mw.utils.emailManagement.Helper;

import com.dimensions.mw.utils.OFMException;
import com.dimensions.mw.utils.parameterManagement.ParameterManager;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailLogic {
    public void processEmail(String ofmProcessName, String ofmTransactionID, EmailTemplateBean emailTempBean) {
        EmailDB emailDB = new EmailDB();
        try {
            emailDB.insertEmailLogData(ofmProcessName, ofmTransactionID, emailTempBean.getTemplateID(), emailTempBean.getEmailTo(), emailTempBean.getEmailCC(), emailTempBean.getEmailBCC(), emailTempBean.getEmailSubject(), emailTempBean.getEmailBody());
            this.sendEmail(emailTempBean);
        }
        catch (Exception e) {
            OFMException ex = (OFMException)e;
            emailDB.updateEmailLogData(ofmProcessName, ofmTransactionID, ex.getTechMessage());
        }
    }

    public void asyncProcessEmail(final String ofmProcessName, final String ofmExecutionID, final EmailTemplateBean emailTempBean) {
        Runnable sendEmail = new Runnable(){

            @Override
            public void run() {
                EmailLogic.this.processEmail(ofmProcessName, ofmExecutionID, emailTempBean);
            }
        };
        new Thread(sendEmail, "sendEmail").start();
    }

    private void sendEmail(EmailTemplateBean emailBean) throws Exception {
        try {
            MimeMultipart multipart = new MimeMultipart();
            ParameterManager parameterManager = new ParameterManager();
            String username = parameterManager.getParamValue("OFM_BE_EMAIL_USERNAME");
            String password = parameterManager.getParamValue("OFM_BE_EMAIL_PASSWORD");
            String host = parameterManager.getParamValue("OFM_BE_EMAIL_HOST");
            String port = parameterManager.getParamValue("OFM_BE_EMAIL_PORT");
            String needAuth = parameterManager.getParamValue("OFM_BE_EMAIL_AUTH");
            String from = parameterManager.getParamValue("OFM_BE_EMAIL_FROM");
            Properties props = new Properties();
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", port);
            props.put("mail.smtp.auth", needAuth);
            props.put("mail.smtp.starttls.enable", "false");
            Session session = Session.getInstance((Properties)props);
            MimeMessage message = new MimeMessage(session);
            if (emailBean.getEmailTo() != null) {
                message.addRecipients(Message.RecipientType.TO, (Address[])InternetAddress.parse((String)emailBean.getEmailTo()));
            }
            if (emailBean.getEmailCC() != null) {
                message.addRecipients(Message.RecipientType.CC, (Address[])InternetAddress.parse((String)emailBean.getEmailCC()));
            }
            if (emailBean.getEmailBCC() != null) {
                message.addRecipients(Message.RecipientType.BCC, (Address[])InternetAddress.parse((String)emailBean.getEmailBCC()));
            }
            message.setSubject(emailBean.getEmailSubject());
            message.setText("OFM Mail \n");
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(emailBean.getEmailBody());
            multipart.addBodyPart((BodyPart)messageBodyPart);
            message.setFrom((Address)new InternetAddress(from));
            MimeBodyPart attachmentBodyPart = null;
            for (int i = 0; i < emailBean.getAttachments().size(); ++i) {
                attachmentBodyPart = new MimeBodyPart();
                attachmentBodyPart.attachFile(emailBean.getAttachments().get(i));
                multipart.addBodyPart((BodyPart)attachmentBodyPart);
            }
            message.setContent((Multipart)multipart);
            Transport.send((Message)message);
        }
        catch (Exception e) {
            StringWriter writer = new StringWriter();
            PrintWriter printWriter = new PrintWriter(writer);
            e.printStackTrace(printWriter);
            printWriter.flush();
            throw e;
        }
    }

}

