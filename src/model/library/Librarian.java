package model.library;

import model.book.Book;
import model.member.MemberRecord;

public class Librarian {
    private String name;
    private int password;


    public Librarian(String name, int password) {
        this.name = name;
        this.password = password;
    }

    public Book searchBook(Library library , int bookId){
        for(Book b : library.getBooks()){
            if(b.getBookId() == bookId){
                System.out.println("Book found : " + b.getTitle());
                return b;
            }
        }
        System.out.println("Book is not found");
        return null;
    }

    public boolean verifyMember(MemberRecord member){
        System.out.println("Member verified: " + member.getMember());
        return true;
    }

    public void issueBook(MemberRecord member, Book book){
        if(book.getStatus().equalsIgnoreCase("borrowed")){
            System.out.println("Book is already borrowed");
            return;
        }
        book.updateStatus("borrowed");
        book.changeOwner(member.getName());
        member.incBookIssued();
        System.out.println("Book issued: " + book.getTitle()+ " to member: " + member.getName());
    }

    public double calculateFine(int lateDays){
        double dailyRate = 5.0;
        return lateDays * dailyRate ;
    }

    public void createBill(){
        System.out.println("Bill created.");
    }

    public void returnBook(MemberRecord member,Book book){
        book.updateStatus("available");
        book.changeOwner(null);
        member.decBookIssued();
        System.out.println("Book returned: " + book.getTitle());
    }

    public String getName() {
        return name;
    }

    public int getPassword() {
        return password;
    }

}
