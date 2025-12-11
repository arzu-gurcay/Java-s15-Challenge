package model.book;

import model.person.Author;

import java.time.LocalDate;

public class Magazines extends Book{
    public Magazines(int bookId, String author, String name, double price, String edition, LocalDate dateOfPurchase) {
        super(bookId, author, name, price, edition, dateOfPurchase);
    }
}
