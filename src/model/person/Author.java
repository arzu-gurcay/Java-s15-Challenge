package model.person;

import model.book.Book;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person{
    private List<Book> books = new ArrayList<>();
    public Author( String name) {
        super(name);
    }

    public void newBook(Book book){
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void showBook(){
        System.out.println("Books written by " + getName() + ":");
        if(books.isEmpty()){
            System.out.println("No book");
        }else{
            for(Book b : books){
                b.display();
            }

        }

    }

    @Override
    public void whoYouAre() {
        System.out.println("Author: " + getName());
    }
}
