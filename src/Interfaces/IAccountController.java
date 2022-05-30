package Interfaces;

import Controller.Database.Database;
import Model.Account;

public interface IAccountController {
    public static void updateName(String name, String login, Database database) {
    };

    public static void createNewAccount(Account account, Database database) {
    };

    public static int getPositionByLogin(String login, Database database) {
        return 0;
    };

    public static Account getUserByLogin(String login, Database database) {
        return null;
    };

    public static boolean LoginAndPasswordAlreadyExists(String login, String password, Database database) {
        return false;
    };

    public static void LoginAlreadyExists(String login, Database database) {
    };

    public static void updatePassword(String password, String login, Database database) {
    }
}
