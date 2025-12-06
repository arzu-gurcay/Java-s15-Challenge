package model.person;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person{
    private List<String> books = new ArrayList<>();
    public Author( String name) {
        super(name);
    }

    public void newBook(String bookName){
        books.add(bookName);
    }

    public List<String> getBooks(){
        return books;
    }

    public void showBook(){
        System.out.println("Books written by " + getName() + ":");
        for(String title : books){
            System.out.println(" - " + title);
        }
    }

    @Override
    public void whoYouAre() {
        System.out.println("Author: " + getName());
    }
}
