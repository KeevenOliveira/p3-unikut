package Controller.useCases;

import java.util.Objects;

import Controller.Database.Database;

public class VerifyUserFriend {
    public static boolean execute(String login, String nameFriend, Database database) {
        if (Objects.equals(login, nameFriend)) {
            throw new RuntimeException("Esse é o seu login!");
        } else {
            for (int i = 0; i < database.getAccounts().length; i++) {
                if (Objects.equals(database.accounts[i].getLogin(), nameFriend)) {
                    System.out.println(database.accounts[i].getName());
                    return true;
                }
            }
        }
        return false;
    }
}
