import org.apache.log4j.Logger;

import java.io.Writer;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by USER on 18.07.2017.
 */
public class WriterService {
    private static BookWriterDAOImpl bookWriterDAO=new BookWriterDAOImpl();
    private static Logger logger=Logger.getLogger(WriterService.class);
   // private Connection connection=null;

    public List<BookWriter> getAllWritersName(){
        Connection connection=null;
        List<BookWriter> writers=null;

        try {
            connection=ConnectionSingletone.getInstance().getConnection();
            connection.setAutoCommit(false);
            writers= bookWriterDAO.getAllEntity(connection);
            connection.commit();
        }
        catch (SQLException ex){
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            logger.info("Transaction is crushed...So bad....");

        }
        if(writers!=null){

        ArrayList<String> writersName=new ArrayList<String>();
        for(BookWriter bookWriter:writers){
            String name=bookWriter.getName();
            writersName.add(name);
        }}
        else{
            logger.info("List<BookWriters is null");
        }
        return writers;
    }


}
