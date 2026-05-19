package LibraryManager;

import Files.FilesManager;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        int choice;
        Scanner scanner = new Scanner(System.in);
        FilesManager filesManager = new FilesManager();
        Collection collection = filesManager.loadCollection();
        List<Reader> readers = filesManager.loadReaders();
        Librarian librarian = new Librarian();
        while (true){
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
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    return;
                case 1:
                    registerBook(collection, filesManager, librarian);
                    break;
                case 2:
                    removeBook(collection, filesManager, librarian);
                    break;
                case 6:
                    registerReader(librarian, filesManager,  readers);
                    break;
            }
        }
    }

    public static void registerBook(Collection collection, FilesManager filesManager, Librarian librarian){
        Scanner scanner = new Scanner(System.in);
        String title, author, category;
        int totPages;
        System.out.print("Enter title: ");
        title = scanner.nextLine();
        System.out.print("Enther author: ");
        author = scanner.nextLine();
        System.out.print("Enter category: ");
        category = scanner.nextLine();
        while (true) {
            try {
                System.out.print("Enter the total amount of pages: ");
                totPages = scanner.nextInt();
                scanner.nextLine();
                if (totPages <= 0){
                    System.out.println("Please enter a positive integer");
                    continue;
                }
                librarian.registerBook(filesManager, collection, new Book(title, totPages, author, category));
                System.out.println("Book added successfully!");
                break;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid integer");
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Something went wrong");
            }
        }
    }

    public static void removeBook(Collection collection, FilesManager filesManager, Librarian librarian){
        int bookCode;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter book code: ");
                bookCode = scanner.nextInt();
                scanner.nextLine();
                if (bookCode < 0) {
                    System.out.println("Please enter a number equal or greater than O");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid integer");
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Something went wrong");
            }
        }

        Book book = collection.searchBookByCode(bookCode);
        if (book == null){
            System.out.println("Book not found!");
        }else{
            if (book.isBorrowed()){
                System.out.println("Could not remove a borrowed book!");
            }else{
                librarian.removeBook(filesManager, collection, book);
                System.out.println("Book removed successfully!");
            }
        }
    }

    public static void registerReader(Librarian librarian, FilesManager filesManager, List<Reader> readers){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter reader name: ");
        String readerName = scanner.nextLine();
        librarian.registerReader(readerName, filesManager, readers);
        System.out.println("Reader added successfully!");
    }
}
