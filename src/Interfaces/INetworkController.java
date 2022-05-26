package Interfaces;

import Controller.Database.Database;

public interface INetworkController {
    public static void listingFriends(int positionUser, Database database) {
    }

    public static void listingMessages(int positionUser, Database database) {
    }

    public static void verifyFriendship(int positionUser, String nameFriend, Database database) {
    }

    public static void verifyInvitations(int positionUser, String nameFriend, Database database) {
    }

    public static void verifyInvited(int positionUser, String nameFriend, Database database) {
    }

    public static void verifyPendingInvitations(int positionUser, Database database) {
    }
}
