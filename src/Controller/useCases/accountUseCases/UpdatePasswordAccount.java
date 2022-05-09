package Controller.useCases.accountUseCases;

import java.util.Objects;
import Controller.Database.Database;
import View.Menu;

public class UpdatePasswordAccount {
    public static void execute(String password, String login, Database database){
        if(!database.isEmpty()){
            for(int i = 0; i < database.size(); i++) {
                if(Objects.equals(database.accounts[i].getLogin(), login)){
                    database.accounts[i].setPassword(password);
                    Menu.printUpdateAccountPassword();
                    return;
                }
            }
        }else{
            throw new RuntimeException("Não existe usuário cadastrado para atualizar");
        }
    }
}
