package Controller.useCases.accountUseCases;

import java.util.Objects;

import Controller.Database.Database;
import Model.*;

public class LoginAlreadyExists {

    public static boolean verify(String login, Database database) {
        Account[] accounts = database.getAccounts();
        if (database.isEmpty()) {
            return false;
        } else {
            for (int i = 0; i < accounts.length; i++) {
                if (Objects.equals(accounts[i].getLogin(), login)) {
                    return true;
                }
            }
        }
        return false;
    }
}