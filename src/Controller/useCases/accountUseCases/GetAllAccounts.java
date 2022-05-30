package Controller.useCases.accountUseCases;

import Controller.Database.Database;
import Model.Account;

public class GetAllAccounts {
    public static Account[] execute(Database database) {
        return database.getAccounts();
    }
}
