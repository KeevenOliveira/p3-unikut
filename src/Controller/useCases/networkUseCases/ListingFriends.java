package Controller.useCases.networkUseCases;

import View.Menu;

import Controller.Database.Database;

public class ListingFriends {

    public static void execute(int positionUser, Database database) {
        Menu.printYourFriends();
        if (database.accounts[positionUser].getFriends() == null) {
            Menu.printNotYourFriends();
        } else {
            for (int i = 0; i < database.accounts[positionUser].getFriends().length; i++) {
                System.out.println(database.accounts[positionUser].getFriends()[i]);
            }
        }
        System.out.println("----------------");
    }
}
