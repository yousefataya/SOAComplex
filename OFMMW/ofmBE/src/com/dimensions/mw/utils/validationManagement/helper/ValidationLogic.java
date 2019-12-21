package com.dimensions.mw.utils.validationManagement.helper;

import com.dimensions.mw.utils.OFMException;
import com.dimensions.mw.utils.attributeManagement.AttributeManager;
import com.dimensions.mw.utils.compositeManagement.CompositeManager;
import com.dimensions.mw.utils.errorManagement.ErrorManager;
import com.dimensions.mw.utils.errorManagement.inMemoryData.ErrorDefinitionBean;
import com.dimensions.mw.utils.validationManagement.beans.ValidationFaultBean;

public class ValidationLogic {
    public /* varargs */ ValidationFaultBean isAllowedSource(String ... params) {
        ValidationFaultBean validationFaultBean = null;
        try {
            CompositeManager manager = new CompositeManager();
            validationFaultBean = manager.isAllowedSource(params[0], params[1], params[2]);
        }
        catch (Exception exc) {
            String msg = ((OFMException)exc).getTechMessage();
            ErrorManager errorManger = new ErrorManager();
            ErrorDefinitionBean error = errorManger.getErrorInformation(msg, "OFM", "VAL", "VAL");
            validationFaultBean = new ValidationFaultBean(error.getErrorBussinessCode(), error.getErrorBussinessMessage(), error.getErrorTechCode(), error.getErrorTechMessage(), error.getErrorTechDetails());
        }
        return validationFaultBean;
    }

    public /* varargs */ ValidationFaultBean isItAllowedSource(String ... params) {
        ValidationFaultBean validationFaultBean = null;
        try {
            CompositeManager manager = new CompositeManager();
            validationFaultBean = manager.isAllowedSource(params[0], params[1], params[2], params[3], params[4]);
        }
        catch (Exception exc) {
            String msg = ((OFMException)exc).getTechMessage();
            ErrorManager errorManger = new ErrorManager();
            ErrorDefinitionBean error = errorManger.getErrorInformation(msg, "OFM", "VAL", "VAL");
            validationFaultBean = new ValidationFaultBean(error.getErrorBussinessCode(), error.getErrorBussinessMessage(), error.getErrorTechCode(), error.getErrorTechMessage(), error.getErrorTechDetails());
        }
        return validationFaultBean;
    }

    public /* varargs */ ValidationFaultBean validateAttributes(String ... params) {
        ValidationFaultBean validationFaultBean = null;
        try {
            validationFaultBean = AttributeManager.validateMultiAttributes(params);
        }
        catch (Exception exc) {
            String msg = ((OFMException)exc).getTechMessage();
            ErrorManager errorManger = new ErrorManager();
            ErrorDefinitionBean error = errorManger.getErrorInformation(msg, "OFM", "VAL", "VAL");
            validationFaultBean = new ValidationFaultBean(error.getErrorBussinessCode(), error.getErrorBussinessMessage(), error.getErrorTechCode(), error.getErrorTechMessage(), error.getErrorTechDetails());
        }
        return validationFaultBean;
    }
}

