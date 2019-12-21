package com.dimensions.mw.utils.emailManagement.Helper;

import java.util.ArrayList;

public class EmailTemplateBean {
    private String templateID;
    private String emailTo;
    private String emailCC;
    private String emailBCC;
    private String emailSubject;
    private String emailBody;
    private ArrayList<String> attachments;

    public void setTemplateID(String templateID) {
        this.templateID = templateID;
    }

    public String getTemplateID() {
        return this.templateID;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getEmailTo() {
        return this.emailTo;
    }

    public void setEmailCC(String emailCC) {
        this.emailCC = emailCC;
    }

    public String getEmailCC() {
        return this.emailCC;
    }

    public void setEmailBCC(String emailBCC) {
        this.emailBCC = emailBCC;
    }

    public String getEmailBCC() {
        return this.emailBCC;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailSubject() {
        return this.emailSubject;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }

    public String getEmailBody() {
        return this.emailBody;
    }

    public void setAttachments(ArrayList<String> attachment) {
        this.attachments = attachment;
    }

    public ArrayList<String> getAttachments() {
        return this.attachments;
    }
}

