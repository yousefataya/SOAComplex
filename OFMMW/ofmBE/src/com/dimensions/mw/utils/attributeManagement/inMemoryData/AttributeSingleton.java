package com.dimensions.mw.utils.attributeManagement.inMemoryData;

import java.util.Map;

public class AttributeSingleton {
    private static volatile AttributeSingleton instance = null;
    private Map<String, AttributeBean> attributeDataMap;
    private AttributeDB attributeDB;

    private AttributeSingleton() {
    }

    public static synchronized AttributeSingleton getInstance() throws Exception {
        if (instance != null)
            return instance;
        synchronized (AttributeSingleton.class) {
            instance = new AttributeSingleton();
            AttributeSingleton.instance.attributeDB = new AttributeDB();
            try {
                final Map<String, AttributeBean> map = AttributeSingleton.instance.attributeDB.loadAttributes();
                AttributeSingleton.instance.attributeDataMap = map;
                System.out.println("******************* attribute validation is Refreshed ******************");
            } catch (Exception e) {
                AttributeSingleton.instance.attributeDataMap = null;
                instance = null;
                throw e;
            }
            return instance;
        }
    }

    public void destroyInstance() throws Exception {
        instance = null;
        AttributeSingleton.getInstance();
    }

    public synchronized void setAttrubuteDataMap(Map<String, AttributeBean> attributeDataMap) {
        this.attributeDataMap = attributeDataMap;
    }

    public Map<String, AttributeBean> getAttributeDataMap() {
        return this.attributeDataMap;
    }
}

