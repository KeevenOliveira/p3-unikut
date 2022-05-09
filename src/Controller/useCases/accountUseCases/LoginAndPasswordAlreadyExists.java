package Controller.useCases.accountUseCases;

import Controller.Database.Database;

public class LoginAndPasswordAlreadyExists {
    public static boolean verify(String login, String password, Database database) {
        if(database.isEmpty()) {
            return false;
        } else {
            for(int i = 0; i < database.getAccounts().length; i++) {
                if(database.accounts[i].getLogin() == login && database.accounts[i].getPassword() == password) {
                    return true;
                }
            }
        }
        return false;
    }
}
