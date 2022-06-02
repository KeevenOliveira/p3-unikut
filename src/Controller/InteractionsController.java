package Controller;

import Controller.useCases.interactionsUseCases.*;
import Controller.Database.*;
import Interfaces.IInteractionsController;

public class InteractionsController implements IInteractionsController {
    public static void acceptFriendShip(int positionUser, String nameFriend, Database database) {
        AcceptFriendShip.execute(positionUser, nameFriend, database);
    }

    public static void addFriend(int positionUser, String nameFriend, Database database) {
        AddFriend.execute(positionUser, nameFriend, database);
    }

    public static void sendMessage(int positionUser, String nameFriend, Database database) {
        SendMessage.execute(positionUser, nameFriend, database);
    }

    public static boolean verifyUserFriend(String login, String nameFriend, Database database) {
        return VerifyUserFriend.execute(login, nameFriend, database);
    }
}
