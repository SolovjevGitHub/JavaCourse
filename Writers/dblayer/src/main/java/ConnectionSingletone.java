import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingletone {

    //Connection properties
    private static final String CONNECTION_URL="jdbc:mysql://127.0.0.1:3306/mydb";
    private static final String CONNECTION_LOGIN="root";
    private static final String CONNECTION_PASSWORD="root";

    private static Logger logger = Logger.getLogger(ConnectionSingletone.class.getName());

    private static ConnectionSingletone singletone = new ConnectionSingletone();
    private static Connection connection=null;


    private ConnectionSingletone() {}


    public static ConnectionSingletone getInstance() {
        return singletone;
    }

    public static Connection getConnection() {
        if(connection==null){
            setConnection();
        }
        return connection;
    }

    private static void setConnection() {
        if(connection==null){
            try {
                connection = DriverManager.getConnection(CONNECTION_URL, CONNECTION_LOGIN, CONNECTION_PASSWORD);
                System.out.println("Database connection completed");
            }
            catch (SQLException ex){
                System.out.println("Error connecting to the database");
                System.out.println(ex.getMessage());
                logger.info("SQL-Exception in Singletone class");
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }


        }


    }


}
