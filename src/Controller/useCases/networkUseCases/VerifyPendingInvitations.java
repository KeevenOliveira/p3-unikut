package Controller.useCases.networkUseCases;

import java.util.Scanner;

import Controller.Database.Database;
import Controller.useCases.interactionsUseCases.AcceptFriendShip;
import View.Menu;

public class VerifyPendingInvitations {
    public static void execute(int positionUser, Database database) {
        Scanner sc = new Scanner(System.in);
        Menu.printPendingInv();
        int cont = 0;
        if (database.accounts[positionUser].getInvitations() == null) {
            Menu.printNeverUser();
        } else {
            for (int i = 0; i < database.accounts[positionUser].getInvitations().length; i++) {
                if (database.accounts[positionUser].getInvitations()[i] != null) {
                    System.out.println(database.accounts[positionUser].getInvitations()[i]);
                    cont++;
                }
            }
            if (cont != 0) {
                Menu.printWaitInv();
            } else {
                Menu.printNeverUser();
            }
        }
        Menu.printPendingRequests();
        cont = 0;
        if (database.accounts[positionUser].getInvited() == null) {
            Menu.printNeverUser();
        } else {
            for (int i = 0; i < database.accounts[positionUser].getInvited().length; i++) {
                if (database.accounts[positionUser].getInvited()[i] != null) {
                    System.out.println(database.accounts[positionUser].getInvited()[i]);
                    cont++;
                }
            }
            if (cont != 0) {
                Menu.printMenuAcceptFriend();
                int selected = sc.nextInt();
                if (selected == 1) {
                    String nameUser = sc.next();
                    AcceptFriendShip.execute(positionUser, nameUser, database);
                }
            } else {
                Menu.printNeverUser();
            }
        }
        System.out.println("---------------");
    }
}
