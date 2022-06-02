package Controller.useCases.accountUseCases;

import Controller.Database.Database;
import Model.*;
import View.Menu;
public class CreateAccount {
    public static void execute(Account account, Database database){
        if(database.isEmpty()) {
            Account[] AccountsTemplate = new Account[1];
            AccountsTemplate[0] = account;
            database.setAccounts(AccountsTemplate);
            Menu.printAccountCreated();
        } else {
            Account[] accountsTemplate = new Account[database.size() + 1];
            System.arraycopy(database.accounts, 0, accountsTemplate, 0, database.size());
            accountsTemplate[database.size()] = account;
            database.setAccounts(accountsTemplate);
            Menu.printAccountCreated();
        }
    }
}
