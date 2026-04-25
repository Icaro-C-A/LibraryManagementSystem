package Files;
import java.io.File;

public class FilesManager {
    private void createFile(String path, String name){
        File file = new File(path, name);
        try {
            if (file.createNewFile()){
                System.out.println("File created successfully:" + file.getName());
            }
        }
        catch (Exception e){
            System.out.println("Something went wrong.");
        }
    }
}
