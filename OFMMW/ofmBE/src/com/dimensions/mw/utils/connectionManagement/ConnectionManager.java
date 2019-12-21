package com.dimensions.mw.utils.connectionManagement;

import com.dimensions.mw.utils.OFMException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Map;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import oracle.jdbc.driver.OracleDriver;

public class ConnectionManager {
    private static Connection connection = null;

    private ConnectionManager() {
    }

    public static void main(String[] args) {
        try {
            ConnectionManager.getOFMConnection();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getOFMConnection() throws Exception {
        try {
            DriverManager.registerDriver((Driver)new OracleDriver());
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("jdbc/factOFMDatabase");
            connection = ds.getConnection();
            return connection;
        }
        catch (Exception e) {
            try {
                Connection conn;
                Class.forName("oracle.jdbc.driver.OracleDriver");
                ConnectionConfigReader connectionConfigReader = new ConnectionConfigReader();
                Map<String, String> configMap = connectionConfigReader.loadConfig();
                String serverName = configMap.get("OFM-SERVER-NAME");
                String portNumber = configMap.get("OFM-PORT");
                String sid = configMap.get("OFM-SID");
                String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + "/" + sid;
                String username = configMap.get("OFM-USER-NAME");
                String password = configMap.get("OFM-PASSWORD");
                connection = conn = DriverManager.getConnection(url, username, password);
                return connection;
            }
            catch (Exception ex2) {
                ex2 = new OFMException("OFM RunTime : Unable to Open DB Connection for OFM DB Repository", ex2);
                throw ex2;
            }
        }
    }
}

