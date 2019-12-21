package com.dimensions.mw.utils.compositeManagement;

import com.dimensions.mw.utils.compositeManagement.Helper.CompositeLogic;
import com.dimensions.mw.utils.compositeManagement.inMemoryData.CompositeBean;
import com.dimensions.mw.utils.compositeManagement.inMemoryData.CompositeSingleton;
import com.dimensions.mw.utils.validationManagement.beans.ValidationFaultBean;

public class CompositeManager {
    public static String getUniqueId() {
        return CompositeLogic.getUniqueId();
    }

    public void destroyInstance() throws Exception {
        CompositeSingleton instance = CompositeSingleton.getInstance();
        if (instance != null) {
            instance.destroyInstance();
        }
    }

    public static CompositeBean getCompositeBean(String compositeName) throws Exception {
        if (compositeName != null && CompositeSingleton.getInstance() != null && CompositeSingleton.getInstance().getCompositeDataMap() != null) {
            CompositeBean compositeBean = CompositeSingleton.getInstance().getCompositeDataMap().get(compositeName);
            return compositeBean;
        }
        return null;
    }

    public ValidationFaultBean isAllowedSource(String compositeName, String source, String ip, String token, String userName) throws Exception {
        ValidationFaultBean validationFaultBean = null;
        validationFaultBean = CompositeLogic.isAllowedSource(compositeName, source, ip, token, userName);
        return validationFaultBean;
    }

    public ValidationFaultBean isAllowedSource(String compositeName, String source, String ip) throws Exception {
        ValidationFaultBean validationFaultBean = null;
        validationFaultBean = CompositeLogic.isAllowedSource(compositeName, source, ip);
        return validationFaultBean;
    }

    public static void main(String[] args) {
    }
}

