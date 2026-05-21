package Control;

import Model.*;
import Persistence.FilesManager;
import View.ConsoleView;

import java.io.IOException;
import java.util.List;

public class LibraryController {
    private ConsoleView view;
    private FilesManager filesManager;
    private Collection collection;
    private List<Reader> readers;
    private List<Loan> loans;

    public LibraryController(ConsoleView view, FilesManager filesManager) throws IOException {
        this.view = view;
        this.filesManager = filesManager;
        this.collection = filesManager.loadCollection();
        this.readers = filesManager.loadReaders();
        this.loans = FilesManager.loadLoans();
    }

    public void start() {
        while (true) {
            int choice = view.showMainMenu();
            switch (choice) {
                case 1:
                    registerBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 6:
                    registerReader();
                    break;
                case 0:
                    view.showMessage("Goodbye!");
                    return;
                default:
                    view.showMessage("Invalid option. Try again.");
            }
        }
    }

    private void registerBook() {
        String title = view.readString("Enter title: ");
        String author = view.readString("Enter author: ");
        String category = view.readString("Enter category: ");
        int totPages = view.readInt("Enter total pages: ");

        Book newBook = new Book(title, totPages, author, category);
        collection.addBook(newBook);

        try {
            filesManager.saveCollection(collection);
            view.showMessage("Book added successfully!");
        } catch (IOException e) {
            view.showMessage("Critical Error: Could not save to database!");
        }
    }

    private void removeBook() {
        int code = view.readInt("Enter the book code to remove: ");
        Book book = collection.searchBookByCode(code);

        if (book == null) {
            view.showMessage("Book not found!");
            return;
        }

        if (book.isBorrowed()) {
            view.showMessage("Cannot remove a borrowed book!");
            return;
        }

        collection.removeBook(book);
        try {
            filesManager.saveCollection(collection);
            view.showMessage("Book removed successfully!");
        } catch (IOException e) {
            view.showMessage("Error saving to database!");
        }
    }

    private void registerReader() {
        String name = view.readString("Enter reader name: ");
        Reader newReader = new Reader(name);
        readers.add(newReader);

        try {
            filesManager.saveReaders(readers);
            view.showMessage("Reader registered successfully!");
        } catch (IOException e) {
            view.showMessage("Error saving to database!");
        }
    }
}