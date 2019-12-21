package com.dimensions.mw.utils.errorManagement.inMemoryData;

public class ErrorCriteriaBean {
    private String errorCode;
    private String errorString;
    private String system;
    private String Operation;
    private String processName;

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorString(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return this.errorString;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getSystem() {
        return this.system;
    }

    public void setOperation(String Operation) {
        this.Operation = Operation;
    }

    public String getOperation() {
        return this.Operation;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getProcessName() {
        return this.processName;
    }
}

