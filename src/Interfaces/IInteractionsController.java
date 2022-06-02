package Interfaces;

import Controller.Database.Database;

public interface IInteractionsController {
    public static void acceptFriendShip(int positionUser, String nameFriend, Database database) {
    };

    public static void addFriend(int positionUser, String nameFriend, Database database) {
    }

    public static void sendMessage(int positionUser, String nameFriend, Database database) {
    }

    public static boolean verifyUserFriend(String login, String nameFriend, Database database) {
        return false;
    }
}
