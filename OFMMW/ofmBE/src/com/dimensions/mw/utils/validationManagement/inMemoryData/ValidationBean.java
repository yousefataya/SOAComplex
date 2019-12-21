package com.dimensions.mw.utils.validationManagement.inMemoryData;

public class ValidationBean {
    String source;
    String processName;
    String elementName;
    String targetValidations;

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return this.source;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getProcessName() {
        return this.processName;
    }

    public void setElementName(String elemenName) {
        this.elementName = elemenName;
    }

    public String getElementName() {
        return this.elementName;
    }

    public void setTargetValidations(String targetValidations) {
        this.targetValidations = targetValidations;
    }

    public String getTargetValidations() {
        return this.targetValidations;
    }
}

