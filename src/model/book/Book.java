package model.book;

import java.time.LocalDate;

public class Book {
    private int id;
    private String author;
    private String name;
    private double price;
    private String status;
    private String edition;
    private LocalDate dateOfPurchase;
    private String owner;

    public Book(int id, String author, String name, double price, LocalDate dateOfPurchase) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.price = price;
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
        System.out.println("ID: " + id + " Author: " + author + " Title: " + name + " Price: " + price + " Status: " + status + " Edition: " + (edition==null ? "-" : edition) + " Date of Purchase: " + dateOfPurchase + " Owner: " + (owner==null ? "-" : owner) );
    }

    public int getId() {
        return id;
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
