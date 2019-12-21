package com.dimensions.mw.utils.attributeManagement.inMemoryData;

public class AttributeBean {
    private String attributeName;
    private String dataType;
    private String dataPrefix;
    private String dataLength;
    private String dataValues;
    private String extraCheck;
    private String regex;
    private String bussinessMessage;
    private String desscription;

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeName() {
        return this.attributeName;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataType() {
        return this.dataType;
    }

    public void setDataPrefix(String dataPrefix) {
        this.dataPrefix = dataPrefix;
    }

    public String getDataPrefix() {
        return this.dataPrefix;
    }

    public void setDataLength(String dataLength) {
        this.dataLength = dataLength;
    }

    public String getDataLength() {
        return this.dataLength;
    }

    public void setDataValues(String dataValues) {
        this.dataValues = dataValues;
    }

    public String getDataValues() {
        return this.dataValues;
    }

    public void setExtraCheck(String extraCheck) {
        this.extraCheck = extraCheck;
    }

    public String getExtraCheck() {
        return this.extraCheck;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return this.regex;
    }

    public void setBussinessMessage(String bussinessMessage) {
        this.bussinessMessage = bussinessMessage;
    }

    public String getBussinessMessage() {
        return this.bussinessMessage;
    }

    public void setDesscription(String desscription) {
        this.desscription = desscription;
    }

    public String getDesscription() {
        return this.desscription;
    }
}

