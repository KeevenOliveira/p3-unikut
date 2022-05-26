package Controller.Database;

import Model.Account;

public final class Database {
    private static Database instance;
    public Account[] accounts;

    private Database(Account[] value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.accounts = value;
    }

    public static Database getInstance(Account[] value) {
        if (instance == null) {
            instance = new Database(value);
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
