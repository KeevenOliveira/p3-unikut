package Controller;

import Controller.useCases.interactionsUseCases.*;
import Controller.Database.*;

public class InteractionsController {
    public static void acceptFriendShip(int positionUser, String nameFriend, Database database) {
        AcceptFriendShip.execute(positionUser, nameFriend, database);
    }

    public static void addFriend(int positionUser, String nameFriend, Database database) {
        AddFriend.execute(positionUser, nameFriend, database);
    }

    public static void sendMessage(int positionUser, String nameFriend, Database database) {
        SendMessage.execute(positionUser, nameFriend, database);
    }
}
