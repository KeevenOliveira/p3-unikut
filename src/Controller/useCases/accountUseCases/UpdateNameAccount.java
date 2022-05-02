package Controller.useCases.accountUseCases;

import Model.Account;
import java.util.Objects;
import View.Menu;

import Controller.Database.Database;

public class UpdateNameAccount {
    public static void execute(String name, String login, Database database){
        if(!database.isEmpty()){
            for(int i = 0; i < database.accounts.length; i++) {
                if(Objects.equals(database.accounts[i].getLogin(), login)){
                    database.accounts[i].setName(name);
                    Menu.printMenuAcceptFriend();
                    return;
                }
            }
        }
    }
}
