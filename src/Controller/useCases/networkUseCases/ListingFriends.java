package Controller.useCases.networkUseCases;

import View.Menu;

import Controller.Database.Database;
import Model.Account;

public class ListingFriends {

    public static void execute(int positionUser, Database database) {
        Account[] accounts = database.getAccounts();
        Menu.printYourFriends();
        if (accounts[positionUser].getFriends() == null) {
            Menu.printNotYourFriends();
        } else {
            for (int i = 0; i < accounts[positionUser].getFriends().length; i++) {
                System.out.println(accounts[positionUser].getFriends()[i]);
            }
        }
        System.out.println("----------------");
    }
}
