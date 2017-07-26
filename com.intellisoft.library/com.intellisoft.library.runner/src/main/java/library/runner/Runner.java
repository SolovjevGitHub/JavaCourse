package library.runner;

import com.intellisoft.library.entity.pojo.Book;
import com.intellisoft.library.entity.pojo.BookWriter;
import com.intellisoft.library.hibernate.util.sessionfactory.SessionFactorySingleTone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by Сирожа и Маха on 27.07.2017.
 */
public class Runner {
    public static void main(String[] args){
        SessionFactory sessionFactory=SessionFactorySingleTone.getSessionFactorySingleTone().getSessionFactory();
        Session session= sessionFactory.openSession();
        Book book = new Book();
        BookWriter bookWriter=new BookWriter();
        session.getTransaction();
        session.beginTransaction();

        bookWriter.setName("qqqqqqqqqqq");
        bookWriter.setBorn("qqqqqqqqqqq");
        bookWriter.setDied("qqqqqqqqqqq");
        bookWriter.setWebsite("qqqqqqqqqq");
        bookWriter.setGenre("qqqqqqqqqqq");
        session.save(bookWriter);

        book.setId(111);
        book.setTitle("asdasdasdasdasdasdasdase-test");
        book.setPages(333);
        book.setPublished("Fuck-factory");
        book.setRating("govno");
        book.setBookWriter(bookWriter);

        session.save(book);
        session.getTransaction().commit();






    }
}
