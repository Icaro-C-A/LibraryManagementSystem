package Persistence;

import Model.Book;
import Model.Collection;
import Model.Loan;
import Model.Reader;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FilesManager {
    private final static String DATA_FOLDER = "data";
    private final static String COLLECTION_FILE = "collections.txt";
    private final static String READERS_FILE = "readers.txt";
    private final static String LOANS_FILE = "loans.txt";

    public FilesManager() {
        File directory = new File(DATA_FOLDER);
        if (!directory.exists()) {
            directory.mkdir();
        }

        prepareFile(DATA_FOLDER, COLLECTION_FILE);
        prepareFile(DATA_FOLDER, READERS_FILE);
        prepareFile(DATA_FOLDER, LOANS_FILE);
    }

    public void saveCollection(Collection collection) throws IOException {
        String filePath = DATA_FOLDER + File.separator + COLLECTION_FILE;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Book book : collection.getBooks()) {
                String line = book.getCode() + ";" +
                        book.getTitle() + ";" +
                        book.getTotPages() + ";" +
                        book.getAuthor() + ";" +
                        book.getCategory() + ";" +
                        book.isBorrowed() + ";";
                writer.write(line);
                writer.newLine();
            }
        }
    }

    public Collection loadCollection() throws IOException {
        Collection collection = new Collection();
        String filePath = DATA_FOLDER + File.separator + COLLECTION_FILE;
        List<Book> books = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                int code = Integer.parseInt(data[0]);
                String title = data[1];
                int totPages = Integer.parseInt(data[2]);
                String author = data[3];
                String category = data[4];
                boolean borrowed = Boolean.parseBoolean(data[5]);

                Book book = new Book(title, code, totPages, author, category, borrowed);
                books.add(book);
            }
        }
        collection.setBooks(books);
        return collection;
    }

    public void saveReaders(List<Reader> readers) throws IOException {
        String filePath = DATA_FOLDER + File.separator + READERS_FILE;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Reader reader : readers) {
                String line = reader.getName() + ";" +
                        reader.getRegister() + ";" +
                        reader.isRegistered() + ";" +
                        reader.getDebt() + ";";
                writer.write(line);
                writer.newLine();
            }
        }
    }

    public List<Reader> loadReaders() throws IOException {
        String filePath = DATA_FOLDER + File.separator + READERS_FILE;
        List<Reader> readers = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(";");
                String name = data[0];
                int code = Integer.parseInt(data[1]);
                boolean registered = Boolean.parseBoolean(data[2]);
                float debt = Float.parseFloat(data[3]);

                Reader reader = new Reader(name, code, registered, debt);
                readers.add(reader);
            }
        }
        return readers;
    }

    public void saveLoans(List<Loan> loans) throws IOException {
        String filePath = DATA_FOLDER + File.separator + LOANS_FILE;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Loan loan : loans) {
                String line = loan.getCode() + ";" +
                        loan.getLoanDate() + ";" +
                        loan.getReturnDate() + ";" +
                        loan.getBook().getCode() + ";" +
                        loan.getReader().getRegister() + ";";
                writer.write(line);
                writer.newLine();
            }
        }
    }

    public static List<Loan> loadLoans() throws IOException {
        String filePath = DATA_FOLDER + File.separator + LOANS_FILE;
        List<Loan> loans = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(";");
                int code = Integer.parseInt(data[0]);
                LocalDate loanDate = LocalDate.parse(data[1]);
                LocalDate returnDate = LocalDate.parse(data[2]);
                int bookCode = Integer.parseInt(data[3]);
                int readerCode = Integer.parseInt(data[4]);

                Loan loan = new Loan(code, loanDate, returnDate, bookCode, readerCode);
                loans.add(loan);
            }
        }
        return loans;
    }

    public static Book searchBook(int code) throws IOException {
        String filePath = DATA_FOLDER + File.separator + COLLECTION_FILE;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                int bookCode = Integer.parseInt(data[0]);
                if (bookCode == code) {
                    String title = data[1];
                    int totPages = Integer.parseInt(data[2]);
                    String author = data[3];
                    String category = data[4];
                    boolean borrowed = Boolean.parseBoolean(data[5]);

                    return new Book(title, bookCode, totPages, author, category, borrowed);
                }
            }
        }
        return null;
    }

    public static Reader searchReader(int code) throws IOException {
        String filePath = DATA_FOLDER + File.separator + READERS_FILE;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                int readerCode = Integer.parseInt(data[1]);
                if (readerCode == code) {
                    String name = data[0];
                    boolean registered = Boolean.parseBoolean(data[2]);
                    float debt = Float.parseFloat(data[3]);

                    return new Reader(name, code, registered, debt);
                }
            }
        }
        return null;
    }

    private boolean createFile(String path, String name) {
        File file = new File(path, name);
        try {
            return file.createNewFile();
        } catch (IOException e) {
            return false;
        }
    }

    private boolean fileExists(String path, String name) {
        File file = new File(path, name);
        return file.exists();
    }

    private boolean prepareFile(String path, String name) {
        if (!fileExists(path, name)) {
            return createFile(path, name);
        }
        return true;
    }
}