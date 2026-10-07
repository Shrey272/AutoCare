package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String DEFAULT_HOST = "localhost";
    private static final String DEFAULT_PORT = "3306";
    private static final String DEFAULT_DB = "autocare_db";
    private static final String DEFAULT_USER = "autocare_user";
    private static final String DEFAULT_PASSWORD = "AutoCare@123";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException("MySQL JDBC Driver not found.", ex);
            }
        }
    }

    public static Connection getConnection() throws SQLException {
        String dbUrl = System.getenv("DB_URL");
        if (dbUrl == null || dbUrl.trim().isEmpty()) {
            String host = System.getenv("DB_HOST") != null ? System.getenv("DB_HOST") : DEFAULT_HOST;
            String port = System.getenv("DB_PORT") != null ? System.getenv("DB_PORT") : DEFAULT_PORT;
            String db = System.getenv("DB_NAME") != null ? System.getenv("DB_NAME") : DEFAULT_DB;
            dbUrl = "jdbc:mysql://" + host + ":" + port + "/" + db + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        }

        String user = System.getenv("DB_USER") != null ? System.getenv("DB_USER") : DEFAULT_USER;
        String password = System.getenv("DB_PASSWORD") != null ? System.getenv("DB_PASSWORD") : DEFAULT_PASSWORD;

        return DriverManager.getConnection(dbUrl, user, password);
    }
}