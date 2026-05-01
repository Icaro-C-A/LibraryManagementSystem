package Files;
import LibraryManager.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilesManager {
    private final String DATA_FOLDER = "data";
    private final String COLLECTION_FILE = "collections.txt";
    private final String READERS_FILE = "readers.txt";
    private final String LOANS_FILE = "loans.txt";

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
    public Collection loadCollection(){
        Collection collection = new Collection();
        collection.setBooks(readCollection());

        return collection;
    }

    public List<Book> readCollection(){
        String filePath = DATA_FOLDER + File.separator + COLLECTION_FILE;
        List <Book> books = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine()) != null){
                line = line.replace(";", "");
                String[] data = line.split(",");

                int code = Integer.parseInt(data[0].trim());
                String title = data[1].trim();
                int totPages = Integer.parseInt(data[2].trim());
                String author = data[3].trim();
                String category = data[4].trim();
                boolean borrowed = Boolean.parseBoolean(data[5].trim());
                Book book = new Book(title,code , totPages, author, category, borrowed);
                books.add(book);
            }

        }catch (FileNotFoundException e){
            System.out.println("Could not locate file");
        }catch (IOException e){
            System.out.println("Something went wrong");
        }

        return books;
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
        }else{
            System.out.println("File " + path + name + " already exists.");
        }
    }
}
