package com.dimensions.mw.utils.parameterManagement.inMemoryData;

import java.util.HashMap;
import java.util.Map;

public class ParameterSingleton {
    private static volatile ParameterSingleton instance = null;
    private Map<String, ParameterBean> parameterMap = new HashMap<String, ParameterBean>();
    private ParameterDB paramDB;

    private ParameterSingleton() {
    }


    public static synchronized ParameterSingleton getInstance() throws Exception {
        if (instance != null) return instance;
        synchronized (ParameterSingleton.class) {
            instance = new ParameterSingleton();
            instance.parameterMap = new HashMap<String, ParameterBean>();
            instance.paramDB = new ParameterDB();
            try {
                Map<String, ParameterBean> map = instance.paramDB.loadParameters();
                instance.parameterMap = map;
                System.out.println("******************* ParameterSingleton is Refreshed ******************");
            }
            catch (Exception e) {
                instance.parameterMap = null;
                instance = null;
                throw e;
            }
            return instance;
        }
    }

    public void destroyInstance() throws Exception {
        instance = null;
        getInstance();
    }

    public synchronized void setParameterMap(Map<String, ParameterBean> parameterMap) {
        this.parameterMap = parameterMap;
    }

    public synchronized Map<String, ParameterBean> getParameterMap() {
        return this.parameterMap;
    }
}

