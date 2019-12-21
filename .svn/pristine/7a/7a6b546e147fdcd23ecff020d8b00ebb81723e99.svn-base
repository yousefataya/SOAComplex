package com.dimensions.mw.utils.connectionManagement;

import com.dimensions.mw.utils.OFMException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConnectionConfigReader {
    public Map<String, String> loadConfig() throws Exception {
        HashMap<String, String> configMap;
        configMap = new HashMap<String, String>();
        Properties prop = new Properties();
        InputStream properties = null;
        try {
            properties = this.getClass().getResourceAsStream("DBConfig.properties");
            if (properties == null) {
                OFMException e = new OFMException(" Cannot load configuration map", null);
                throw e;
            }
            try {
                prop.load(properties);
            }
            catch (Exception ex2) {
                if (!(ex2 instanceof OFMException)) {
                    ex2 = new OFMException(" Cannot load configuration map ", ex2);
                }
                throw ex2;
            }
            Enumeration<?> e = prop.propertyNames();
            while (e.hasMoreElements()) {
                String key = (String)e.nextElement();
                String value = prop.getProperty(key);
                configMap.put(key, value);
            }
        }
        catch (Exception ex3) {
            configMap = null;
            if (!(ex3 instanceof OFMException)) {
                ex3 = new OFMException(" Cannot load configuration map", ex3);
            }
            throw ex3;
        }
        finally {
            if (properties != null) {
                try {
                    properties.close();
                }
                catch (Exception ex4) {
                    if (!(ex4 instanceof OFMException)) {
                        ex4 = new OFMException("Cannot load configuration map", ex4);
                    }
                    throw ex4;
                }
            }
        }
        return configMap;
    }
}

