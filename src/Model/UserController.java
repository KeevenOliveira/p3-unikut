package Model;
public class UserController {
    public static boolean verify(String login){
        for(int i = 0; i < Database.Accounts.length; i++){
            if(Database.Accounts[i].element().login == login){
                return true;
            }
        }
        return false;
    }
}
