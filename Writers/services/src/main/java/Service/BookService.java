package Service;
import Connection.ConnectionSingletone;
import bean.Book;
import bean.BookWriter;
import com.mysql.jdbc.Connection;
import handlers.HandlerClass;
import impl.BookDAOImpl;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;


public class BookService {
    private static BookDAOImpl bookWriterDAO=new BookDAOImpl();
    private static Logger logger=Logger.getLogger(WriterService.class);
    private static HandlerClass handler=new HandlerClass();



    public  void getAllBook(){
        Connection connection=null;
        List<Book> books=null;
        try{
            connection=ConnectionSingletone.getInstance().getConnection();
            connection.setAutoCommit(false);
            books=bookWriterDAO.getAllEntity(connection);
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
        handler.allEntityToDesctop(books);


    }

    public void getAllBookTitle(){
        Connection connection=null;
        List<Book> books=null;
        try{
            connection=ConnectionSingletone.getInstance().getConnection();
            connection.setAutoCommit(false);
            books=bookWriterDAO.getAllEntity(connection);
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
        handler.allEntityNameToDesctop(books);


    }

}
