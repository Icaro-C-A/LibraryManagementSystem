package Files;
import java.io.File;

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
