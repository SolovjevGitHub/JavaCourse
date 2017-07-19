package handlers;


import bean.Book;
import bean.BookWriter;

import java.util.List;

public class HandlerClass<E> {
    private static StringBuilder stringBuilder;
    public void allEntityToDesctop(List<E> entityList){


        if(entityList.get(0) instanceof BookWriter){
            List<BookWriter> bookWriters=(List<BookWriter>)entityList;

            for(BookWriter bookWriter:bookWriters) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(bookWriter.getId() + ". Name: " + bookWriter.getName() + "; Born: " + bookWriter.getBorn() + "; Died: " + bookWriter.getDied() + "; Website: " + bookWriter.getWebsite() + "; Genre: " + bookWriter.getGenre());
                System.out.println(stringBuilder);
            }
        }

        if(entityList.get(0) instanceof Book){
            List<Book> books=(List<Book>)entityList;
            for(Book book:books){
                stringBuilder=new StringBuilder();
                stringBuilder.append(book.getId()+". Title: "+book.getTitle()+"; Pages: "+book.getPages()+"; Published: "+book.getPublished()+"; Rating: "+book.getRating()+"; Writer_id: "+book.getWriterId());
                System.out.println(stringBuilder);

            }
        }
    }
    public void allEntityNameToDesctop(List<E> entityList){
        if(entityList.get(0) instanceof BookWriter){
            List<BookWriter> bookWriters=(List<BookWriter>)entityList;

            for(BookWriter bookWriter:bookWriters) {
                System.out.println(bookWriter.getName());
            }
        }

        if(entityList.get(0) instanceof Book){
            List<Book> books=(List<Book>)entityList;
            for(Book book:books){
                System.out.println(book.getTitle());

            }
        }
    }

    }

