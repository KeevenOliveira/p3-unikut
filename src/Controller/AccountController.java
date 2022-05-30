package Controller;

import Model.Account;
import Interfaces.IAccountController;

import Controller.Database.Database;
import Controller.useCases.accountUseCases.*;

public class AccountController implements IAccountController {
    public static int getPositionByLogin(String login, Database database) {
        return GetAccountPosition.execute(login, database);
    };

    public static Account getUserByLogin(String login, Database database) {
        return GetUserByLogin.execute(login, database);
    };

    public static boolean loginAndPasswordAlreadyExists(String login, String password, Database database) {
        return LoginAndPasswordAlreadyExists.verify(login, password, database);
    };

    public static boolean loginAlreadyExists(String login, Database database) {
        return LoginAlreadyExists.verify(login, database);
    };

    public static void updateName(String name, String login, Database database) {
        UpdateNameAccount.execute(name, login, database);
    }

    public static void createNewAccount(Account account, Database database) {
        CreateAccount.execute(account, database);
    }

    public static void updatePassword(String password, String login, Database database) {
        UpdatePasswordAccount.execute(password, login, database);
    }

    public static Account[] getAllAccounts(Database database){
        return GetAllAccounts.execute(database);
    }
}