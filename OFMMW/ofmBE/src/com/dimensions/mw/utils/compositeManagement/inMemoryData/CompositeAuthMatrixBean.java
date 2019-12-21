package com.dimensions.mw.utils.compositeManagement.inMemoryData;

public class CompositeAuthMatrixBean {
    String compositeName;
    String sourceSystem;
    String sourceIPAdress;
    String token;
    String userName;

    public void setCompositeName(String compositeName) {
        this.compositeName = compositeName;
    }

    public String getCompositeName() {
        return this.compositeName;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public String getSourceSystem() {
        return this.sourceSystem;
    }

    public void setSourceIPAdress(String sourceIPAdress) {
        this.sourceIPAdress = sourceIPAdress;
    }

    public String getSourceIPAdress() {
        return this.sourceIPAdress;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }
}

