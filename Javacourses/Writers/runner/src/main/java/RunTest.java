import com.mysql.jdbc.Connection;
import org.apache.log4j.BasicConfigurator;

import java.sql.DriverManager;
import java.util.*;

public class RunTest {
    public static void main(String[] args) {
        WriterService writerService=new WriterService();
        List<BookWriter> bookWriters=writerService.getAllWritersName();
        for(int i=0;i<bookWriters.size();i++){
            System.out.println(bookWriters.get(i).getName());
        }



    }
}