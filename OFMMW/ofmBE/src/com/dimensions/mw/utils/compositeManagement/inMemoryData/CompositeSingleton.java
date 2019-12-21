package com.dimensions.mw.utils.compositeManagement.inMemoryData;

import java.util.Map;

public class CompositeSingleton {
    private static volatile CompositeSingleton instance = null;
    private Map<String, CompositeBean> compositeDataMap;
    private CompositeDB compositeDB;

    public static synchronized CompositeSingleton getInstance() throws Exception {
        if (instance != null) return instance;
        synchronized (CompositeSingleton.class) {
            instance = new CompositeSingleton();
            CompositeSingleton.instance.compositeDB = new CompositeDB();
            try {
                Map<String, CompositeBean> map = CompositeSingleton.instance.compositeDB.loadCompositeDefinition();
                CompositeSingleton.instance.compositeDataMap = map;
                System.out.println("******************* CompositeSingleton is Refreshed ******************");
            }
            catch (Exception e) {
                CompositeSingleton.instance.compositeDataMap = null;
                instance = null;
                throw e;
            }
            return instance;
        }
    }

    public void destroyInstance() throws Exception {
        instance = null;
        CompositeSingleton.getInstance();
    }

    public synchronized void setCompositeDataMap(Map<String, CompositeBean> mappingDataMap) {
        this.compositeDataMap = mappingDataMap;
    }

    public synchronized Map<String, CompositeBean> getCompositeDataMap() {
        return this.compositeDataMap;
    }
}

