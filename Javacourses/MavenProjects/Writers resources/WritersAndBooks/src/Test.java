import config.ConnectionSingleTone;
import entity.Book;
import entity.BookWriter;
import impl.BookDAOImpl;
import impl.BookWriterDAOImpl;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args){


        //****************����, ������ ����������� �� ���, �.�. ��� ������ �� �������...


        BookWriterDAOImpl impl=new BookWriterDAOImpl();
        BookDAOImpl bookDAO=new BookDAOImpl();
        StringBuilder stringBuilder=new StringBuilder();

             /**����� �� ����� ���������� ������� WRITER*/

     /* List<BookWriter> bookWriters=impl.getAllEntity();

        for(BookWriter bookWriter:bookWriters){
            stringBuilder=new StringBuilder();
            stringBuilder.append(bookWriter.getId()+". Name: "+bookWriter.getName()+"; Born: "+bookWriter.getBorn()+"; Died: "+bookWriter.getDied()+"; Website: "+bookWriter.getWebsite()+"; Genre: "+bookWriter.getGenre());
            System.out.println(stringBuilder);

        }*/

              /**���������� ����� ������ � ������� WRITER*/

      // impl.insert(new BookWriter("asdasd","aaa","sss","sddd","asd"));

              /**�������� ������ �� ������� WRITER*/
      //  impl.delete(10);

              /**��������� ������ �� ������� WRITER �� ID*/
       /* BookWriter bookWriter=impl.getEntityById(2);
        stringBuilder.append(bookWriter.getId()+". Name: "+bookWriter.getName()+"; Born: "+bookWriter.getBorn()+"; Died: "+bookWriter.getDied()+"; Website: "+bookWriter.getWebsite()+"; Genre: "+bookWriter.getGenre());
        System.out.println(stringBuilder);*/
             /**��������� ������ ���� ������ �� ID*/
           /* ArrayList<Book> books=impl.getBookByWriterId(1);
              for(int i=0;i<books.size();i++){

            stringBuilder.append(books.get(i).getWriter()+"; "+books.get(i).getTitle()+"; "+books.get(i).getPages()+"; "+books.get(i).getPublished()+"; "+books.get(i).getRating());
            System.out.println(stringBuilder);
                  stringBuilder=new StringBuilder();

        }*/
            /**��������� ���������� �� ������ �� �����*/
            /*BookWriter bookWriter=impl.getWriterInfoByName("Harper Lee");
        stringBuilder.append(bookWriter.getId()+"; "+bookWriter.getName()+"; "+bookWriter.getBorn()+"; "+bookWriter.getDied()+"; "+bookWriter.getWebsite()+"; "+bookWriter.getGenre());
        System.out.println(stringBuilder);*/

            /**��������� ����� �� ����� ��������*/
        /*System.out.println(impl.getGenreByName("Mark Twain"));*/

            /**������� ����� ������ � ������� BOOK*/
           /* bookDAO.insert(new Book("Life on the Mississippi",384,"November 2001 by Signet Classics","3.89",1));*/

            /**�������� ������ �� ������� BOOK*/
            /*bookDAO.delete(12);*/

            /**��������� ���� ������� �� ������� BOOK*/

        /*List<Book> books=bookDAO.getAllEntity();

        for(Book book:books){
            stringBuilder=new StringBuilder();
            stringBuilder.append(book.getId()+". Title: "+book.getTitle()+"; Pages: "+book.getPages()+"; Published: "+book.getPublished()+"; Rating: "+book.getRating()+"; Writer_id: "+book.getWriterId());
            System.out.println(stringBuilder);

        }*/

            /**��������� ������ �� �������� �����*/
        /*Book book=bookDAO.getBookInfoByTitle("To Kill a Mockingbird ");
        stringBuilder.append(book.getId()+", "+book.getTitle()+", "+book.getPages()+", "+book.getPublished()+", "+book.getRating()+", "+book.getWriterId());
        System.out.println(stringBuilder);*/

            /**��������� ������ ���� �� ID  ������*/
        ArrayList<Book> books=impl.getBookByWriterId(2);
        for(int i=0;i<books.size();i++){

            stringBuilder.append(books.get(i).getWriter()+"; "+books.get(i).getTitle()+"; "+books.get(i).getPages()+"; "+books.get(i).getPublished()+"; "+books.get(i).getRating());
            System.out.println(stringBuilder);
            stringBuilder=new StringBuilder();

        }



ConnectionSingleTone.closeConnection();
    }
}
