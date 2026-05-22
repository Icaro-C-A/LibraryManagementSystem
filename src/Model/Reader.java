package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    private static int added = 0;
    private String name;
    private int register;
    private boolean registered;
    private List<Loan> loans = new ArrayList<>();
    private double debt;

    //constructor
    public Reader(String name){
        this.setName(name);
        this.setRegister(added);
        this.setRegistered(true);
        this.setDebt(0d);
        added ++;
    }

    public Reader(String name, int register, boolean registered, double debt){
        this.setName(name);
        this.setRegister(register);
        this.setRegistered(registered);
        this.setDebt(debt);
    }

    //personalized methods
    public void addLoan(Loan loan){
        this.loans.add(loan);
    }

    public void removeLoan(Loan loan){
        this.loans.remove(loan);
    }

    public boolean canBorrow() {
        LocalDate today = LocalDate.now();

        for (Loan loan : loans) {
            if (today.isAfter(loan.getReturnDate())) {
                return false;
            }
        }
        return true;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRegister() {
        return register;
    }

    public void setRegister(int register) {
        this.register = register;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }
}
