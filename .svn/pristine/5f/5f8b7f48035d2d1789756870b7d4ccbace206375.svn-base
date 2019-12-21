package com.dimensions.mw.utils.sqlManagement.inMemoryData;

import com.dimensions.mw.utils.OFMException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class QueriesReader {
    public Map<String, String> loadQueries() throws Exception {
        HashMap<String, String> queriesMap;
        queriesMap = new HashMap<String, String>();
        Properties prop = new Properties();
        InputStream properties = null;
        try {
            properties = this.getClass().getResourceAsStream("queries.properties");
            if (properties == null) {
                OFMException e = new OFMException("OFM RunTime : Unable to Load OFM Queries, getResourceAsStream", null);
                throw e;
            }
            prop.load(properties);
            Enumeration<?> e = prop.propertyNames();
            while (e.hasMoreElements()) {
                String key = (String)e.nextElement();
                String value = prop.getProperty(key);
                queriesMap.put(key, value);
            }
        }
        catch (Exception ex2) {
            queriesMap = null;
            if (!(ex2 instanceof OFMException)) {
                ex2 = new OFMException("OFM RunTime : Unable to Load OFM Queries", ex2);
            }
            throw ex2;
        }
        finally {
            if (properties != null) {
                properties.close();
            }
        }
        return Collections.unmodifiableMap(queriesMap);
    }
}

