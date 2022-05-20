package Controller.useCases.networkUseCases;

import java.util.Objects;
import Model.Account;

class RemoveInvitations {
    public void execute(int indexFriend, int positionUser, Account[] accounts) {
        for (int k = 0; k < accounts[indexFriend].getInvitations().length; k++) {
            if (Objects.equals(accounts[indexFriend].getInvitations()[k],
                    accounts[positionUser].getLogin())) {
                accounts[indexFriend].getInvitations()[k] = null;
            }
        }
    }
}