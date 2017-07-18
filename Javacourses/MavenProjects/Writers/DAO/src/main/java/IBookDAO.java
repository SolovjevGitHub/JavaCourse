
import java.util.List;

public interface IBookDAO extends IGenericDAO<Book,Integer> {
    List<Book> getAllBooksByWriterName(String name);
    List<Book> getBookByWriterId(int wtiterId);
    Book getBookInfoByTitle(String title);
}
