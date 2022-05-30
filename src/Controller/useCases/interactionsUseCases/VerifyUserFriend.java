package Controller.useCases.interactionsUseCases;

import java.util.Objects;

import Controller.Database.Database;
import Model.Account;

public class VerifyUserFriend {
    public static boolean execute(String login, String nameFriend, Database database) {
        Account[] accounts = database.getAccounts();
        if (Objects.equals(login, nameFriend)) {
            throw new RuntimeException("Esse é o seu login!");
        } else {
            for (int i = 0; i < accounts.length; i++) {
                if (Objects.equals(accounts[i].getLogin(), nameFriend)) {
                    System.out.println(accounts[i].getName());
                    return true;
                }
            }
        }
        return false;
    }
}
