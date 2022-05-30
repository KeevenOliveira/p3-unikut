package Interfaces;
import Controller.Database.Database;
import Model.Account;

public interface IAccountController {
    public static void updateName(String name, String login, Database database){};
    public static void createNewAccount(Account account, Database database){};
    public static void updatePassword(String password, String login, Database database){}

    public static Account[] getAllAccounts(Database database){
        return database.getAccounts();
    };  
}
