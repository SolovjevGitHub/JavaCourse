

import java.util.List;


public interface IWriterDAO extends IGenericDAO<BookWriter,Integer> {
    List<Book> getBookByWriterId(int id);
    BookWriter getWriterInfoByName(String name);
    String getGenreByName(String name);

}
