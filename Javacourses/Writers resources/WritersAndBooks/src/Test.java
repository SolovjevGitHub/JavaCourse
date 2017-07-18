import config.ConnectionSingleTone;
import entity.Book;
import entity.BookWriter;
import impl.BookDAOImpl;
import impl.BookWriterDAOImpl;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args){


        //****************яюью, лерндш пеюкхгнбюмш ме бяе, р.й. сфе опнярн ме сяоебюк...


        BookWriterDAOImpl impl=new BookWriterDAOImpl();
        BookDAOImpl bookDAO=new BookDAOImpl();
        StringBuilder stringBuilder=new StringBuilder();

             /**бшбнд мю щйпюм яндепфюмхъ рюакхжш WRITER*/

     /* List<BookWriter> bookWriters=impl.getAllEntity();

        for(BookWriter bookWriter:bookWriters){
            stringBuilder=new StringBuilder();
            stringBuilder.append(bookWriter.getId()+". Name: "+bookWriter.getName()+"; Born: "+bookWriter.getBorn()+"; Died: "+bookWriter.getDied()+"; Website: "+bookWriter.getWebsite()+"; Genre: "+bookWriter.getGenre());
            System.out.println(stringBuilder);

        }*/

              /**днаюбкемхе мнбни гюохях б рюакхжс WRITER*/

      // impl.insert(new BookWriter("asdasd","aaa","sss","sddd","asd"));

              /**сдюкемхе гюохях хг рюакхжш WRITER*/
      //  impl.delete(10);

              /**онксвемхе гюохях хг рюакхжш WRITER он ID*/
       /* BookWriter bookWriter=impl.getEntityById(2);
        stringBuilder.append(bookWriter.getId()+". Name: "+bookWriter.getName()+"; Born: "+bookWriter.getBorn()+"; Died: "+bookWriter.getDied()+"; Website: "+bookWriter.getWebsite()+"; Genre: "+bookWriter.getGenre());
        System.out.println(stringBuilder);*/
             /**онксвемхе яохяйю ймхц юбрнпю он ID*/
           /* ArrayList<Book> books=impl.getBookByWriterId(1);
              for(int i=0;i<books.size();i++){

            stringBuilder.append(books.get(i).getWriter()+"; "+books.get(i).getTitle()+"; "+books.get(i).getPages()+"; "+books.get(i).getPublished()+"; "+books.get(i).getRating());
            System.out.println(stringBuilder);
                  stringBuilder=new StringBuilder();

        }*/
            /**онксвемхе хмтнплюжхх на юбрнпе он хлемх*/
            /*BookWriter bookWriter=impl.getWriterInfoByName("Harper Lee");
        stringBuilder.append(bookWriter.getId()+"; "+bookWriter.getName()+"; "+bookWriter.getBorn()+"; "+bookWriter.getDied()+"; "+bookWriter.getWebsite()+"; "+bookWriter.getGenre());
        System.out.println(stringBuilder);*/

            /**онксвемхе фюмпю он хлемх охяюрекъ*/
        /*System.out.println(impl.getGenreByName("Mark Twain"));*/

            /**бярюбйю мнбни гюохях б рюакхжс BOOK*/
           /* bookDAO.insert(new Book("Life on the Mississippi",384,"November 2001 by Signet Classics","3.89",1));*/

            /**сдюкемхе гюохях хг рюакхжш BOOK*/
            /*bookDAO.delete(12);*/

            /**онксвемхе бяеу гюохяеи хг рюакхжш BOOK*/

        /*List<Book> books=bookDAO.getAllEntity();

        for(Book book:books){
            stringBuilder=new StringBuilder();
            stringBuilder.append(book.getId()+". Title: "+book.getTitle()+"; Pages: "+book.getPages()+"; Published: "+book.getPublished()+"; Rating: "+book.getRating()+"; Writer_id: "+book.getWriterId());
            System.out.println(stringBuilder);

        }*/

            /**онксвемхе гюохях он мюгбюмхч ймхцх*/
        /*Book book=bookDAO.getBookInfoByTitle("To Kill a Mockingbird ");
        stringBuilder.append(book.getId()+", "+book.getTitle()+", "+book.getPages()+", "+book.getPublished()+", "+book.getRating()+", "+book.getWriterId());
        System.out.println(stringBuilder);*/

            /**онксвемхе яохяйю ймхц он ID  юбрнпю*/
        ArrayList<Book> books=impl.getBookByWriterId(2);
        for(int i=0;i<books.size();i++){

            stringBuilder.append(books.get(i).getWriter()+"; "+books.get(i).getTitle()+"; "+books.get(i).getPages()+"; "+books.get(i).getPublished()+"; "+books.get(i).getRating());
            System.out.println(stringBuilder);
            stringBuilder=new StringBuilder();

        }



ConnectionSingleTone.closeConnection();
    }
}
