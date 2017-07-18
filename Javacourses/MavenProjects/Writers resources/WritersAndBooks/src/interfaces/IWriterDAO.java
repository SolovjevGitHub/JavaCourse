package interfaces;

import entity.Book;
import entity.BookWriter;

import java.io.Writer;
import java.util.ArrayList;

public interface IWriterDAO extends IGenericDAO<BookWriter,Integer> {
   ArrayList<Book> getBookByWriterId(int id);
    BookWriter getWriterInfoByName(String name);
    String getGenreByName(String name);

}
