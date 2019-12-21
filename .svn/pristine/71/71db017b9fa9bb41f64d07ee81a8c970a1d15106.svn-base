package com.dimensions.mw.utils.compositeManagement.Helper;

import com.dimensions.mw.utils.OFMException;
import com.dimensions.mw.utils.compositeManagement.CompositeManager;
import com.dimensions.mw.utils.compositeManagement.inMemoryData.CompositeAuthMatrixBean;
import com.dimensions.mw.utils.compositeManagement.inMemoryData.CompositeBean;
import com.dimensions.mw.utils.validationManagement.beans.ValidationFaultBean;
import java.util.UUID;

public class CompositeLogic {
    private static int staticCounter = 0;

    public static String getUniqueId() {
        String val = null;
        try {
            String uuID = UUID.randomUUID().toString();
            uuID = uuID.substring(uuID.length() / 2 + 1, uuID.length());
            val = uuID + "-" + (System.currentTimeMillis() + (long)staticCounter++);
        }
        catch (Exception ex) {
            val = "" + System.currentTimeMillis();
        }
        return val;
    }

    public static ValidationFaultBean isAllowedSource(String compositeName, String source, String ip, String token, String userName) throws Exception {
        ValidationFaultBean validationFaultBean;
        boolean isAllowed;
        block6 : {
            isAllowed = false;
            validationFaultBean = null;
            try {
                CompositeBean compositeBean = CompositeManager.getCompositeBean(compositeName);
                if (compositeBean == null || compositeBean.getCompositeAuthMatrixBeanList() == null || compositeBean.getCompositeAuthMatrixBeanList().size() <= 0) break block6;
                for (CompositeAuthMatrixBean compositeAuthMatrixBean : compositeBean.getCompositeAuthMatrixBeanList()) {
                    if (compositeAuthMatrixBean.getSourceSystem() == null || !compositeAuthMatrixBean.getSourceSystem().equals(source) || compositeAuthMatrixBean.getSourceIPAdress() == null || !compositeAuthMatrixBean.getSourceIPAdress().equals("*") && !compositeAuthMatrixBean.getSourceIPAdress().equals(ip) || compositeAuthMatrixBean.getToken() == null || !compositeAuthMatrixBean.getToken().equals("*") && !compositeAuthMatrixBean.getToken().equals(token) || compositeAuthMatrixBean.getUserName() == null || !compositeAuthMatrixBean.getUserName().equals("*") && !compositeAuthMatrixBean.getUserName().equals(userName)) continue;
                    isAllowed = true;
                    break;
                }
            }
            catch (Exception e22) {
                if (!(e22 instanceof OFMException)) {
                    e22 = new OFMException("OFM RunTime : Unable to Apply Composite isAllowedSource Logic,", e22);
                } else {
                    ((OFMException)e22).setTechMessage("OFM RunTime : Unable to Apply Composite isAllowedSource Logic | " + ((OFMException)e22).getTechMessage());
                }
                throw e22;
            }
        }
        if (!isAllowed) {
            validationFaultBean = new ValidationFaultBean("VF0002", "Validation Fault : Unable to FulFill Transaction, System not Authorized.", "OFM-VAL-0020", "System not Authorized for Access to [" + compositeName + "].", false);
        }
        return validationFaultBean;
    }

    public static ValidationFaultBean isAllowedSource(String compositeName, String source, String ip) throws Exception {
        ValidationFaultBean validationFaultBean;
        boolean isAllowed;
        block6 : {
            isAllowed = false;
            validationFaultBean = null;
            try {
                CompositeBean compositeBean = CompositeManager.getCompositeBean(compositeName);
                if (compositeBean == null || compositeBean.getCompositeAuthMatrixBeanList() == null || compositeBean.getCompositeAuthMatrixBeanList().size() <= 0) break block6;
                for (CompositeAuthMatrixBean compositeAuthMatrixBean : compositeBean.getCompositeAuthMatrixBeanList()) {
                    if (compositeAuthMatrixBean.getSourceSystem() == null || !compositeAuthMatrixBean.getSourceSystem().equals(source) || compositeAuthMatrixBean.getSourceIPAdress() == null || !compositeAuthMatrixBean.getSourceIPAdress().equals("*") && !compositeAuthMatrixBean.getSourceIPAdress().equals(ip)) continue;
                    isAllowed = true;
                    break;
                }
            }
            catch (Exception e22) {
                if (!(e22 instanceof OFMException)) {
                    e22 = new OFMException("OFM RunTime : Unable to Apply Composite isAllowedSource Logic,", e22);
                } else {
                    ((OFMException)e22).setTechMessage("OFM RunTime : Unable to Apply Composite isAllowedSource Logic | " + ((OFMException)e22).getTechMessage());
                }
                throw e22;
            }
        }
        if (!isAllowed) {
            validationFaultBean = new ValidationFaultBean("VF0002", "Validation Fault : Unable to FulFill Transaction, System not Authorized.", "OFM-VAL-0020", "System not Authorized for Access to [" + compositeName + "].", false);
        }
        return validationFaultBean;
    }
}

