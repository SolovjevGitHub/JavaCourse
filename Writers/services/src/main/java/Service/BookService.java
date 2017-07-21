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
    private static BookDAOImpl bookDAO = new BookDAOImpl();
    private static Logger logger = Logger.getLogger(WriterService.class);
    private static HandlerClass handler = new HandlerClass();

    private static List<Book> getAllEntity() {
        Connection connection = null;
        List<Book> books = null;
        try {
            connection = ConnectionSingletone.getInstance().getConnection();
            connection.setAutoCommit(false);
            books = bookDAO.getAllEntity(connection);
            connection.commit();
        } catch (SQLException ex) {
            try{
                logger.info("Transaction is crushed.");
                System.out.println("Transaction is crushed.");
                connection.rollback();
            }
            catch (SQLException e){
               logger.info(e);
                System.out.println("SQLException"+" in "+BookService.class);
                }
            catch (NullPointerException e){
                logger.info(e);
                System.out.println("NullPointerException"+" in "+BookService.class);
            }
        }
        catch (ClassNotFoundException ex){
           logger.info(ex);
            System.out.println("ClassNotFoundException"+" in "+BookService.class);
        }

        return books;
    }


    public void getAllBook()  {
        List<Book> books = getAllEntity();

        if (books != null) {
            handler.allEntityToDesctop(books);
        } else {
            logger.info("NullPointerException"+" in "+"+BookService.class)");
            throw new NullPointerException();


        }


    }

    public void getAllBookTitle() {
        List<Book> books=getAllEntity();

        if (books != null) {
            handler.allEntityNameToDesctop(books);
        } else {
            logger.info("NullPointerException"+" in "+"+BookService.class)");
            throw new NullPointerException();

        }


    }

}
