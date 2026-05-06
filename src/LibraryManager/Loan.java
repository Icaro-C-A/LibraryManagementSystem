package LibraryManager;
import Files.FilesManager;

import java.time.LocalDate;


public class Loan {
    private static int added;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private int code;
    private Book book;
    private Reader reader;

    //constructor
    public Loan(Book book, Reader reader) {
        this.setLoanDate(LocalDate.now());
        this.setReturnDate(this.getLoanDate().plusDays(7));
        this.setCode(added);
        this.setBook(book);
        this.setReader(reader);
        added++;
    }

    public Loan(int code, LocalDate loanDate, LocalDate returnDate, int bookCode, int readerCode){
        this.setCode(code);
        this.setLoanDate(loanDate);
        this.setReturnDate(returnDate);
        this.setReader(FilesManager.searchReader(readerCode));
        this.setBook(FilesManager.searchBook(bookCode));
    }

    //getters and setters
    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public LocalDate getLoanDate(){
        return this.loanDate;
    }

    public void setLoanDate(LocalDate data){
        this.loanDate = data;
    }

    public LocalDate getReturnDate(){
        return this.returnDate;
    }

    public void setReturnDate(LocalDate data){
        this.returnDate = data;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanDate=" + loanDate +
                ", returnDate=" + returnDate +
                ", code=" + code +
                ", book=" + book.getCode() +
                ", reader=" + reader.getRegister() +
                '}';
    }
}
