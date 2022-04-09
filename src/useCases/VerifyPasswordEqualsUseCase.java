package useCases;

import Database.Database;

import java.util.Objects;

public class VerifyPasswordEqualsUseCase {
    public static boolean verify (String login, String password, Database database){
        if(database.isEmpty()){
            return false;
        }else{
            for(int i = 0; i < database.getAccounts().length; i++){
                if(Objects.equals(database.accounts[i].getLogin(), login) && Objects.equals(database.accounts[i].getLogin(), login)){
                    System.out.println("Login ou senha incorretos");
                    return true;
                }
            }
        }
        return false;
    }
}
