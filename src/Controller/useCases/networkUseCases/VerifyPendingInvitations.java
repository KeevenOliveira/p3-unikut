package Controller.useCases.networkUseCases;

import java.util.Scanner;

import Controller.Database.Database;
import Controller.useCases.interactionsUseCases.AcceptFriendShip;
import Model.Account;
import View.Menu;

public class VerifyPendingInvitations {
    public static void execute(int positionUser, Database database) {
        Scanner sc = new Scanner(System.in);
        Account[] accounts = database.getAccounts();
        Menu.printPendingInv();
        int cont = 0;
        if (accounts[positionUser].getInvitations() == null) {
            Menu.printNeverUser();
        } else {
            for (int i = 0; i < accounts[positionUser].getInvitations().length; i++) {
                if (accounts[positionUser].getInvitations()[i] != null) {
                    System.out.println(accounts[positionUser].getInvitations()[i]);
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
        if (accounts[positionUser].getInvited() == null) {
            Menu.printNeverUser();
        } else {
            for (int i = 0; i < accounts[positionUser].getInvited().length; i++) {
                if (accounts[positionUser].getInvited()[i] != null) {
                    System.out.println(accounts[positionUser].getInvited()[i]);
                    cont++;
                }
            }
            if (cont != 0) {
                Menu.printMenuAcceptFriend();
                int selected = sc.nextInt();
                if (selected == 1) {
                    System.out.println("Digite o nome do usuário:");
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
