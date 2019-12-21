package com.dimensions.mw.utils.mappingManagement.inMemoryData;

import java.util.Map;

public class MappingSingleton {
    private static volatile MappingSingleton instance = null;
    private Map<String, MappingBean> mappingDataMap;
    private MappingDB mapDB;

    private MappingSingleton() {
    }
    public static synchronized MappingSingleton getInstance() throws Exception {
        if (instance != null) return instance;
        synchronized (MappingSingleton.class) {
            instance = new MappingSingleton();
            instance.mapDB = new MappingDB();
            try {
                final Map<String, MappingBean> map = instance.mapDB.loadMapping();
                instance.mappingDataMap = map;
                System.out.println("******************* MappingSingleton is Refreshed ******************");
            }
            catch (Exception e) {
                instance.mappingDataMap = null;
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

    public synchronized void setMappingDataMap(Map<String, MappingBean> mappingDataMap) {
        this.mappingDataMap = mappingDataMap;
    }

    public synchronized Map<String, MappingBean> getMappingDataMap() {
        return this.mappingDataMap;
    }
}

