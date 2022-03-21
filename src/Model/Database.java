package Model;

import Model.Account;

import java.util.LinkedList;

public class Database {
    public static LinkedList<Account> Accounts[];

    public LinkedList<Account>[] getAccounts() {
        return Database.Accounts;
    }

    public void setAccounts(LinkedList<Account>[] accounts) {
        Database.Accounts = accounts;
    }
}