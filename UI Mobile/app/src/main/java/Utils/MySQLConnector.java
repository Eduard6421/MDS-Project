package Utils;

import android.os.AsyncTask;

import java.sql.*;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import static Utils.MySQLConnector.DB_DRIVER;
import static Utils.MySQLConnector.DB_URL;
import static Utils.MySQLConnector.MAX_POOL;
import static Utils.MySQLConnector.PASSWORD;
import static Utils.MySQLConnector.USERNAME;
import static Utils.MySQLConnector.connection;
import static Utils.MySQLConnector.properties;

public class MySQLConnector {

    //JDBC Driver + Db URL
    protected static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    protected static final String DB_URL = "jdbc:mysql://89.136.141.23:3306/publicsec?autoReconnect=true&useSSL=false";

    //Database connection user
    protected static final String USERNAME = "javaApp";
    protected static final String PASSWORD = "javaApp";

    //Max pooled connection
    protected static final String MAX_POOL = "250";

    //Db Connection
    protected static Connection connection = null;
    //Object properties
    protected static Properties properties = null;

    public static Connection getConnection() {
        return connection;
    }

    public static void connectToDatabase() {

        SQLConnect sqlConnect = new SQLConnect();
        try {
            sqlConnect.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void disconnectFromDatabase() {

        SQLDisconnect sqlDisconnect = new SQLDisconnect();
        try {
            sqlDisconnect.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static class SQLConnect extends AsyncTask {

        private static Properties getProperties() {
            if (properties == null) {
                properties = new Properties();
                properties.setProperty("user", USERNAME);
                properties.setProperty("password", PASSWORD);
                properties.setProperty("MaxPooledStatements", MAX_POOL);
            }
            return properties;
        }

        public static Connection getConnection() {
            if (connection == null) {
                try {
                    Class.forName(DB_DRIVER);
                    connection = DriverManager.getConnection(DB_URL, getProperties());
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            }
            return connection;
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            return getConnection();
        }
    }

    public static class SQLDisconnect extends AsyncTask {

        public static void disconnect() {
            if (connection != null) {
                try {
                    connection.close();
                    connection = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            disconnect();
            return null;
        }
    }

}
