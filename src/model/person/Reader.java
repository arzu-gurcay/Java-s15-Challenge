package model.person;

import model.book.Book;

import java.util.ArrayList;
import java.util.List;

public class Reader extends Person{
    private List<Book> books = new ArrayList<>();

    public Reader(String name, List<Book> books) {
        super(name);
        this.books = books;
    }

    public void purchaseBook(Book book){
        books.add(book);
        System.out.println(getName() + " purchased: " + book.getTitle());
    }

    public void borrowBook(Book book){
        book.updateStatus("borrowed");
        book.changeOwner(getName());
        System.out.println(getName() + " borrowed: " + book.getTitle());
    }

    public void returnBook(Book book){
        if(books.remove(book)){
            System.out.println(getName() + " returned: " + book.getTitle());
        }else{
            System.out.println(book.getTitle() + " is not in " + getName() + "'s list.");
        }
    }

    public void showBook(){
        System.out.println(getName() + "'s books: ");
        for(Book b : books){
            System.out.println(" - " + b.getTitle());
        }
    }

    @Override
    public void whoYouAre() {
        System.out.println("Reader: " + getName());;
    }
}
