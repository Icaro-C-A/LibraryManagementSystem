package Files;
import LibraryManager.*;
import LibraryManager.Reader;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FilesManager {
    private final static String DATA_FOLDER = "data";
    private final static String COLLECTION_FILE = "collections.txt";
    private final static String READERS_FILE = "readers.txt";
    private final static String LOANS_FILE = "loans.txt";

    //constructor
    public FilesManager() {
        File directory = new File(DATA_FOLDER);
        if (!directory.exists()){
            directory.mkdir();
            System.out.println("Created new directory: " + DATA_FOLDER);
        }

        prepareFile(DATA_FOLDER, COLLECTION_FILE);
        prepareFile(DATA_FOLDER, READERS_FILE);
        prepareFile(DATA_FOLDER, LOANS_FILE);
    }

    //personalized methods
    public void saveCollection(Collection collection){
        String filePath = DATA_FOLDER + File.separator + COLLECTION_FILE;
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            for (Book book : collection.getBooks()){
                String line = book.getCode() + ";";
                line += book.getTitle() + ";";
                line += book.getTotPages() + ";";
                line += book.getAuthor() + ";";
                line += book.getCategory() + ";";
                line += book.isBorrowed() + ";";
                writer.write(line);
                writer.newLine();
            }
        }catch (Exception e){
            System.out.println("Something went wrong");
        }
    }

    public Collection loadCollection(){
        Collection collection = new Collection();
        String filePath = DATA_FOLDER + File.separator + COLLECTION_FILE;
        List <Book> books = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine()) != null){
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

        }catch (FileNotFoundException e){
            System.out.println("Could not locate file");
        }catch (IOException e){
            System.out.println("Something went wrong");
        }

        collection.setBooks(books);
        return collection;
    }

    public void saveReaders(List<Reader> readers){
        String filePath = DATA_FOLDER + File.separator + READERS_FILE;
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            for (Reader reader: readers){
                String line = reader.getName() + ";";
                line += reader.getRegister() + ";";
                line += reader.isRegistered() + ";";
                line += reader.getDebt() + ";";
                writer.write(line);
                writer.newLine();
            }
        }catch (Exception e){
            System.out.println("Something went wrong");
        }
    }

    public List<Reader> loadReaders(){
        String filePath = DATA_FOLDER + File.separator + READERS_FILE;
        List <Reader> readers = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] data = line.split(";");
                String name = data[0];
                int code = Integer.parseInt(data[1]);
                boolean registered = Boolean.parseBoolean(data[2]);
                float debt = Float.parseFloat(data[3]);
                Reader reader = new Reader(name, code, registered, debt);
                readers.add(reader);
            }

        }catch (FileNotFoundException e){
            System.out.println("Could not locate file");
        }catch (IOException e){
            System.out.println("Something went wrong");
        }

        return readers;
    }

    public void saveLoans(List<Loan> loans){
        String filePath = DATA_FOLDER + File.separator + LOANS_FILE;
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            for (Loan loan: loans){
                String line = loan.getCode() + ";";
                line += loan.getLoanDate() + ";";
                line += loan.getReturnDate() + ";";
                line += loan.getBook().getCode() + ";";
                line += loan.getReader().getRegister() + ";";
                writer.write(line);
                writer.newLine();
            }
        }catch (Exception e){
            System.out.println("Something went wrong");
        }
    }

    public static List<Loan> loadLoans(){
        String filePath = DATA_FOLDER + File.separator + LOANS_FILE;
        List <Loan> loans = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] data = line.split(";");
                int code = Integer.parseInt(data[0]);
                LocalDate loanDate = LocalDate.parse(data[1]);
                LocalDate returnDate = LocalDate.parse(data[2]);
                int bookCode = Integer.parseInt(data[3]);
                int readerCode = Integer.parseInt(data[4]);
                Loan loan = new Loan (code, loanDate, returnDate, bookCode, readerCode);
                loans.add(loan);
            }

        }catch (FileNotFoundException e){
            System.out.println("Could not locate file");
        }catch (IOException e){
            System.out.println("Something went wrong");
        }

        return loans;
    }

    public static Book searchBook(int code){
        String filePath = DATA_FOLDER + File.separator + COLLECTION_FILE;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] data = line.split(";");
                int bookCode = Integer.parseInt(data[0]);
                if (bookCode == code){
                    String title = data[1];
                    int totPages = Integer.parseInt(data[2]);
                    String author = data[3];
                    String category = data[4];
                    boolean borrowed = Boolean.parseBoolean(data[5]);
                    return new Book(title, bookCode, totPages, author, category, borrowed);
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("Could not locate file");
        }catch (IOException e){
            System.out.println("Something went wrong");
        }

        return null;
    }

    public static Reader searchReader(int code){
        String filePath = DATA_FOLDER + File.separator + READERS_FILE;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] data = line.split(";");
                int readerCode = Integer.parseInt(data[1]);
                if (readerCode == code){
                    String name = data[0];
                    boolean registered = Boolean.parseBoolean(data[2]);
                    float debt = Float.parseFloat(data[3]);
                    return new Reader(name, code, registered, debt);
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("Could not locate file");
        }catch (IOException e){
            System.out.println("Something went wrong");
        }

        return null;
    }

    private void createFile(String path, String name){
        File file = new File(path, name);
        try {
            if (file.createNewFile()){
                System.out.println("File created successfully: " + file.getName());
            }
        }
        catch (Exception e){
            System.out.println("Something went wrong.");
        }
    }

    private boolean fileExists(String path, String name){
        File file = new File(path, name);
        return file.exists();
    }

    private void prepareFile(String path, String name){
        if (!fileExists(path, name)){
            createFile(path, name);
        }
    }
}
