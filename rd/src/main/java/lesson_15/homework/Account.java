package lesson_15.homework;

import lesson_15.homework.exceptions.WrongOperationException;

public class Account {
    private String id;
    private double balance;
    private String currency;

    public Account(String id, double balance, String currency) {
        this.id = id;
        this.balance = balance;
        this.currency = currency;
    }

    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void withdraw(double amount) throws WrongOperationException {
        if (balance >= amount) {
            balance -= amount;
        } else {
            throw new WrongOperationException("Insufficient funds");
        }
    }
}
