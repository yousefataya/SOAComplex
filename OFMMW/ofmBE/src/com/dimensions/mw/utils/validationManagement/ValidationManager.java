package com.dimensions.mw.utils.validationManagement;

import com.dimensions.mw.utils.OFMException;
import com.dimensions.mw.utils.errorManagement.ErrorManager;
import com.dimensions.mw.utils.errorManagement.inMemoryData.ErrorDefinitionBean;
import com.dimensions.mw.utils.validationManagement.beans.ValidationFaultBean;
import com.dimensions.mw.utils.validationManagement.helper.ValidationLogic;
import com.dimensions.mw.utils.validationManagement.inMemoryData.ValidationBean;
import com.dimensions.mw.utils.validationManagement.inMemoryData.ValidationSingleton;
import java.lang.reflect.Method;

public class ValidationManager {
    public void destroyInstance() throws Exception {
        ValidationSingleton instance = ValidationSingleton.getInstance();
        if (instance != null) {
            instance.destroyInstance();
        }
    }

    public static ValidationBean getValidationBean(String source, String processName, String elementName) throws Exception {
        ValidationBean validationBean = null;
        if (ValidationSingleton.getInstance() != null && ValidationSingleton.getInstance().getValidationDataMap() != null) {
            validationBean = ValidationSingleton.getInstance().getValidationDataMap().get(source + "_" + processName + "_" + elementName);
            if (validationBean != null) {
                return validationBean;
            }
            validationBean = ValidationSingleton.getInstance().getValidationDataMap().get(source + "_*_" + elementName);
            if (validationBean != null) {
                return validationBean;
            }
            validationBean = ValidationSingleton.getInstance().getValidationDataMap().get("*_*_" + elementName);
            if (validationBean != null) {
                return validationBean;
            }
            throw new OFMException("OFM Application : Unable to Find Validation Entry [ " + source + "_" + processName + "_" + elementName + " ] , Validation Entry not Found", null);
        }
        return validationBean;
    }

    public String ApplyValidation(String source, String processName, String elementName, String elementValue) {
        String errorMSG;
        block10 : {
            errorMSG = null;
            ValidationFaultBean validationFaultBean = null;
            try {
                ValidationBean bean = ValidationManager.getValidationBean(source, processName, elementName);
                if (bean == null) break block10;
                String[] targetValidations = bean.getTargetValidations().split("##");
                ValidationLogic logic = new ValidationLogic();
                Method method = null;
                for (int i = 0; i < targetValidations.length; ++i) {
                    try {
                        method = logic.getClass().getMethod(targetValidations[i], String[].class);
                    }
                    catch (Exception ex) {
                        OFMException e2 = new OFMException("OFM RunTime : Unable to Run Reflection Logic", ex);
                        ErrorManager errorManger = new ErrorManager();
                        ErrorDefinitionBean error = errorManger.getErrorInformation(e2.getTechMessage(), "OFM", "VAL", "VAL");
                        validationFaultBean = new ValidationFaultBean(error.getErrorBussinessCode(), error.getErrorBussinessMessage(), error.getErrorTechCode(), error.getErrorTechMessage(), error.getErrorTechDetails());
                        errorMSG = validationFaultBean.getTechErrorCode() + "#" + validationFaultBean.getTechMessage() + "##" + validationFaultBean.getSystem() + "###" + validationFaultBean.getSystemOperation() + "###-" + validationFaultBean.getTechDetails() + "#####";
                        break;
                    }
                    String[] parameters = elementValue.split("###");
                    validationFaultBean = (ValidationFaultBean)method.invoke(logic, new Object[]{parameters});
                    if (validationFaultBean != null) {
                        if (validationFaultBean.getTechDetails() == null || validationFaultBean.getTechDetails().equals("")) {
                            validationFaultBean.setTechDetails("");
                        }
                        errorMSG = validationFaultBean.isJavaError() ? validationFaultBean.getTechErrorCode() + "#" + validationFaultBean.getTechMessage() + "##Java:" + validationFaultBean.getSystem() + "###" + validationFaultBean.getSystemOperation() + "###-" + validationFaultBean.getTechDetails() + "#####" : validationFaultBean.getTechErrorCode() + "#" + validationFaultBean.getTechMessage() + "##" + validationFaultBean.getSystem() + "###" + validationFaultBean.getSystemOperation() + "###-" + validationFaultBean.getTechDetails() + "#####";
                    }
                    if (errorMSG == "" || errorMSG == null) {
                        continue;
                    }
                    break;
                }
            }
            catch (Exception e32) {
                if (!(e32 instanceof OFMException)) {
                    e32 = new OFMException("OFM RunTime : Unable to Apply OFM Validation", e32);
                } else {
                    ((OFMException)e32).setTechMessage("OFM RunTime : Unable to Apply OFM Validation | " + ((OFMException)e32).getTechMessage());
                }
                ErrorManager errorManger = new ErrorManager();
                ErrorDefinitionBean error = errorManger.getErrorInformation(((OFMException)e32).getTechMessage(), "OFM", "VAL", "VAL");
                validationFaultBean = new ValidationFaultBean(error.getErrorBussinessCode(), error.getErrorBussinessMessage(), error.getErrorTechCode(), error.getErrorTechMessage(), error.getErrorTechDetails());
                errorMSG = validationFaultBean.getTechErrorCode() + "#" + validationFaultBean.getTechMessage() + "##" + validationFaultBean.getSystem() + "###" + validationFaultBean.getSystemOperation() + "###-" + validationFaultBean.getTechDetails() + "#####";
            }
        }
        return errorMSG;
    }

    public static void main(String[] arge) {
    }
}

