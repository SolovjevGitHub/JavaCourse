package interfaces;

import beans.Book;

import java.sql.Connection;
import java.util.List;

public interface IBookDAO extends IGenericDAO<Book,Integer> {
    List<Book> getAllBooksByWriterName(String name, Connection connection);
    List<Book> getBookByWriterId(int wtiterId, Connection connection);
    Book getBookInfoByTitle(String title, Connection connection);
}
