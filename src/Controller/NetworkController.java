package Controller;

import Controller.useCases.networkUseCases.*;
import Interfaces.INetworkController;
import Controller.Database.*;

public class NetworkController implements INetworkController {
    public static void listingFriends(int positionUser, Database database) {
        ListingFriends.execute(positionUser, database);
    }

    public static void listingMessages(int positionUser, Database database) {
        ListingMessages.execute(positionUser, database);
    }

    public static void verifyFriendship(int positionUser, String nameFriend, Database database) {
        VerifyFriendship.execute(positionUser, nameFriend, database);
    }

    public static void verifyInvitations(int positionUser, String nameFriend, Database database) {
        VerifyInvitations.execute(positionUser, nameFriend, database);
    }

    public static void verifyInvited(int positionUser, String nameFriend, Database database) {
        VerifyInvited.execute(positionUser, nameFriend, database);
    }

    public static void verifyPendingInvitations(int positionUser, Database database) {
        VerifyPendingInvitations.execute(positionUser, database);
    }
}
