package com.dimensions.mw.utils.validationManagement.inMemoryData;

import java.util.Map;

public class ValidationSingleton {
    private static volatile ValidationSingleton instance = null;
    private Map<String, ValidationBean> validationDataMap;
    private ValidationDB validationDB;

    public static synchronized ValidationSingleton getInstance() throws Exception {
        if (instance != null) return instance;
        Class<ValidationSingleton> class_ = ValidationSingleton.class;
        synchronized (ValidationSingleton.class) {
            instance = new ValidationSingleton();
            ValidationSingleton.instance.validationDB = new ValidationDB();
            try {
                Map<String, ValidationBean> map = ValidationSingleton.instance.validationDB.loadValidationMapping();
                ValidationSingleton.instance.validationDataMap = map;
                System.out.println("******************* ValidationSingleton is Refreshed ******************");
            }
            catch (Exception e) {
                ValidationSingleton.instance.validationDataMap = null;
                instance = null;
                throw e;
            }
            return instance;
        }
    }

    public void destroyInstance() throws Exception {
        instance = null;
        ValidationSingleton.getInstance();
    }

    public synchronized void setValidationDataMap(Map<String, ValidationBean> mappingDataMap) {
        this.validationDataMap = mappingDataMap;
    }

    public synchronized Map<String, ValidationBean> getValidationDataMap() {
        return this.validationDataMap;
    }
}

