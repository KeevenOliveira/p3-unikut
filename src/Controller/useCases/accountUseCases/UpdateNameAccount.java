package Controller.useCases.accountUseCases;

import java.util.Objects;
import View.Menu;

import Controller.Database.Database;
import Model.*;

public class UpdateNameAccount {
    public static void execute(String name, String login, Database database) {
        Account[] accounts = database.getAccounts();
        if (!database.isEmpty()) {
            for (int i = 0; i < database.size(); i++) {
                if (Objects.equals(accounts[i].getLogin(), login)) {
                    accounts[i].setName(name);
                    Menu.printUpdateAccountName();
                    return;
                }
            }
        } else {
            throw new RuntimeException("Não existe usuário cadastrado para atualizar");
        }
    }
}
