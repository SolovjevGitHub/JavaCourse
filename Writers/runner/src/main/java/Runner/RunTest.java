package Runner;

import service.BookService;
import service.WriterService;

public class RunTest {
    public static void main(String[] args) {
        WriterService writerService=new WriterService();
        BookService bookService=new BookService();

       writerService.getAllWritersName();
      //  writerService.getAllWriters();
       //bookService.getAllBook();
       //bookService.getAllBookTitle();




    }
}