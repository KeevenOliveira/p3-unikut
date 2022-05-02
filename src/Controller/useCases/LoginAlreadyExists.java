package Controller.useCases;

import java.util.Objects;

import Controller.Database.Database;

public class LoginAlreadyExists {

    public static boolean verify(String login, Database database) {
        if(database.isEmpty()) {
            return false;
        } else {
            for(int i = 0; i < database.getAccounts().length; i++) {
                if(Objects.equals(database.accounts[i].getLogin(), login)) {
                    return true;
                }
            }
        }
        return false;
    }
}