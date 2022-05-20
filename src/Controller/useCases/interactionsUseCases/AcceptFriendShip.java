package Controller.useCases.interactionsUseCases;

import java.util.Objects;
import java.util.Scanner;

import Controller.Database.Database;
import Model.Account;
import View.Menu;

public class AcceptFriendShip {

    public static void execute(int positionUser, String nameFriend, Database database) {
        Scanner sc = new Scanner(System.in);
        int indiceFriend = 0;
        Account[] accounts = database.getAccounts();
        if (accounts[positionUser].getFriends() == null) {
            String[] listFriends = new String[1];
            listFriends[0] = nameFriend;
            for (int i = 0; i < accounts.length; i++) {
                if (Objects.equals(accounts[i].getLogin(), nameFriend)) {
                    indiceFriend = i;
                }
            }
            accounts[positionUser].setFriends(listFriends);
            System.out.println(" ");
            System.out.println(nameFriend + " foi aceito como amigo.");
            System.out.println("Agora vocês podem interagir! O que deseja fazer agora?");
            Menu.printMenuFriend();
            int selected = sc.nextInt();
            if (selected == 1) {
                SendMessage.execute(positionUser, nameFriend, database);
            }
            if (accounts[indiceFriend].getFriends() == null) {
                String[] listFriendship = new String[1];
                listFriendship[0] = accounts[positionUser].getLogin();
                accounts[indiceFriend].setFriends(listFriendship);
            } else {
                String[] listFriendship = new String[accounts[indiceFriend].getFriends().length + 1];
                for (int i = 0; i < accounts[indiceFriend].getFriends().length; i++) {
                    listFriendship[i] = accounts[indiceFriend].getFriends()[i];
                }
                listFriendship[accounts[indiceFriend].getFriends().length] = accounts[positionUser]
                        .getLogin();
                accounts[indiceFriend].setFriends(listFriendship);
            }
            for (int j = 0; j < accounts[positionUser].getInvited().length; j++) {
                if (Objects.equals(accounts[positionUser].getInvited()[j],
                        accounts[indiceFriend].getLogin())) {
                    accounts[positionUser].getInvited()[j] = null;
                }
            }
            for (int k = 0; k < accounts[indiceFriend].getInvitations().length; k++) {
                if (Objects.equals(accounts[indiceFriend].getInvitations()[k],
                        accounts[positionUser].getLogin())) {
                    accounts[indiceFriend].getInvitations()[k] = null;
                }
            }

        } else {
            String[] listFriends = new String[accounts[positionUser].getFriends().length + 1];
            for (int i = 0; i < accounts[positionUser].getFriends().length; i++) {
                listFriends[i] = accounts[positionUser].getFriends()[i];
            }
            listFriends[accounts[positionUser].getFriends().length] = nameFriend;
            accounts[positionUser].setFriends(listFriends);
            System.out.println(" ");
            System.out.println(nameFriend + " foi aceito como amigo.");
            System.out.println("Agora vocês podem interagir! O que deseja fazer agora?");
            Menu.printMenuFriend();
            int selected = sc.nextInt();
            if (selected == 1) {
                SendMessage.execute(positionUser, nameFriend, database);
            }
            for (int i = 0; i < accounts.length; i++) {
                if (Objects.equals(accounts[i].getLogin(), nameFriend)) {
                    indiceFriend = i;
                }
            }
            if (accounts[indiceFriend].getFriends() == null) {
                String[] listFriendship = new String[1];
                listFriendship[0] = accounts[positionUser].getLogin();
                accounts[indiceFriend].setFriends(listFriendship);
            } else {
                String[] listFriendship = new String[accounts[indiceFriend].getFriends().length + 1];
                for (int i = 0; i < accounts[indiceFriend].getFriends().length; i++) {
                    listFriendship[i] = accounts[indiceFriend].getFriends()[i];
                }
                listFriendship[accounts[indiceFriend].getFriends().length] = accounts[positionUser]
                        .getLogin();
                accounts[indiceFriend].setFriends(listFriendship);
            }
            for (int j = 0; j < accounts[positionUser].getInvited().length; j++) {
                if (Objects.equals(accounts[positionUser].getInvited()[j],
                        accounts[indiceFriend].getLogin())) {
                    accounts[positionUser].getInvited()[j] = null;
                }
            }
            for (int k = 0; k < accounts[indiceFriend].getInvitations().length; k++) {
                if (Objects.equals(accounts[indiceFriend].getInvitations()[k],
                        accounts[positionUser].getLogin())) {
                    accounts[indiceFriend].getInvitations()[k] = null;
                }
            }
        }
    }
}
