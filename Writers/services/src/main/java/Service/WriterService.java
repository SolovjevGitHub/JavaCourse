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

    private static List<BookWriter> getAllEntity(){
        Connection connection=null;
        List<BookWriter> bookWriters=null;
        try{
            connection=ConnectionSingletone.getInstance().getConnection();
            connection.setAutoCommit(false);
            bookWriters=bookWriterDAO.getAllEntity(connection);
            connection.commit();
        }catch (SQLException ex) {
            try {
                logger.info("Transaction is crushed.");
                System.out.println("Transaction is crushed.");
                connection.rollback();
            } catch (SQLException e) {
                logger.info(e);
                System.out.println("SQLException"+" in "+BookService.class);
            }
            catch (NullPointerException e){
                logger.info(e);
                System.out.println("NullPointerException"+" in "+BookService.class);
            }

        } catch (ClassNotFoundException e) {
            logger.info(e);
            System.out.println("ClassNotFoundException"+" in "+BookService.class);
        }
        return bookWriters;

    }



    public  void getAllWriters() throws NullPointerException{
       List<BookWriter> bookWriters=getAllEntity();

        if(bookWriters!=null) {
            handler.allEntityToDesctop(bookWriters);
        }
        else {
            logger.info("bookWriters is null");
            throw new NullPointerException();
        }

    }

    public void getAllWritersName() throws NullPointerException{
        List<BookWriter> bookWriters=getAllEntity();
        if(bookWriters!=null){
        handler.allEntityNameToDesctop(bookWriters);
        }
        else {
            logger.info("bookWriters is null");
            throw new NullPointerException();
        }


    }



}
