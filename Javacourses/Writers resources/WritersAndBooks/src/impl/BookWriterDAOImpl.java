package impl;

import config.ConnectionSingleTone;
import entity.Book;
import entity.BookWriter;
import interfaces.IWriterDAO;

import java.io.Writer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookWriterDAOImpl implements IWriterDAO {

    private static final String SELECT_ALL_FROM_WRITER="SELECT * FROM WRITER;";
    private static final String SELECT_ALL_BY_ID="SELECT * FROM WRITER WHERE id=?;";
    private static final String INSERT_INTO_WRITER="INSERT INTO WRITER (name,born,died,website,genre)  VALUES (?,?,?,?,?);";
    private static final String DELETE_WRITER_BY_ID="DELETE FROM WRITER WHERE id=?";
    private static final String GET_BOOK_BY_WRITER_ID="SELECT name,title,pages,published,rating FROM WRITER INNER JOIN BOOK ON WRITER.id=BOOK.Writer_id AND BOOK.Writer_id=?;";
    private static final String GET_GENRE_BY_WRITER="SELECT name,genre FROM WRITER WHERE name=?;";
    private static final String GET_WRITER_INFO_BY_NAME="SELECT * FROM WRITER WHERE name=?;";

    private PreparedStatement preparedStatement;
    private Connection connection=ConnectionSingleTone.getConnection();
    private ResultSet resultSet;



    @Override
    public void delete(Integer id) {
        try{
            preparedStatement=connection.prepareStatement(DELETE_WRITER_BY_ID);
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
        finally {

        }

    }

    @Override
    public void insert(BookWriter entity) {
        try{
            preparedStatement=connection.prepareStatement(INSERT_INTO_WRITER);
            preparedStatement.setNString(1,entity.getName());
            preparedStatement.setNString(2,entity.getBorn());
            preparedStatement.setNString(3,entity.getDied());
            preparedStatement.setNString(4,entity.getWebsite());
            preparedStatement.setNString(5,entity.getGenre());
            preparedStatement.executeUpdate();
            System.out.println("Запись в таблицу WRITER добавлена");

        }
        catch(SQLException ex) {
            System.out.println("Ошибка при добавлении новой записи в таблицу WRITER");
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void update(BookWriter entity) {

    }

    @Override
    public ArrayList<Book> getBookByWriterId(int id) {

        ArrayList<Book> books=new ArrayList<>();
          try {
            preparedStatement=connection.prepareStatement(GET_BOOK_BY_WRITER_ID);
            preparedStatement.setInt(1,id);
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
    public List<BookWriter> getAllEntity() {
        List<BookWriter> bookWriters=new ArrayList<>();
        try{
            preparedStatement=connection.prepareStatement(SELECT_ALL_FROM_WRITER);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String born=resultSet.getString("born");
                String died=resultSet.getString("died");
                String website=resultSet.getString("website");
                String genre=resultSet.getString("genre");
                bookWriters.add(new BookWriter(id,name,born,died,website,genre));

            }


        }
        catch (SQLException ex){
            System.out.println("Ошибка выполнения запроса");
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return bookWriters;
    }

    @Override
    public BookWriter getEntityById(Integer id) {
        BookWriter bookWriter=null;
        try{
            preparedStatement=connection.prepareStatement(SELECT_ALL_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {

                String name=resultSet.getString("name");
                String born=resultSet.getString("born");
                String died=resultSet.getString("died");
                String website=resultSet.getString("website");
                String genre=resultSet.getString("genre");
                bookWriter=new BookWriter(id,name,born,died,website,genre);

            }

        }
        catch (SQLException ex){
            System.out.println("Ошибка при получении записи");
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return bookWriter;
    }


    @Override
    public BookWriter getWriterInfoByName(String name) {
        BookWriter bookWriter=null;


        try{
            preparedStatement=connection.prepareStatement(GET_WRITER_INFO_BY_NAME);
            preparedStatement.setString(1,name);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id=resultSet.getInt("id");
                String writer=resultSet.getString("name");
                String born=resultSet.getString("born");
                String died=resultSet.getString("died");
                String website=resultSet.getString("website");
                String genre=resultSet.getString("genre");
                bookWriter=new BookWriter(id,writer,born,died,website,genre);

            }

        }
        catch (SQLException ex){
            System.out.println("Ошибка при получении записи");
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return bookWriter;
    }

    @Override
    public String getGenreByName(String name) {
        String genreByName=null;
        try{
            preparedStatement=connection.prepareStatement(GET_GENRE_BY_WRITER);
            preparedStatement.setString(1,name);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {

                String genre=resultSet.getString("genre");
                genreByName=name+": "+genre;


            }
        }
        catch (SQLException ex){
            System.out.println("Ошибка при получении записи");
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return genreByName;
    }
}
