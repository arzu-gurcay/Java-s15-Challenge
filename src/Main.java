import model.book.Book;
import model.library.Librarian;
import model.library.Library;
import model.member.MemberRecord;
import model.person.Author;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        List<MemberRecord> members = new ArrayList<>();
        Librarian librarian = new Librarian("Arzu",1234);

        while (true){
            System.out.println("----KÜTÜPHANE MENÜ----");
            System.out.println("1-Yeni Kitap Ekle");
            System.out.println("2-Kitap Ara (id / isim / yazar");
            System.out.println("3-Kitap Bilgilerini Güncelle");
            System.out.println("4-Kitap Sil");
            System.out.println("5-Yeni Üye Ekle");
            System.out.println("6-Üyeye Kitap Ödünç Ver");
            System.out.println("7-Üyeden Kitap İade Al");
            System.out.println("0-Çıkış");
            System.out.println("Seçiminiz: ");

            String secim = scanner.nextLine();
            if(secim.equals("0")){
                System.out.println("Program sonlandırıldı!");
                break;
            }
            if(secim.equals("1")){
                System.out.println("Book ID: ");
                int bookId= Integer.parseInt(scanner.nextLine());

                System.out.println("Book Name: ");
                String name=scanner.nextLine();

                System.out.println("Author Name: ");
                String author=scanner.nextLine();

                System.out.println("Price: ");
                double price = Double.parseDouble(scanner.nextLine());



            }
        }
    }
}