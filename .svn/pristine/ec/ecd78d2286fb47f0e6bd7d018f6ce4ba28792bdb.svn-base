package com.dimensions.mw.utils.validationManagement.beans;

public class ValidationFaultBean {
    private String techErrorCode;
    private String techMessage;
    private String techDetails;
    private String system;
    private String systemOperation;
    private boolean javaError;

    public ValidationFaultBean() {
    }

    public ValidationFaultBean(String techErrorCode, String techMessage, String system, String systemOperation, boolean javaError) {
        this.techErrorCode = techErrorCode;
        this.techMessage = techMessage;
        this.system = system;
        this.systemOperation = systemOperation;
        this.javaError = javaError;
    }

    public ValidationFaultBean(String techErrorCode, String techMessage, String system, String systemOperation, String techDetails) {
        this.techErrorCode = techErrorCode;
        this.techMessage = techMessage;
        this.techDetails = techDetails;
        this.system = system;
        this.systemOperation = systemOperation;
    }

    public ValidationFaultBean(String techErrorCode, String techMessage, String system, String systemOperation, boolean javaError, Exception ex) {
        this.techErrorCode = techErrorCode;
        this.techMessage = techMessage;
        this.system = system;
        this.systemOperation = systemOperation;
        this.javaError = javaError;
        if (ex != null) {
            this.techDetails = "[" + ex.getClass() + " | " + ex.getCause() + " - " + ex.getLocalizedMessage() + " | " + ex.getMessage();
            if (ex.getCause() != null) {
                this.techDetails = this.techDetails + " - " + ex.getCause().toString();
            }
            int count = 0;
            for (StackTraceElement trace : ex.getStackTrace()) {
                if (count > 8) break;
                this.techDetails = this.techDetails + " - " + trace.toString();
                ++count;
            }
            this.techDetails = this.techDetails + "]";
        } else {
            this.techDetails = "[ NULL EX ]";
        }
    }

    public void setTechErrorCode(String techError) {
        this.techErrorCode = techError;
    }

    public String getTechErrorCode() {
        return this.techErrorCode;
    }

    public void setTechMessage(String techMessage) {
        this.techMessage = techMessage;
    }

    public String getTechMessage() {
        return this.techMessage;
    }

    public void setTechDetails(String techDetails) {
        this.techDetails = techDetails;
    }

    public String getTechDetails() {
        return this.techDetails;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getSystem() {
        return this.system;
    }

    public void setSystemOperation(String systemOperation) {
        this.systemOperation = systemOperation;
    }

    public String getSystemOperation() {
        return this.systemOperation;
    }

    public void setJavaError(boolean javaError) {
        this.javaError = javaError;
    }

    public boolean isJavaError() {
        return this.javaError;
    }
}

