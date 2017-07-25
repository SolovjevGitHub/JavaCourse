package сonnection;


import com.mysql.jdbc.Connection;
import org.apache.log4j.Logger;


import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingletone {

    //сonnection properties
    private static final String CONNECTION_URL = "jdbc:mysql://127.0.0.1:3306/mydb";
    private static final String CONNECTION_LOGIN = "root";
    private static final String CONNECTION_PASSWORD = "root";

    private static Logger logger = Logger.getLogger(ConnectionSingletone.class);

    private static ConnectionSingletone singletone = null;

    private static Connection connection = null;


    private ConnectionSingletone() {
    }


    public static ConnectionSingletone getInstance() {
        if (singletone == null) {
            singletone = new ConnectionSingletone();
        }
        return singletone;
    }

    public com.mysql.jdbc.Connection getConnection() throws SQLException, ClassNotFoundException, NullPointerException {
        if (connection == null) {
            setConnection();
        }
        return connection;
    }

    private static void setConnection() throws SQLException, ClassNotFoundException,NullPointerException {
        if (connection == null) {


            Class.forName("com.mysql.jdbc.Driver");

            connection = (Connection) DriverManager.getConnection(CONNECTION_URL, CONNECTION_LOGIN, CONNECTION_PASSWORD);

            System.out.println("");
            System.out.println("Database connection completed");
            System.out.println("");
            logger.info("New connection to Database");


        }
    }
}