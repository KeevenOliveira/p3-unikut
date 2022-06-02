package Controller.useCases.accountUseCases;

import java.util.Objects;
import Controller.Database.Database;
import Model.*;

public class GetAccountPosition {
    public static int execute(String login, Database database) {
        Account[] accounts = database.getAccounts();
        for (int i = 0; i < accounts.length; i++) {
            if (Objects.equals(accounts[i].getLogin(), login)) {
                return i;
            }
        }
        throw new RuntimeException("Não existe usuário com este login!");
    }
}
