package Runner;

import Service.BookService;
import Service.WriterService;
import bean.BookWriter;

import java.util.*;

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