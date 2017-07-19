package Service;
import Connection.ConnectionSingletone;
import bean.BookWriter;
import com.mysql.jdbc.Connection;
import handlers.HandlerClass;
import impl.BookWriterDAOImpl;
import org.apache.log4j.Logger;


import java.sql.SQLException;
import java.util.List;


/**
 * Created by USER on 18.07.2017.
 */
public class WriterService {
    private static BookWriterDAOImpl bookWriterDAO=new BookWriterDAOImpl();
    private static Logger logger=Logger.getLogger(WriterService.class);
    private static HandlerClass handler=new HandlerClass();



    public  void getAllWriters(){
        Connection connection=null;
        List<BookWriter> bookWriters=null;
        try{
            connection=ConnectionSingletone.getInstance().getConnection();
            connection.setAutoCommit(false);
            bookWriters=bookWriterDAO.getAllEntity(connection);
            connection.commit();
        }
        catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                logger.info("Failed to complete rollback");
                ex.printStackTrace();

            }
            logger.info("Transaction is crushed.");
        }
        handler.allEntityToDesctop(bookWriters);


    }

    public void getAllWritersName(){
        Connection connection=null;
        List<BookWriter> bookWriters=null;
        try{
            connection=ConnectionSingletone.getInstance().getConnection();
            connection.setAutoCommit(false);
            bookWriters=bookWriterDAO.getAllEntity(connection);
            connection.commit();
        }
        catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                logger.info("Failed to complete rollback");
                ex.printStackTrace();

            }
            logger.info("Transaction is crushed.");

        }
        handler.allEntityNameToDesctop(bookWriters);


    }



}
