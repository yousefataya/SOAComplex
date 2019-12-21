package com.dimensions.mw.utils.errorManagement;

import com.dimensions.mw.utils.errorManagement.inMemoryData.ErrorCriteriaBean;
import com.dimensions.mw.utils.errorManagement.inMemoryData.ErrorDefinitionBean;
import com.dimensions.mw.utils.errorManagement.inMemoryData.ErrorSingleton;
import java.util.ArrayList;
import java.util.Map;

public class ErrorManager {
    public void destroyInstance() throws Exception {
        ErrorSingleton instance = ErrorSingleton.getInstance();
        if (instance != null) {
            instance.destroyInstance();
        }
    }

    public Map<String, Map<String, Map<String, ArrayList<ErrorCriteriaBean>>>> getErrorCriteriaMap() throws Exception {
        Map<String, Map<String, Map<String, ArrayList<ErrorCriteriaBean>>>> errorCriteriaMap = null;
        if (ErrorSingleton.getInstance() != null) {
            errorCriteriaMap = ErrorSingleton.getInstance().getErrorCriteriaMap();
        }
        return errorCriteriaMap;
    }

    public ErrorDefinitionBean getErrorDefinitionBeanByCode(String errorCode) throws Exception {
        ErrorDefinitionBean errorDefinitionBean = null;
        if (ErrorSingleton.getInstance() != null && ErrorSingleton.getInstance().getErrorDefinitionMap() != null) {
            errorDefinitionBean = ErrorSingleton.getInstance().getErrorDefinitionMap().get(errorCode);
        }
        return errorDefinitionBean;
    }

    private ErrorDefinitionBean getErrorObj(ArrayList<ErrorCriteriaBean> codeList, String errorString) {
        ErrorDefinitionBean errorDefinitionBean = null;
        for (ErrorCriteriaBean errorCriteriaBean : codeList) {
            if (!errorString.contains(errorCriteriaBean.getErrorString())) continue;
            ErrorManager errorManager = new ErrorManager();
            try {
                errorDefinitionBean = errorManager.getErrorDefinitionBeanByCode(errorCriteriaBean.getErrorCode());
                if (errorDefinitionBean != null) break;
                errorDefinitionBean = new ErrorDefinitionBean();
                errorDefinitionBean.setErrorBussinessCode("AF0000");
                errorDefinitionBean.setErrorBussinessMessage("Application Fault : Unable to FulFill Transaction, Please Contact Administrator.");
                errorDefinitionBean.setErrorTechCode("OFM-APP-0000");
                errorDefinitionBean.setErrorTechMessage("OFM Fault, No Data Found for  Error " + errorCriteriaBean.getErrorCode());
            }
            catch (Exception e) {
                errorDefinitionBean = new ErrorDefinitionBean();
                errorDefinitionBean.setErrorBussinessCode("AF0000");
                errorDefinitionBean.setErrorBussinessMessage("Application Fault : Unable to FulFill Transaction, Please Contact Administrator.");
                errorDefinitionBean.setErrorTechCode("OFM-APP-0000");
                errorDefinitionBean.setErrorTechMessage("OFM Fault, Exception in Get Object.");
                errorDefinitionBean.setErrorTechDetails(e.getMessage());
            }
            break;
        }
        return errorDefinitionBean;
    }

    public ErrorDefinitionBean getErrorInformation(String errorString, String techSystem, String techSystemOperation, String processName) {
        ArrayList<ErrorCriteriaBean> errorList2;
        Map<String, Map<String, Map<String, ArrayList<ErrorCriteriaBean>>>> errorsMap;
        ErrorDefinitionBean errorDefinitionBean = null;
        ErrorManager errorManager = new ErrorManager();
        try {
            errorsMap = errorManager.getErrorCriteriaMap();
        }
        catch (Exception e) {
            errorDefinitionBean = new ErrorDefinitionBean();
            errorDefinitionBean.setErrorBussinessCode("AF0000");
            errorDefinitionBean.setErrorBussinessMessage("Application Fault : Unable to FulFill Transaction, Please Contact Administrator.");
            errorDefinitionBean.setErrorTechCode("OFM-APP-0000");
            errorDefinitionBean.setErrorTechMessage("OFM Fault, Exception in Getting Error Criteria Map.");
            errorDefinitionBean.setErrorTechDetails(e.getMessage());
            return errorDefinitionBean;
        }
        boolean found = false;
        try {
            errorList2 = errorsMap.get(techSystem).get(techSystemOperation).get(processName);
            errorDefinitionBean = this.getErrorObj(errorList2, errorString);
            if (errorDefinitionBean != null) {
                found = true;
                }
            } catch (Exception ex) { }
        if (!found) {
            try {
                errorList2 = errorsMap.get(techSystem).get(techSystemOperation).get("*");
                errorDefinitionBean = this.getErrorObj(errorList2, errorString);
                if (errorDefinitionBean != null) {
                    found = true;
                }
            }
            catch (Exception errorList3) {
                // empty catch block
            }
        }
        if (!found) {
            try {
                errorList2 = errorsMap.get(techSystem).get("*").get(processName);
                errorDefinitionBean = this.getErrorObj(errorList2, errorString);
                if (errorDefinitionBean != null) {
                    found = true;
                }
            }
            catch (Exception errorList4) {
                // empty catch block
            }
        }
        if (!found) {
            try {
                errorList2 = errorsMap.get(techSystem).get("*").get("*");
                errorDefinitionBean = this.getErrorObj(errorList2, errorString);
                if (errorDefinitionBean != null) {
                    found = true;
                }
            }
            catch (Exception errorList5) {
                // empty catch block
            }
        }
        if (errorDefinitionBean == null) {
            try {
                errorDefinitionBean = errorManager.getErrorDefinitionBeanByCode("00000");
                if (errorDefinitionBean == null) {
                    errorDefinitionBean.setErrorBussinessCode("AF0000");
                    errorDefinitionBean.setErrorBussinessMessage("Application Fault : Unable to FulFill Transaction, Please Contact Administrator.");
                    errorDefinitionBean.setErrorTechCode("OFM-APP-0000");
                    errorDefinitionBean.setErrorTechMessage("OFM Fault, Exception in Getting Default Error.");
                    errorDefinitionBean.setErrorTechDetails("Error Definition Map is null ");
                }
            }
            catch (Exception e) {
                errorDefinitionBean = new ErrorDefinitionBean();
                errorDefinitionBean.setErrorBussinessCode("AF0000");
                errorDefinitionBean.setErrorBussinessMessage("Application Fault : Unable to FulFill Transaction, Please Contact Administrator.");
                errorDefinitionBean.setErrorTechCode("OFM-APP-0000");
                errorDefinitionBean.setErrorTechMessage("OFM Fault, Exception in Getting Default Error.");
                errorDefinitionBean.setErrorTechDetails(e.getMessage());
            }
        }
        ErrorDefinitionBean result = new ErrorDefinitionBean();
        result.setErrorBussinessCode(errorDefinitionBean.getErrorBussinessCode());
        result.setErrorBussinessMessage(errorDefinitionBean.getErrorBussinessMessage());
        result.setErrorTechCode(errorDefinitionBean.getErrorTechCode());
        result.setErrorTechMessage(errorDefinitionBean.getErrorTechMessage());
        result.setErrorTechDetails(errorDefinitionBean.getErrorTechDetails() + " | faultStr=[" + errorString + "]");
        return result;
    }

    public static void main(String[] args) {
    }
}

