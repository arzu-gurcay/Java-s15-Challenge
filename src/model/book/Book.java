package model.book;

import model.person.Author;

import java.time.LocalDate;

public class Book {
    private int bookId;
    private String author;
    private String name;
    private double price;
    private String status;
    private String edition;
    private LocalDate dateOfPurchase;
    private String owner;

    public Book(int bookId, String author, String name, double price, String edition, LocalDate dateOfPurchase) {
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
    public String getAuthor() {
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

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }
}
