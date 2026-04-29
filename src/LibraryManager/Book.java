package LibraryManager;

public class Book {
    private String title;
    private int code;
    private int totPages;
    private String author;
    private String category;
    private boolean borrowed;

    //constructor
    public Book(String title, int code, int totPages, String author, String category) {
        this.setTitle(title);
        this.setCode(code);
        this.setTotPages(totPages);
        this.setAuthor(author);
        this.setCategory(category);
        this.setBorrowed(true);
    }

    //getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getTotPages() {
        return totPages;
    }

    public void setTotPages(int totPages) {
        this.totPages = totPages;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }
}