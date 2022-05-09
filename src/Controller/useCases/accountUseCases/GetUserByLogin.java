package Controller.useCases.accountUseCases;

import Controller.Database.Database;
import Model.Account;

public class GetUserByLogin {
    public static Account execute(String login, Database database){
        for(int i = 0; i < database.size(); i++){
            if(database.accounts[i].getLogin() == login){
                return database.accounts[i];
            }
        }
        return null;
    }
}
