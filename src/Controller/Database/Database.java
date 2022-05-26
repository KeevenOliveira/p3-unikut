package Controller.Database;

import Model.Account;

public final class Database {
    private static Database instance;
    public Account[] accounts;

    private Database(Account[] accounts) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.accounts = accounts;
    }

    public static Database getInstance(Account[] accounts) {
        if (instance == null) {
            instance = new Database(accounts);
        }
        return instance;
    }

    public Account[] getAccounts() {
        return this.accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public boolean isEmpty() {
        if (this.accounts == null) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        } else {
            return this.accounts.length;
        }
    }
}
