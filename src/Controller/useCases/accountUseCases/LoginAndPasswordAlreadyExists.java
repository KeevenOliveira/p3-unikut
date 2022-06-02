package Controller.useCases.accountUseCases;

import Controller.Database.Database;
import Model.*;
import java.util.Objects;

public class LoginAndPasswordAlreadyExists {
    public static boolean verify(String login, String password, Database database) {
        Account[] accounts = database.getAccounts();
        if (database.isEmpty()) {
            return false;
        } else {
            for (int i = 0; i < accounts.length; i++) {
                if (Objects.equals(accounts[i].getLogin(), login)
                        && Objects.equals(accounts[i].getPassword(), password)) {
                    return true;
                }
            }
        }
        return false;
    }
}
