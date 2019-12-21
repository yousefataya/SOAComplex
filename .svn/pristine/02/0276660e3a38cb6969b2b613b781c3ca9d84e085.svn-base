package com.dimensions.mw.utils.sqlManagement.inMemoryData;

import java.util.HashMap;
import java.util.Map;

public class QuerySingleton {
    private static volatile QuerySingleton instance = null;
    private Map<String, String> queryMap = new HashMap<String, String>();
    private QueriesReader queries;

    private QuerySingleton() {
    }

    public static synchronized QuerySingleton getInstance() throws Exception {
        if (instance != null) return instance;
        synchronized (QuerySingleton.class) {
            instance = new QuerySingleton();
            QuerySingleton.instance.queryMap = new HashMap<String, String>();
            QuerySingleton.instance.queries = new QueriesReader();
            try {
                Map<String, String> map = QuerySingleton.instance.queries.loadQueries();
                QuerySingleton.instance.queryMap = map;
                System.out.println("******************* QuerySingleton is Refreshed ******************");
            }
            catch (Exception ex) {
                QuerySingleton.instance.queryMap = null;
                instance = null;
                throw ex;
            }
            return instance;
        }
    }

    public void destroyInstance() throws Exception {
        instance = null;
        QuerySingleton.getInstance();
    }

    public synchronized void setQueryMap(Map<String, String> queryMap) {
        this.queryMap = queryMap;
    }

    public synchronized Map<String, String> getQueryMap() {
        return this.queryMap;
    }
}

