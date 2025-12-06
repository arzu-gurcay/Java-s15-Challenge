package model.library;

import model.book.Book;
import model.person.Reader;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Reader> readers = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }
    public List<Reader> getReaders() {
        return readers;
    }
    public void addReader(Reader reader){
        readers.add(reader);
    }
    public void newBook(Book book){
        books.add(book);
        System.out.println("New book added to library: " + book.getTitle());
    }
    public void lendBook(Reader reader,Book book){
        if(reader == null || book == null){
            System.out.println("Reader or book is null!");
            return;
        }
        if("borrowed".equalsIgnoreCase(book.getStatus())){
            System.out.println("Book is already borrowed: " + book.getTitle());
            return;
        }
        book.updateStatus("borrowed");
        book.changeOwner(reader.getName());
        reader.borrowBook(book);

        System.out.println("Book '" + book.getTitle() + "' lent to " + reader.getName());
    }

    public void takeBackBook(Reader reader,Book book){
        if(reader == null || book == null){
            System.out.println("Reader or book is null!");
            return;
        }
        book.updateStatus("available");
        book.changeOwner(null);
        reader.returnBook(book);
        System.out.println("Book '"+ book.getTitle() + "' returned from " + reader.getName());
    }

    public void showBook(){
        if(books.isEmpty()){
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("------- Library Books ------- ");
        for(Book b : books){
            b.display();
        }
    }
}
