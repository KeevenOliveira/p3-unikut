package Controller.useCases.accountUseCases;

import Controller.Database.Database;
import Model.Account;

public class CreateAccount {
    public static void execute(Account account, Database database){
        if(database.isEmpty()) {
            Account[] AccountsTemplate = new Account[1];
            AccountsTemplate[0] = account;
            database.setAccounts(AccountsTemplate);
            System.out.println("----------------------");
            System.out.println("Usuário criado com sucesso!");
            System.out.println("----------------------");
        } else {
            Account[] accountsTemplate = new Account[database.length() + 1];
            System.arraycopy(database.accounts, 0, accountsTemplate, 0, database.length());
            accountsTemplate[database.length()] = account;
            database.setAccounts(accountsTemplate);
            System.out.println("----------------------");
            System.out.println("Usuário criado com sucesso!");
            System.out.println("----------------------");
        }
    }
}
