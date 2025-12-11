package model.book;

import model.person.Author;

import java.time.LocalDate;

public class Journals extends Book{
    public Journals(int bookId, Author author, String name, double price, String edition, LocalDate dateOfPurchase) {
        super(bookId, author, name, price, edition, dateOfPurchase);
    }
}
