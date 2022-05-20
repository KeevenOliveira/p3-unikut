package Controller.useCases.networkUseCases;

import java.util.Objects;
import java.util.Scanner;

import Controller.Database.Database;
import Controller.useCases.interactionsUseCases.AddFriend;
import Controller.useCases.interactionsUseCases.SendMessage;
import Model.Account;
import View.Menu;

public class VerifyFriendship {
    public static void execute(int positionUser, String nameFriend, Database database) {
        Scanner sc = new Scanner(System.in);
        Account[] accounts = database.getAccounts();
        int cont = 0;
        if (accounts[positionUser].getFriends() == null) {
            Menu.printNotFriends();
            Menu.printMenuNoFriend();
            int select = sc.nextInt();
            if (select == 1) {
                AddFriend.execute(positionUser, nameFriend, database);
            }
        } else {
            for (int k = 0; k < accounts[positionUser].getFriends().length; k++) {
                if (Objects.equals(accounts[positionUser].getFriends()[k], nameFriend)) {
                    Menu.printFriends();
                    Menu.printMenuFriend();
                    int selected = sc.nextInt();
                    if (selected == 1) {
                        SendMessage.execute(positionUser, nameFriend, database);
                    }
                    cont = 1;
                }
            }
            if (cont < 1) {
                Menu.printNotFriends();
                Menu.printMenuNoFriend();
                int select = sc.nextInt();
                if (select == 1) {
                    AddFriend.execute(positionUser, nameFriend, database);
                }
            }
        }
        cont = 0;
    }
}
