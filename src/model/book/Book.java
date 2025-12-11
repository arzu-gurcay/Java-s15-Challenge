package model.book;

import model.person.Author;

import java.time.LocalDate;

public class Book {
    private int bookId;
    private Author author;
    private String name;
    private double price;
    private String status;
    private String edition;
    private LocalDate dateOfPurchase;
    private String owner;

    public Book(int bookId, Author author, String name, double price, String edition, LocalDate dateOfPurchase) {
        this.bookId = bookId;
        this.author = author;
        this.name = name;
        this.price = price;
        this.edition=edition;
        this.status= "available";
        this.dateOfPurchase = dateOfPurchase;
    }

    public String getTitle(){
        return name;
    }
    public Author getAuthor() {
        return author;
    }

    public void changeOwner(String newOwner){
        this.owner=newOwner;
    }

    public String getOwner(){
        return owner;
    }
    public void updateStatus(String newStatus){
        this.status=newStatus;
    }

    public void display(){
        System.out.println("ID: " + bookId + " Author: " + author + " Title: " + name + " Price: " + price + " Status: " + status + " Edition: " + edition + " Date of Purchase: " + dateOfPurchase + " Owner: " + owner );
    }

    public int getBookId() {
        return bookId;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }
}
