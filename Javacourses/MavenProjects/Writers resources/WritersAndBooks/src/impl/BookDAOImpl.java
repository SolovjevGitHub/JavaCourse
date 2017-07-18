package impl;

import config.ConnectionSingleTone;
import entity.Book;
import entity.BookWriter;
import interfaces.IBookDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements IBookDAO {
    private static final String SELECT_ALL_FROM_BOOK="SELECT * FROM BOOK;";
    private static final String SELECT_ALL_BY_ID="SELECT * FROM BOOK WHERE id=?;";
    private static final String INSERT_INTO_BOOK="INSERT INTO BOOK (title,pages,published,rating,Writer_id)  VALUES (?,?,?,?,?);";
    private static final String DELETE_BOOK_BY_ID="DELETE FROM BOOK WHERE id=?";
    private static final String GET_BOOK_BY_WRITER_ID="SELECT name,title,pages,published,rating FROM WRITER INNER JOIN BOOK ON WRITER.id=BOOK.Writer_id AND BOOK.Writer_id=?;";
    private static final String GET_GENRE_BY_WRITER="SELECT name,genre FROM WRITER WHERE name=?;";
    private static final String GET_BOOK_INFO_BY_TITLE="SELECT * FROM BOOK WHERE title=?;";

    private PreparedStatement preparedStatement;
    private Connection connection= ConnectionSingleTone.getConnection();
    private ResultSet resultSet;

    @Override
    public void delete(Integer id) {
        try{
            preparedStatement=connection.prepareStatement(DELETE_BOOK_BY_ID);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            System.out.println("Запись удалена");
        }
        catch (SQLException ex){
            System.out.println("Ошибка при удалении записи");
            ex.printStackTrace();

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void insert(Book entity) {
        try{
            preparedStatement=connection.prepareStatement(INSERT_INTO_BOOK);
            preparedStatement.setNString(1,entity.getTitle());
            preparedStatement.setInt(2,entity.getPages());
            preparedStatement.setNString(3,entity.getPublished());
            preparedStatement.setNString(4,entity.getRating());
            preparedStatement.setInt(5,entity.getWriterId());
            preparedStatement.executeUpdate();
            System.out.println("Запись в таблицу BOOK добавлена");

        }
        catch(SQLException ex) {
            System.out.println("Ошибка при добавлении новой записи в таблицу BOOK");
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Book entity) {

    }

    @Override
    public List<Book> getAllBooksByWriterName(String name) {
        return null;
    }

    @Override
    public List<Book> getAllEntity() {
        List<Book> books=new ArrayList<>();
        try{
            preparedStatement=connection.prepareStatement(SELECT_ALL_FROM_BOOK);
            resultSet=preparedStatement.executeQuery();
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
            System.out.println("Ошибка выполнения запроса");
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Book> getBookByWriterId(int writerId) {
        ArrayList<Book> books=new ArrayList<>();
        try {
            preparedStatement=connection.prepareStatement(GET_BOOK_BY_WRITER_ID);
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
            System.out.println("Ошибка получения данных");
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return books;
    }

    @Override
    public Book getEntityById(Integer id) {
        return null;
    }

    @Override
    public Book getBookInfoByTitle(String title) {
        Book book=null;


        try{
            preparedStatement=connection.prepareStatement(GET_BOOK_INFO_BY_TITLE);
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
            System.out.println("Ошибка при получении записи");
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return book;
    }
}
