package Controller.useCases.accountUseCases;

import java.util.Objects;
import Controller.Database.Database;
import Model.Account;
import View.Menu;

public class UpdatePasswordAccount {
    public static void execute(String password, String login, Database database) {
        Account[] accounts = database.getAccounts();
        if (!database.isEmpty()) {
            for (int i = 0; i < accounts.length; i++) {
                if (Objects.equals(accounts[i].getLogin(), login)) {
                    accounts[i].setPassword(password);
                    Menu.printUpdateAccountPassword();
                    return;
                }
            }
        } else {
            throw new RuntimeException("Não existe usuário cadastrado para atualizar");
        }
    }
}
