import com.mysql.jdbc.Connection;
import org.apache.log4j.BasicConfigurator;

import java.util.*;

public class RunTest {
    public static void main(String[] args) {


        BasicConfigurator.configure();
        StringBuilder stringBuilder;
        BookDAOImpl bookDAO = new BookDAOImpl();


        List<Book> books = bookDAO.getAllEntity();

        for (Book book : books) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(book.getId() + ". Title: " + book.getTitle() + " || Pages: " + book.getPages() + " || Published: " + book.getPublished() + " || Rating: " + book.getRating() + " || Writer_id: " + book.getWriterId());
            System.out.println(stringBuilder);
        }
    }
}