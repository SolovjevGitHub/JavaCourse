package impl;


import bean.Book;
import DAOinterfaces.IBookDAO;
import org.apache.log4j.Logger;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements IBookDAO {
    private static final String SELECT_ALL_FROM_BOOK="SELECT * FROM BOOK;";
    private static Logger logger=Logger.getLogger(BookDAOImpl.class);
    private static final String SELECT_ALL_BY_ID="SELECT * FROM BOOK WHERE id=?;";
    private static final String INSERT_INTO_BOOK="INSERT INTO BOOK (title,pages,published,rating,Writer_id)  VALUES (?,?,?,?,?);";
    private static final String DELETE_BOOK_BY_ID="DELETE FROM BOOK WHERE id=?";
    private static final String GET_BOOK_BY_WRITER_ID="SELECT name,title,pages,published,rating FROM WRITER INNER JOIN BOOK ON WRITER.id=BOOK.Writer_id AND BOOK.Writer_id=?;";
    private static final String GET_GENRE_BY_WRITER="SELECT name,genre FROM WRITER WHERE name=?;";
    private static final String GET_BOOK_INFO_BY_TITLE="SELECT * FROM BOOK WHERE title=?;";



    @Override
    public void delete(Integer id, Connection connection) {
        try(PreparedStatement preparedStatement=connection.prepareStatement(DELETE_BOOK_BY_ID)){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            System.out.println("Entity is deleted");
        }
        catch (SQLException ex){
            logger.info("ERROR IN impl.BookDAOImpl delete-method",ex);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void insert(Book entity, Connection connection) {
        try(PreparedStatement preparedStatement=connection.prepareStatement(INSERT_INTO_BOOK)){
            preparedStatement.setNString(1,entity.getTitle());
            preparedStatement.setInt(2,entity.getPages());
            preparedStatement.setNString(3,entity.getPublished());
            preparedStatement.setNString(4,entity.getRating());
            preparedStatement.setInt(5,entity.getWriterId());
            preparedStatement.executeUpdate();
            System.out.println("Entity is added");

        }
        catch(SQLException ex) {
            logger.info("ERROR in insert-method",ex);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Book entity, Connection connection) {

    }

    @Override
    public List<Book> getAllBooksByWriterName(String name, Connection connection) {
        return null;
    }

    @Override
    public List<Book> getAllEntity(Connection connection) {
        List<Book> books=new ArrayList<>();
        try(PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_FROM_BOOK)){
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id=resultSet.getInt("id");
                String title=resultSet.getString("title");
                int pages=resultSet.getInt("pages");
                String published=resultSet.getString("published");
                String rating=resultSet.getString("rating");
                int writerId=resultSet.getInt("Writer_id");
                books.add(new Book(id,title,pages,published,rating,writerId));

            }


        }
        catch (SQLException ex){
           logger.info("ERROR in getAllEntity-method",ex);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Book> getBookByWriterId(int writerId, Connection connection) {
        ArrayList<Book> books=new ArrayList<>();
        try (PreparedStatement preparedStatement=connection.prepareStatement(GET_BOOK_BY_WRITER_ID)){
            preparedStatement.setInt(1,writerId);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                String writerName=resultSet.getString("name");
                String title=resultSet.getString("title");
                int pages=resultSet.getInt("pages");
                String published=resultSet.getString("published");
                String rating=resultSet.getString("rating");
                books.add(new Book(writerName,title,pages,published,rating));

            }




        }
        catch (SQLException ex){
            logger.info("ERROR in getBookByWriterId-method",ex);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return books;
    }

    @Override
    public Book getEntityById(Integer id, Connection connection) {
        return null;
    }

    @Override
    public Book getBookInfoByTitle(String title, Connection connection) {
        Book book=null;


        try(PreparedStatement preparedStatement=connection.prepareStatement(GET_BOOK_INFO_BY_TITLE)){
            preparedStatement.setString(1,title);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id=resultSet.getInt("id");
                String titleBook=resultSet.getString("title");
                int pages=resultSet.getInt("pages");
                String published=resultSet.getString("published");
                String rating=resultSet.getString("rating");
                int writerId=resultSet.getInt("Writer_id");
                book=new Book(id,titleBook,pages,published,rating,writerId);

            }

        }
        catch (SQLException ex){
            logger.info("ERROR in getBookInfoByTitle-method");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return book;
    }
}
