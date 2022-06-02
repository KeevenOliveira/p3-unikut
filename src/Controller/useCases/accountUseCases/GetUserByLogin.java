package Controller.useCases.accountUseCases;

import Controller.Database.Database;
import Model.*;
import java.util.Objects;

public class GetUserByLogin {
    public static Account execute(String login, Database database) {
        Account[] accounts = database.getAccounts();
        for (int i = 0; i < database.size(); i++) {
            if (Objects.equals(accounts[i].getLogin(), login)) {
                return accounts[i];
            }
        }
        return null;
    }
}
