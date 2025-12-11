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
        if(!books.contains(book)){
            books.add(book);
            book.changeOwner(getName());
            book.updateStatus("purchased");
            System.out.println(getName() + " purchased: " + book.getTitle());
        }

    }

    public void borrowBook(Book book){
        if(!books.contains(book)){
            books.add(book);
            book.changeOwner(getName());
            book.updateStatus("borrowed");
            System.out.println(getName() + " borrowed: " + book.getTitle());
        }

    }

    public void returnBook(Book book){
        if(books.remove(book)){
            book.updateStatus("available");
            System.out.println(getName() + " returned: " + book.getTitle());
        }else{
            System.out.println(book.getTitle() + " is not in " + getName() + "'s list.");
        }
    }

    public void showBook(){
        System.out.println(getName() + "'s books: ");
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
        System.out.println("Reader: " + getName());;
    }
}
