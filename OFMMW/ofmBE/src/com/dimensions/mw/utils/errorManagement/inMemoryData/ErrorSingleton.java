package com.dimensions.mw.utils.errorManagement.inMemoryData;

import com.dimensions.mw.utils.errorManagement.inMemoryData.ErrorCriteriaBean;
import com.dimensions.mw.utils.errorManagement.inMemoryData.ErrorDB;
import com.dimensions.mw.utils.errorManagement.inMemoryData.ErrorDefinitionBean;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Map;

public class ErrorSingleton {
    private static volatile ErrorSingleton instance = null;
    private Map<String, Map<String, Map<String, ArrayList<ErrorCriteriaBean>>>> errorCriteriaMap;
    private Map<String, ErrorDefinitionBean> errorDefinitionMap;
    private ErrorDB errorDB;

    private ErrorSingleton() {
    }

    public static synchronized ErrorSingleton getInstance() throws Exception {
        if (instance != null) return instance;
        synchronized (ErrorSingleton.class) {
            instance = new ErrorSingleton();
            ErrorSingleton.instance.errorDB = new ErrorDB();
            try {
                Map<String, Map<String, Map<String, ArrayList<ErrorCriteriaBean>>>> errorMap = ErrorSingleton.instance.errorDB.loadErrorCriteriaList();
                ErrorSingleton.instance.errorCriteriaMap = errorMap;
                Map<String, ErrorDefinitionBean> errorDef = ErrorSingleton.instance.errorDB.loadErrorDefinitionMap();
                ErrorSingleton.instance.errorDefinitionMap = errorDef;
                System.out.println("******************* ErrorSingleton is Refreshed ******************");
            }
            catch (Exception ex) {
                ErrorSingleton.instance.errorCriteriaMap = null;
                ErrorSingleton.instance.errorDefinitionMap = null;
                instance = null;
                throw ex;
            }
            return instance;
        }
    }

    public void destroyInstance() throws Exception {
        instance = null;
        ErrorSingleton.getInstance();
    }

    public synchronized void setErrorDefinitionMap(Map<String, ErrorDefinitionBean> errorDefinitionMap) {
        this.errorDefinitionMap = errorDefinitionMap;
    }

    public synchronized Map<String, ErrorDefinitionBean> getErrorDefinitionMap() {
        return this.errorDefinitionMap;
    }

    public synchronized void setErrorCriteriaMap(Map<String, Map<String, Map<String, ArrayList<ErrorCriteriaBean>>>> errorCriteriaList) {
        this.errorCriteriaMap = errorCriteriaList;
    }

    public synchronized Map<String, Map<String, Map<String, ArrayList<ErrorCriteriaBean>>>> getErrorCriteriaMap() {
        return this.errorCriteriaMap;
    }
}

