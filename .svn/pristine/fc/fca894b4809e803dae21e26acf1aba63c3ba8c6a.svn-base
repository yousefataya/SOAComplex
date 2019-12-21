package com.dimensions.mw.utils.attributeManagement.Helper;

import com.dimensions.mw.utils.OFMException;
import com.dimensions.mw.utils.attributeManagement.AttributeManager;
import com.dimensions.mw.utils.attributeManagement.inMemoryData.AttributeBean;
import com.dimensions.mw.utils.validationManagement.beans.ValidationFaultBean;

public class AttributeLogic {

    public AttributeLogic() {
    }
        
    private static ValidationFaultBean validateAttribute(String inputTageName, String inputKey, String inputValue) throws Exception {
        ValidationFaultBean validationFaultBean = null;
        String dataType = null;
        String dataLength = null;
        String dataPrefix = null;
        String dataValues = null;
        String regex = null;
        try {
            AttributeManager attributeManager = new AttributeManager();
            AttributeBean attributeBean = attributeManager.getAttributeBean(inputKey);
            if (attributeBean != null) {
                dataType = attributeBean.getDataType();
                dataLength = attributeBean.getDataLength();
                dataPrefix = attributeBean.getDataPrefix();
                dataValues = attributeBean.getDataValues();
                regex = attributeBean.getRegex();
                String bussinessMessage = attributeBean.getBussinessMessage();
                if (dataType != null && !dataType.equals("") && dataType != "") {
                    if (dataType.equals("N")) {
                        String tmpregex = "[0-9]+";
                        boolean isDigit = inputValue.matches(tmpregex);
                        if (!isDigit) {
                            validationFaultBean =
                            new ValidationFaultBean("VF0001", "Validation Fault : Unable to FulFill Transaction, Entry [ " + inputTageName + " ] has Invalid Value Format, Valid Format is Digits Only.",
                            "OFM-VAL-0007", "Entry [ " + inputTageName + " ] has Invalid Value Format, Valid Format is Digits Only.", false);
                        }
                    } else if (dataType.equals("D")) {
                        try {
                            Double.parseDouble(inputValue);
                        } catch (NumberFormatException nfe) {
                            validationFaultBean =
                                new ValidationFaultBean("VF0001", "Validation Fault : Unable to FulFill Transaction, Entry [ " + inputTageName + " ] has Invalid Value Format, Valid Format is Double Only.",
                                                        "OFM-VAL-0010", " Entry [ " + inputTageName + " ] has Invalid Value Format, Valid Format is Double Only.", false);
                        }
                    } else if (dataType.equals("DATE")) {
                        String dateRegex = "(0[1-9]|1[012])\\/(0[1-9]|[12][0-9]|3[01])\\/((19|20)\\d\\d)";
                        boolean isValidDate = inputValue.matches(dateRegex);
                        if (!isValidDate) {
                            validationFaultBean =
                                new ValidationFaultBean("VF0001", "Validation Fault : Unable to FulFill Transaction, Entry [ " + inputTageName + " ] has Invalid Value Format, Valid Format is [ MM/DD/YYYY ].",
                                                        "OFM-VAL-0006", "Entry [ " + inputTageName + " ] has Invalid Value Format, Valid Format is [ MM/DD/YYYY ].", false);
                        }
                    } else if (dataType.equals("DATETIME")) {
                        String dateRegex =
                            "(0[1-9]|1[012])\\/(0[1-9]|[12][0-9]|3[01])\\/((19|20)\\d\\d)(\\s(0[0-9]|1[0-9]|2[0-3]):(0[0-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9]):(0[0-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9]))";
                        boolean isValidDate = inputValue.matches(dateRegex);
                        if (!isValidDate) {
                            validationFaultBean =
                                new ValidationFaultBean("VF0001", "Validation Fault : Unable to FulFill Transaction, Entry [ " + inputTageName + " ] has Invalid Value Format, Valid Format is [MM/DD/YYYY  HH:mm:ss].",
                                                        "OFM-VAL-0009", "Entry [ " + inputTageName + " ] has Invalid Value Format, Valid Format is [MM/DD/YYYY  HH:mm:ss].", false);
                        }
                    }
                }
                if (validationFaultBean == null && dataLength != null && !dataLength.equals("") && dataLength != "") {
                    if (validationFaultBean == null && dataPrefix != null && !dataPrefix.equals("") && dataPrefix != "") { // length and prefix validation
                        if (!inputValue.startsWith(dataPrefix)) {
                            int length = (Integer.parseInt(dataLength) - dataPrefix.length()) + 1;
                            String format = "";
                            for (int i = 0; i < length; i++) {
                                format = i == 0 ? dataPrefix : format + "X";
                            }
                            validationFaultBean =
                                new ValidationFaultBean("VF0001", "Validation Fault : Unable to FulFill Transaction, Entry [ " + inputTageName + " ] has Invalid Value Format, Valid Format is [ " +
                                                        format + " ].", "OFM-VAL-0005", "Entry [ " + inputTageName + " ] has Invalid Value Format, Valid Format is [ " + format + " ].", false);
                        }
                    }
                    if (validationFaultBean == null && inputValue.length() != Integer.parseInt(dataLength)) { // length validation only
                        validationFaultBean =
                            new ValidationFaultBean("VF0001", "Validation Fault : Unable to FulFill Transaction, Entry [ " + inputTageName + " ] has Invalid Value Length, Valid Length is " +
                                                    dataLength + ".", "OFM-VAL-0008", "Entry [ " + inputTageName + " ] has Invalid Value Length, Valid Length is " + dataLength + ".", false);
                    }
                }
                if (validationFaultBean == null && dataValues != null && !dataValues.equals("") && dataValues != "") {
                    String modifiedLovValues = "|" + dataValues + "|";
                    if (!modifiedLovValues.contains("|" + inputValue + "|")) {
                        validationFaultBean =
                            new ValidationFaultBean("VF0001", "Validation Fault : Unable to FulFill Transaction, Entry [ " + inputTageName + " ] has Invalid Value, Valid Values are [ " +
                                                    dataValues + " ].", "OFM-VAL-0002", "Entry [ " + inputTageName + " ] has Invalid Value, Valid Values are [ " + dataValues + " ].", false);
                    }
                }
                if (validationFaultBean == null && regex != null && !regex.equals("") && regex != "") {
                    boolean isValidRegex = inputValue.matches(regex);
                    if (!isValidRegex) {
                        validationFaultBean =
                            new ValidationFaultBean("VF0001", "Validation Fault : Unable to FulFill Transaction, Entry [ " + inputTageName + " ] has Invalid Value, Valid Values Should Match  [ " +
                                                    regex + " ].", "OFM-VAL-0011", "Entry [ " + inputTageName + " ] has Invalid Value, Valid Values Should Match  [ " + regex + " ].", false);
                    }
                    if (validationFaultBean != null && bussinessMessage != null && !bussinessMessage.equals("") && bussinessMessage != "") {
                        if (bussinessMessage.contains("##")) {
                            bussinessMessage = bussinessMessage.replaceFirst("##", inputTageName);
                        }
                        if (bussinessMessage.contains("##")) {
                            bussinessMessage = bussinessMessage.replaceFirst("##", inputValue);
                        }
                        if (bussinessMessage.contains("##")) {
                            bussinessMessage = bussinessMessage.replaceFirst("##", dataValues);
                        }
                        validationFaultBean.setTechMessage(bussinessMessage);
                    }
                }
            }
        } catch (Exception e) {
            if (!(e instanceof OFMException)) {
                e = new OFMException("OFM RunTime : Unable to Apply Attribute Validation Logic, [ " + dataType + "," + dataLength + "," + dataPrefix + "," + dataValues + "," + regex + " ]", e);
            } else {
                ((OFMException)e).setTechMessage("OFM RunTime : Unable to Apply Attribute Validation Logic | " + ((OFMException)e).getTechMessage());
            }
            throw e;
        }
        return validationFaultBean;
    }
        
    public static ValidationFaultBean validateMultiAttributes(String... params) throws Exception {
        ValidationFaultBean validationFaultBean = null;
        try {
            for (int i = 0; i < params.length; i++) {
                String[] keyValuePair = params[i].split(":");
                if (keyValuePair.length == 3) {
                    validationFaultBean = validateAttribute(keyValuePair[0], keyValuePair[1], keyValuePair[2]);
                    if (validationFaultBean != null) {
                        break;
                    }
                } else if (keyValuePair.length > 3) {
                    String tagName = keyValuePair[0];
                    String key = keyValuePair[1];
                    String value = params[i].split(tagName + ":" + key + ":")[1];
                    validationFaultBean = validateAttribute(tagName, key, value);
                    if (validationFaultBean != null) {
                        break;
                    }
                }
                else if (keyValuePair.length == 1) {
                    continue;
                }
            }
        } catch (Exception e) {
            if (!(e instanceof OFMException)) {
                e = new OFMException("OFM RunTime : OFM RunTime : Unable to Apply Attribute Validation Logic", e);
            }
            throw e;
        }
        return validationFaultBean;
    }
        
    public static void main(String[] args) {
        try {
            AttributeLogic l = new AttributeLogic();
            AttributeManager m = new AttributeManager();
            String[] validate = new String[] { "Int Number 1" + ":" + "Int Number 1" + ":" + "00966543464175" };
            ValidationFaultBean x = m.validateMultiAttributes(validate);
        } catch (Exception e) {
        }
    }
}

