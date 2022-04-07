package Model;

import javax.xml.crypto.Data;

public class UserController {
    public static boolean verify(String login){
        for(int i = 0; i < Database.accounts.length; i++){
            if(Database.accounts[i].login == login){
                System.out.println("Esse login já existe");
                return true;
            }
        }
        return false;
    }
}
