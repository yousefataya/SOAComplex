package com.dimensions.mw.utils.attributeManagement;

import com.dimensions.mw.utils.attributeManagement.Helper.AttributeLogic;
import com.dimensions.mw.utils.attributeManagement.inMemoryData.AttributeBean;
import com.dimensions.mw.utils.attributeManagement.inMemoryData.AttributeSingleton;
import com.dimensions.mw.utils.validationManagement.beans.ValidationFaultBean;

public class AttributeManager {
    public static void main(String[] args) {
    }

    public void destroyInstance() throws Exception {
        AttributeSingleton instance = AttributeSingleton.getInstance();
        if (instance != null) {
            instance.destroyInstance();
        }
    }

    public AttributeBean getAttributeBean(String attribuyeName) throws Exception {
        AttributeBean attributeBean = null;
        if (attribuyeName != null && AttributeSingleton.getInstance().getAttributeDataMap() != null) {
            attributeBean = new AttributeBean();
            attributeBean = AttributeSingleton.getInstance().getAttributeDataMap().get(attribuyeName);
        }
        return attributeBean;
    }

    public static ValidationFaultBean validateMultiAttributes(String ... params) throws Exception {
        ValidationFaultBean validationFaultBean = null;
        validationFaultBean = AttributeLogic.validateMultiAttributes(params);
        return validationFaultBean;
    }
}

