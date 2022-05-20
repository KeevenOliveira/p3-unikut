package Controller;

import Model.Account;
import Interfaces.IAccountController;

import Controller.Database.Database;
import Controller.useCases.accountUseCases.*;

public class AccountController implements IAccountController {

    public static void updateName(String name, String login, Database database) {
        UpdateNameAccount.execute(name, login, database);
    }

    public static void createNewAccount(Account account, Database database) {
        CreateAccount.execute(account, database);
    }

    public static void updatePassword(String password, String login, Database database) {
        UpdatePasswordAccount.execute(password, login, database);
    }
}