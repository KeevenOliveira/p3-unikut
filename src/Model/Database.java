package Database;

import Model.Account;

public class Database {
    public Account Accounts[];

    public Account[] getAccounts() {
        return this.Accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.Accounts = accounts;
    }
}