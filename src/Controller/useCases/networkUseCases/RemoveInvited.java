package Controller.useCases.networkUseCases;

import java.util.Objects;
import Model.Account;

public class RemoveInvited {
    public static void execute(String[] invited, int indexFriend, Account[] accounts) {
        for (int j = 0; j < invited.length; j++) {
            if (Objects.equals(invited[j],
                    accounts[indexFriend].getLogin())) {
                invited[j] = null;
            }
        }
    }
}
