package LibraryManager;

import Files.FilesManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        int choice;
        Scanner scanner = new Scanner(System.in);
        FilesManager filesManager = new FilesManager();
        Collection collection = filesManager.loadCollection();
        while (true){
            System.out.println("Enter choice:");
            System.out.println("0. Exit");
            System.out.println("1. Register book");
            System.out.println("2. Remove book");
            System.out.println("3. Borrow book");
            System.out.println("4. Return book");
            System.out.println("5. View book");
            System.out.println("6. Register reader");
            System.out.println("7. Activate reader");
            System.out.println("8. Deactivate reader");
            System.out.println("9. View reader");
            System.out.println("10. Pay fine");
            System.out.println("11. View collection");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    filesManager.saveCollection(collection);
                    return;
                case 1:
                    String title, author, category;
                    int totPages;
                    System.out.println("Enter title: ");
                    title = scanner.nextLine();
                    System.out.println("Enther author: ");
                    author = scanner.nextLine();
                    System.out.println("Enter category: ");
                    category = scanner.nextLine();
                    System.out.println("Enter the total amount of pages: ");
                    totPages = scanner.nextInt();
                    scanner.nextLine();
                    collection.addBook(new Book(title, totPages, author, category));
                    System.out.println("Book added successfully!");
                    break;
            }
        }
    }
}
