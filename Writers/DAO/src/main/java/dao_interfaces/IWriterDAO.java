package dao_interfaces;


import bean.Book;
import bean.BookWriter;

import java.sql.Connection;
import java.util.List;


public interface IWriterDAO extends IGenericDAO<BookWriter,Integer> {
    List<Book> getBookByWriterId(int id, Connection connection);
    BookWriter getWriterInfoByName(String name, Connection connection);
    String getGenreByName(String name, Connection connection);

}
