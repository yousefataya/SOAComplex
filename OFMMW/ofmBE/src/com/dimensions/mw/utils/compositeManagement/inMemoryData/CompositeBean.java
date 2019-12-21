package com.dimensions.mw.utils.compositeManagement.inMemoryData;

import java.util.List;

public class CompositeBean {
    String compositeName;
    String dbLog;
    List<CompositeAuthMatrixBean> compositeAuthMatrixBeanList;

    public void setCompositeName(String compositeName) {
        this.compositeName = compositeName;
    }

    public String getCompositeName() {
        return this.compositeName;
    }

    public void setDbLog(String dbLog) {
        this.dbLog = dbLog;
    }

    public String getDbLog() {
        return this.dbLog;
    }

    public void setCompositeAuthMatrixBeanList(List<CompositeAuthMatrixBean> compositeAuthMatrixBeanList) {
        this.compositeAuthMatrixBeanList = compositeAuthMatrixBeanList;
    }

    public List<CompositeAuthMatrixBean> getCompositeAuthMatrixBeanList() {
        return this.compositeAuthMatrixBeanList;
    }
}

