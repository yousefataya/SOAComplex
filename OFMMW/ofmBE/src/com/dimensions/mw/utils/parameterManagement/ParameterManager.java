package com.dimensions.mw.utils.parameterManagement;

import com.dimensions.mw.utils.OFMException;
import com.dimensions.mw.utils.parameterManagement.inMemoryData.ParameterBean;
import com.dimensions.mw.utils.parameterManagement.inMemoryData.ParameterSingleton;

public class ParameterManager {
    public void destroyInstance() {
        try {
            ParameterSingleton instance = ParameterSingleton.getInstance();
            if (instance != null) {
                instance.destroyInstance();
            }
        }
        catch (Exception instance) {
            // empty catch block
        }
    }

    private ParameterBean getParam(String paramName) throws Exception {
        ParameterBean parameterBean = null;
        if (ParameterSingleton.getInstance() != null && ParameterSingleton.getInstance().getParameterMap() != null) {
            parameterBean = ParameterSingleton.getInstance().getParameterMap().get(paramName);
        }
        return parameterBean;
    }

    public String getParamValue(String paramName) throws Exception {
        ParameterBean paramBean = null;
        paramBean = this.getParam(paramName);
        String val = null;
        if (paramBean != null) {
            val = paramBean.getParamValue();
        }
        return val;
    }

    public String getMandatoryParamValue(String paramName) throws Exception {
        ParameterBean paramBean = null;
        paramBean = this.getParam(paramName);
        String val = null;
        if (paramBean != null) {
            val = paramBean.getParamValue();
        }
        if (val == null || val == "") {
            throw new OFMException("OFM Application : Unable to Find Parameter [ " + paramName + " ] , Parameter Entry not Found", null);
        }
        return val;
    }

    public static void main(String[] args) {
    }
}

