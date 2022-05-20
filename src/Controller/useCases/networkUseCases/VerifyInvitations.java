package Controller.useCases.networkUseCases;

import java.util.Objects;

import Controller.Database.Database;
import Model.Account;
import View.Menu;

public class VerifyInvitations {

    public static void execute(int positionUser, String nameFriend, Database database) {
        int cont = 0;
        Account[] accounts = database.getAccounts();
        if (accounts[positionUser].getInvitations() == null) {
            VerifyFriendship.execute(positionUser, nameFriend, database);
        } else {
            for (int j = 0; j < accounts[positionUser].getInvitations().length; j++) {
                if (Objects.equals(accounts[positionUser].getInvitations()[j], nameFriend)) {
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
