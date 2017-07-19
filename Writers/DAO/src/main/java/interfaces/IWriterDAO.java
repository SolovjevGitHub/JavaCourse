package interfaces;


import beans.Book;
import beans.BookWriter;
import interfaces.IGenericDAO;

import java.sql.Connection;
import java.util.List;


public interface IWriterDAO extends IGenericDAO<BookWriter,Integer> {
    List<Book> getBookByWriterId(int id, Connection connection);
    BookWriter getWriterInfoByName(String name, Connection connection);
    String getGenreByName(String name, Connection connection);

}
