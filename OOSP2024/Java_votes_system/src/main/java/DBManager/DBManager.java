package DBManager;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBManager {
    private Connection connection;

    public DBManager() {
        try (InputStream is = DBManager.class.getClassLoader().getResourceAsStream("db.properties")) {
            Properties props = new Properties();
            props.load(is);
            establishConnection(props);
        } catch (IOException | SQLException e) {
            throw new RuntimeException("Error while db connection: " + e.getMessage());
        }
    }

    private void establishConnection(Properties props) throws SQLException {
        String driver = props.getProperty("db.driver");
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(props.getProperty("db.url"), props.getProperty("db.user"), props.getProperty("db.password"));
        } catch (ClassNotFoundException e) {
            throw new SQLException("Error loading database driver: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }
}