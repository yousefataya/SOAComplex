package com.dimensions.mw.utils.emailManagement;

import com.dimensions.mw.utils.emailManagement.Helper.EmailDB;
import com.dimensions.mw.utils.emailManagement.Helper.EmailLogic;
import com.dimensions.mw.utils.emailManagement.Helper.EmailTemplateBean;
import java.util.ArrayList;

public class EmailManager {
    public static void main(String[] args) {
        String processName = "CheckPackageRegistration";
        String transactionId = "928a-5b64f9342c6b-1410266528776";
        String tempId = "2";
        EmailTemplateBean emailBean = new EmailTemplateBean();
        EmailDB emailDB = new EmailDB();
        String emailSubject = "";
        String emailBody = "";
        ArrayList<String> attachmentEntries = new ArrayList<String>();
        attachmentEntries.add("C:\\Users\\aamour\\Desktop\\1.jpg");
        emailBean = emailDB.getEmailTemplateByID(tempId);
        emailSubject = emailBean.getEmailSubject();
        emailSubject = String.format(emailSubject, "Test");
        emailBody = emailBean.getEmailBody();
        emailBody = String.format(emailBody, "A'amour", "Testing");
        emailBean.setEmailBody(emailBody);
        emailBean.setEmailSubject(emailSubject);
        emailBean.setAttachments(attachmentEntries);
        EmailManager emailManager = new EmailManager();
        emailManager.processEmail(processName, transactionId, emailBean);
    }

    public void processEmail(String ofmProcessName, String ofmTransactionID, EmailTemplateBean emailTempBean) {
        EmailLogic logic = new EmailLogic();
        logic.processEmail(ofmProcessName, ofmTransactionID, emailTempBean);
    }

    public void asyncProcessEmail(String ofmProcessName, String ofmExecutionID, EmailTemplateBean emailTempBean) {
        EmailLogic logic = new EmailLogic();
        logic.asyncProcessEmail(ofmProcessName, ofmExecutionID, emailTempBean);
    }
}

