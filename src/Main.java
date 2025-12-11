import model.book.Book;
import model.library.Librarian;
import model.library.Library;
import model.member.MemberRecord;
import model.person.Author;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        List<MemberRecord> members = new ArrayList<>();
        Librarian librarian = new Librarian("Arzu",1234);
        Book book1 = new Book(1,"Sabahattin Ali","Kuyucaklı Yusuf",55,"1.Baskı",LocalDate.parse("2025-12-12"));
        Book book2 = new Book(2,"Orhan Pamuk","Masumiyet Müzesi",80,"3.Baskı",LocalDate.now());
        library.newBook(book1);
        library.newBook(book2);
        MemberRecord member1 = new MemberRecord(1,"Sezer","Student");
        members.add(member1);

        while (true){
            System.out.println("----LIBRARY MENU----");
            System.out.println("1-Add New Book");
            System.out.println("2-Search Book (id / name / author");
            System.out.println("3-Update Book Information");
            System.out.println("4-Delete Book");
            System.out.println("5-Add New Member");
            System.out.println("6-Lend Book to Member");
            System.out.println("7-Take Book Back from Member");
            System.out.println("8-List Books by Author");
            System.out.println("0-Exit");
            System.out.println("Your Choice: ");

            String secim = scanner.nextLine();
            if(secim.equals("0")){
                System.out.println("Program terminated!");
                break;
            }
            if(secim.equals("1")){
                System.out.println("Book ID: ");
                int bookId= Integer.parseInt(scanner.nextLine());

                System.out.println("Author Name: ");
                String author=scanner.nextLine();

                System.out.println("Book Name: ");
                String name=scanner.nextLine();

                System.out.println("Price: ");
                double price = Double.parseDouble(scanner.nextLine());

                System.out.println("Edition: ");
                String edition = scanner.nextLine();

                System.out.println("Date of Purchase(YYYY-MM-DD): ");
                String dateStr=scanner.nextLine();
                LocalDate dateOfPurchase =LocalDate.parse(dateStr);

                Book book = new Book(bookId,author,name,price,edition,dateOfPurchase);
                book.setEdition(edition);
                book.setDateOfPurchase(dateOfPurchase);

                library.newBook(book);
                System.out.println("Book is added to the library.");
                continue;


            }
            if(secim.equals("2")){
                System.out.println("1-Search by ID");
                System.out.println("2-Search by Name");
                System.out.println("3-Search by Author");
                System.out.println("Seçim: ");
                String ikincisecim = scanner.nextLine();

                if(ikincisecim.equals("1")){
                    System.out.println("ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    Book findBook = null;
                    for(Book b : library.getBooks()){
                        if(id == b.getBookId()){
                            findBook = b;
                            break;
                        }
                    }
                    if(findBook!=null){
                        findBook.display();
                    }else{
                        System.out.println("Book is not found.");
                    }
                } else if (ikincisecim.equals("2")) {
                    System.out.println("Book Name: ");
                    String name = scanner.nextLine();
                    boolean found = false;
                    for(Book b : library.getBooks()){
                        if(b.getTitle().toLowerCase().contains(name.toLowerCase())){
                            b.display();
                            found = true;
                        }
                    }
                    if(!found){
                        System.out.println("Book name is not found!");
                    }
                } else if (ikincisecim.equals("3")) {
                    System.out.println("Author Name: ");
                    String authorName = scanner.nextLine();
                    boolean found = false;
                    for(Book b: library.getBooks()){
                        if(b.getAuthor().toLowerCase().contains(authorName.toLowerCase())){
                            b.display();
                            found = true;
                        }
                    }
                    if(!found){
                        System.out.println("Author name is not found!");
                    }
                }
                continue;
            }
                if(secim.equals("3")){
                    System.out.println("Book ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    Book foundBook = null;

                    for(Book b : library.getBooks()){
                        if(b.getBookId() == id){
                            foundBook = b ;
                            break;
                        }
                    }
                    if(foundBook == null){
                        System.out.println("Book is not found!");
                    }else {
                        System.out.println("New Book Name: ");
                        String newName = scanner.nextLine();
                        foundBook.setName(newName);

                        System.out.println("New Author Name: ");
                        String newAuthorName = scanner.nextLine();
                        foundBook.setAuthor(newAuthorName);

                        System.out.println("New Price: ");
                        String priceInput= scanner.nextLine();
                        foundBook.setPrice(Double.parseDouble(priceInput));

                        System.out.println("New Edition: ");
                        String newEdition = scanner.nextLine();
                        foundBook.setEdition(newEdition);

                        System.out.println("Book updated successfully");
                        foundBook.display();
                    }
                continue;
                }
          if(secim.equals("4")){
              System.out.println("Book ID: ");
              int id = Integer.parseInt(scanner.nextLine());

              Book toRemove = null;
              for(Book b : library.getBooks()){
                  if(b.getBookId() == id){
                      toRemove=b;
                      break;
                  }
              }
              if(toRemove != null){
                  library.getBooks().remove(toRemove);
                  System.out.println("Book deleted: " + toRemove.getTitle());
              }else {
                  System.out.println("Book is not found!");
              }
              continue;
          }
             if(secim.equals("5")) {
                 System.out.println("Member ID: ");
                 int mid = Integer.parseInt(scanner.nextLine());

                 System.out.println("Member Name: ");
                 String mname = scanner.nextLine();

                 System.out.println("Member Type (Student/Faculty): ");
                 String mtype = scanner.nextLine();

                 MemberRecord member = new MemberRecord(mid,mname,mtype);
                 members.add(member);

                 System.out.println("New member added: " + member.getMember());
                 continue;
             }
           if(secim.equals("6")){
               System.out.println("Member ID: ");
               int id = Integer.parseInt(scanner.nextLine());
               MemberRecord member = null;
               for(MemberRecord m : members){
                   if(m.getMemberId()==id){
                       member = m ;
                       break;
                   }
               }
               if(member==null){
                   System.out.println("Member is not found!");
                   continue;
               }
               if(member.getNoBooksIssued() >= member.getMaxBookLimit()){
                   System.out.println("Member reached book limit(5).Cannot borrow more.");
                   continue;
               }

               System.out.println("Book ID: ");
               int bookId=Integer.parseInt(scanner.nextLine());

               Book book = null;
               for(Book b: library.getBooks()){
                   if(b.getBookId() == bookId){
                       book=b;
                       break;
                   }
               }
               if(book==null){
                   System.out.println("Book is not found!");
                   continue;
               }
               if(book.getStatus().equalsIgnoreCase("borrowed")){
                   System.out.println("This book is already borrowed by someone else.");
                   continue;
               }
               book.updateStatus("borrowed");
               book.changeOwner(member.getName());
               member.incBookIssued();
               System.out.println("Book borrowed successfully!");
               System.out.println("Borrowed by: "+ member.getMember());
               book.display();
           }
           if(secim.equals("7")){
               System.out.println("Member ID: ");
               int id = Integer.parseInt(scanner.nextLine());
               MemberRecord member = null;
               for(MemberRecord m : members){
                   if(m.getMemberId()==id){
                       member = m ;
                       break;
                   }
               }
               if(member==null){
                   System.out.println("Member is not found!");
                   continue;
               }
               System.out.println("Book ID: ");
               int bookId=Integer.parseInt(scanner.nextLine());

               Book book = null;
               for(Book b: library.getBooks()){
                   if(b.getBookId() == bookId){
                       book=b;
                       break;
                   }
               }
               if(book==null){
                   System.out.println("Book is not found!");
                   continue;
               }
               if(book.getOwner()==null || !book.getOwner().equals(member.getName())){
                   System.out.println("This book is not registered to this member.");
                   continue;
               }
               System.out.println("Late days (0 if none): ");
               int lateDays = Integer.parseInt(scanner.nextLine());

               double fine = 0 ;
               if(lateDays>0){
                   fine=lateDays*5;
                   System.out.println("Late fine: " + fine + " TL");
               }
               book.updateStatus("available");
               book.changeOwner(null);
               member.decBookIssued();

               System.out.println("Book returned successfully!");
               book.display();
           }

           if(secim.equals("8")){
               System.out.println("Author Name: ");
               String authorName = scanner.nextLine();

               boolean found = false;
               for(Book b : library.getBooks()){
                   if(b.getAuthor().equalsIgnoreCase(authorName)){
                       b.display();
                       found=true;
                   }
               }
               if(!found){
                   System.out.println("No books found for this author.");
               }
               continue;
           }
        }
    }
}