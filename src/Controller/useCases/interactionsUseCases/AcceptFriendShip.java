package Controller.useCases.interactionsUseCases;

import java.util.Objects;
import java.util.Scanner;

import Controller.Database.Database;
import Model.Account;
import View.Menu;

import Controller.useCases.accountUseCases.*;
import Controller.useCases.networkUseCases.*;

public class AcceptFriendShip {

    public static void execute(int positionUser, String nameFriend, Database database) {
        Scanner sc = new Scanner(System.in);
        int indexFriend = 0;
        Account[] accounts = database.getAccounts();
        if (accounts[positionUser].getFriends() == null) {
            String[] listFriends = new String[1];
            listFriends[0] = nameFriend;
            indexFriend = GetAccountPosition.execute(nameFriend, database);
            accounts[positionUser].setFriends(listFriends);
            Menu.printFriendAccepted(nameFriend);
            Menu.printMenuFriend();
            String[] friends = accounts[indexFriend].getFriends();
            int selected = sc.nextInt();
            if (selected == 1) {
                SendMessage.execute(positionUser, nameFriend, database);
            }
            if (friends == null) {
                String[] listFriendship = new String[1];
                listFriendship[0] = accounts[positionUser].getLogin();
                accounts[indexFriend].setFriends(listFriendship);
            } else {
                String[] listFriendship = new String[friends.length + 1];
                for (int i = 0; i < friends.length; i++) {
                    listFriendship[i] = friends[i];
                }
                listFriendship[friends.length] = accounts[positionUser]
                        .getLogin();
                accounts[indexFriend].setFriends(listFriendship);
            }
            String[] invited = accounts[positionUser].getInvited();

            RemoveInvited.execute(invited, indexFriend, accounts);

            RemoveInteractions.execute(indexFriend, positionUser, accounts);

        } else {
            String[] friends = accounts[positionUser].getFriends();
            String[] newlistFriends = new String[friends.length + 1];
            for (int i = 0; i < friends.length; i++) {
                newlistFriends[i] = friends[i];
            }
            newlistFriends[friends.length] = nameFriend;
            accounts[positionUser].setFriends(newlistFriends);
            Menu.printFriendAccepted(nameFriend);
            Menu.printMenuFriend();
            int selected = sc.nextInt();
            if (selected == 1) {
                SendMessage.execute(positionUser, nameFriend, database);
            }
            indexFriend = GetAccountPosition.execute(nameFriend, database);

            String[] yourFriends = accounts[indexFriend].getFriends();
            String[] listFriendship = new String[yourFriends.length + 1];
            for (int i = 0; i < yourFriends.length; i++) {
                listFriendship[i] = yourFriends[i];
            }
            listFriendship[yourFriends.length] = accounts[positionUser].getLogin();
            accounts[indexFriend].setFriends(listFriendship);
            String[] invited = accounts[positionUser].getInvited();

            RemoveInvited.execute(invited, indexFriend, accounts);

            RemoveInteractions.execute(indexFriend, positionUser, accounts);
        }
    }
}