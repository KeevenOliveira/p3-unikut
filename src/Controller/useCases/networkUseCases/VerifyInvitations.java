package Controller.useCases.networkUseCases;

import java.util.Objects;

import Controller.Database.Database;
import View.Menu;

public class VerifyInvitations {

    public static void execute(int positionUser, String nameFriend, Database database) {
        int cont = 0;
        if (database.accounts[positionUser].getInvitations() == null) {
            VerifyFriendship.execute(positionUser, nameFriend, database);
        } else {
            for (int j = 0; j < database.accounts[positionUser].getInvitations().length; j++) {
                if (Objects.equals(database.accounts[positionUser].getInvitations()[j], nameFriend)) {
                    Menu.printPendigFriendship();
                    cont = 1;
                }
            }
            if (cont < 1) {
                VerifyFriendship.execute(positionUser, nameFriend, database);
            }
        }
        cont = 0;
    }
}
