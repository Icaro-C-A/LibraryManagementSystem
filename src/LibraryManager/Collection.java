package LibraryManager;
import java.util.ArrayList;
import java.util.List;


public class Collection {
    private List<Book> books = new ArrayList<>();

    //constructor
    public Collection() {
    }

    //personalized methods
    public void addBook(Book newBook){
        this.books.add(newBook);
    }

    public void removeBook(Book book){
        this.books.remove(book);
    }

    public int getBooksSize() {
        return this.books.size();
    }

    //getters and setters
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
