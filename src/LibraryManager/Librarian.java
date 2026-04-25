package LibraryManager;

public class Librarian {
    public void borrowBook(int code, Book book, Reader reader){
        Loan loan = new Loan(code, book, reader);
        reader.addLoan(loan);
    }

    public void payFine(Reader reader, double value){
        if (value > 0 && value <= reader.getDebt()){
            reader.setDebt(reader.getDebt() - value);
            System.out.println("R$" + value + " deducted from" + reader.getName() + "'s" + " debt. R$" + reader.getDebt() + " remaining debt.");
        }else if (value > reader.getDebt()){
            double change = value - reader.getDebt();
            reader.setDebt(0);
            System.out.println("All fines were paid. Give change of R$" + change + ".");
        }else{
            System.out.println("The amount to pay fine is invalid.");
        }
    }

    public void registerBook(Book book, Collection collection){
        collection.addBook(book);
    }

    public Reader registerReader(String name, int register){
        return new Reader(name, register);
    }
}