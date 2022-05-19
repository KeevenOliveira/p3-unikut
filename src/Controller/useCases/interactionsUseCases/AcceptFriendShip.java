package Controller.useCases.interactionsUseCases;

import java.util.Objects;
import java.util.Scanner;

import Controller.Database.Database;
import View.Menu;

public class AcceptFriendShip {

    public static void execute(int positionUser, String nameFriend, Database database) {
        Scanner sc = new Scanner(System.in);
        int indiceFriend = 0;
        if (database.accounts[positionUser].getFriends() == null) {
            String[] listFriends = new String[1];
            listFriends[0] = nameFriend;
            for (int i = 0; i < database.accounts.length; i++) {
                if (Objects.equals(database.accounts[i].getLogin(), nameFriend)) {
                    indiceFriend = i;
                }
            }
            database.accounts[positionUser].setFriends(listFriends);
            System.out.println(" ");
            System.out.println(nameFriend + " foi aceito como amigo.");
            System.out.println("Agora vocês podem interagir! O que deseja fazer agora?");
            Menu.printMenuFriend();
            int selected = sc.nextInt();
            if (selected == 1) {
                SendMessage.execute(positionUser, nameFriend, database);
            }
            if (database.accounts[indiceFriend].getFriends() == null) {
                String[] listFriendship = new String[1];
                listFriendship[0] = database.accounts[positionUser].getLogin();
                database.accounts[indiceFriend].setFriends(listFriendship);
            } else {
                String[] listFriendship = new String[database.accounts[indiceFriend].getFriends().length + 1];
                for (int i = 0; i < database.accounts[indiceFriend].getFriends().length; i++) {
                    listFriendship[i] = database.accounts[indiceFriend].getFriends()[i];
                }
                listFriendship[database.accounts[indiceFriend].getFriends().length] = database.accounts[positionUser]
                        .getLogin();
                database.accounts[indiceFriend].setFriends(listFriendship);
            }
            for (int j = 0; j < database.accounts[positionUser].getInvited().length; j++) {
                if (Objects.equals(database.accounts[positionUser].getInvited()[j],
                        database.accounts[indiceFriend].getLogin())) {
                    database.accounts[positionUser].getInvited()[j] = null;
                }
            }
            for (int k = 0; k < database.accounts[indiceFriend].getInvitations().length; k++) {
                if (Objects.equals(database.accounts[indiceFriend].getInvitations()[k],
                        database.accounts[positionUser].getLogin())) {
                    database.accounts[indiceFriend].getInvitations()[k] = null;
                }
            }

        } else {
            String[] listFriends = new String[database.accounts[positionUser].getFriends().length + 1];
            for (int i = 0; i < database.accounts[positionUser].getFriends().length; i++) {
                listFriends[i] = database.accounts[positionUser].getFriends()[i];
            }
            listFriends[database.accounts[positionUser].getFriends().length] = nameFriend;
            database.accounts[positionUser].setFriends(listFriends);
            System.out.println(" ");
            System.out.println(nameFriend + " foi aceito como amigo.");
            System.out.println("Agora vocês podem interagir! O que deseja fazer agora?");
            Menu.printMenuFriend();
            int selected = sc.nextInt();
            if (selected == 1) {
                SendMessage.execute(positionUser, nameFriend, database);
            }
            for (int i = 0; i < database.accounts.length; i++) {
                if (Objects.equals(database.accounts[i].getLogin(), nameFriend)) {
                    indiceFriend = i;
                }
            }
            if (database.accounts[indiceFriend].getFriends() == null) {
                String[] listFriendship = new String[1];
                listFriendship[0] = database.accounts[positionUser].getLogin();
                database.accounts[indiceFriend].setFriends(listFriendship);
            } else {
                String[] listFriendship = new String[database.accounts[indiceFriend].getFriends().length + 1];
                for (int i = 0; i < database.accounts[indiceFriend].getFriends().length; i++) {
                    listFriendship[i] = database.accounts[indiceFriend].getFriends()[i];
                }
                listFriendship[database.accounts[indiceFriend].getFriends().length] = database.accounts[positionUser]
                        .getLogin();
                database.accounts[indiceFriend].setFriends(listFriendship);
            }
            for (int j = 0; j < database.accounts[positionUser].getInvited().length; j++) {
                if (Objects.equals(database.accounts[positionUser].getInvited()[j],
                        database.accounts[indiceFriend].getLogin())) {
                    database.accounts[positionUser].getInvited()[j] = null;
                }
            }
            for (int k = 0; k < database.accounts[indiceFriend].getInvitations().length; k++) {
                if (Objects.equals(database.accounts[indiceFriend].getInvitations()[k],
                        database.accounts[positionUser].getLogin())) {
                    database.accounts[indiceFriend].getInvitations()[k] = null;
                }
            }
        }
    }
}
