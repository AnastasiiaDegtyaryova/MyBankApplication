package lesson_15.homework;

import lesson_15.homework.exceptions.WrongAccountException;
import lesson_15.homework.exceptions.WrongCurrencyException;
import lesson_15.homework.exceptions.WrongOperationException;

import java.util.HashMap;
import java.util.Map;

public class BankApplication {
    private Map<String, Account> accounts;

    public BankApplication() {
        accounts = new HashMap<>();
        accounts.put("accountId000", new Account("accountId000", 1000, "USD"));
        accounts.put("accountId001", new Account("accountId001", 500, "USD"));
        accounts.put("accountId002", new Account("accountId002", 300, "EUR"));
        accounts.put("accountId003", new Account("accountId003", 200, "HRV"));
    }

    public void process(String id, int amount, String currency) throws WrongAccountException, WrongCurrencyException, WrongOperationException {
        Account account = accounts.get(id);
        if (account == null) {
            throw new WrongAccountException("Account does not exist");
        }
        if (!account.getCurrency().equals(currency)) {
            throw new WrongCurrencyException("Wrong currency");
        }
        account.withdraw(amount);
    }
}
