package main;

import Control.LibraryController;
import Persistence.FilesManager;
import View.ConsoleView;

public class Program {
    public static void main(String[] args) {
        try {
            ConsoleView view = new ConsoleView();
            FilesManager filesManager = new FilesManager();
            LibraryController controller = new LibraryController(view, filesManager);

            controller.start();

        } catch (Exception e) {
            System.out.println("CRITICAL SYSTEM FAILURE: " + e.getMessage());
        }
    }
}