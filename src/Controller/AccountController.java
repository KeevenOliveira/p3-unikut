package Controller;

import Model.Account;
import Interfaces.IAccountController;

import java.util.Objects;

import Controller.Database.Database;
import Controller.useCases.accountUseCases.*;

public class AccountController implements IAccountController {

    public static void updateName(String name, String login, Database database) {
        
    }

    public static void createNewAccount(Account account, Database database) {
        CreateAccount.execute(account, database);
    }

    public static void updatePassword(String password, String login, Database database) {
        for(int i = 0; i < database.accounts.length; i++){
            if(Objects.equals(database.accounts[i].getLogin(), login)){
                database.accounts[i].setPassword(password);
                System.out.println("Senha alterada com sucesso!");
                System.out.println("-------------------------");
                return;
            }
        }
    }
}