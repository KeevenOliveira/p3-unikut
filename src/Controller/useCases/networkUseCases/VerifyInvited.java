package Controller.useCases.networkUseCases;

import java.util.Objects;
import java.util.Scanner;

import Controller.Database.Database;

import Controller.useCases.interactionsUseCases.AcceptFriendShip;
import Model.Account;
import View.Menu;

public class VerifyInvited {
    public static void execute(int positionUser, String nameFriend, Database database) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        Account[] accounts = database.getAccounts();
        if (accounts[positionUser].getInvited() == null) {
            VerifyInvitations.execute(positionUser, nameFriend, database);
        } else {
            for (int i = 0; i < accounts[positionUser].getInvited().length; i++) {
                if (Objects.equals(accounts[positionUser].getInvited()[i], nameFriend)) {
                    System.out.println(nameFriend + " convidou você para serem amigos");
                    System.out.println(" ");
                    count = 1;
                    Menu.printMenuAcceptFriend();
                    int select = sc.nextInt();
                    if (select == 1) {
                        AcceptFriendShip.execute(positionUser, nameFriend, database);
                    }
                }
            }
            if (count < 1) {
                VerifyInvitations.execute(positionUser, nameFriend, database);
            }
        }
        count = 0;
    }
}
