package Controller.useCases.accountUseCases;

import java.util.Objects;
import View.Menu;

import Controller.Database.Database;

public class UpdateNameAccount {
    public static void execute(String name, String login, Database database){
        if(!database.isEmpty()){
            for(int i = 0; i < database.size(); i++) {
                if(Objects.equals(database.accounts[i].getLogin(), login)){
                    database.accounts[i].setName(name);
                    Menu.printUpdateAccountName();
                    return;
                }
            }
        }else{
            throw new RuntimeException("Não existe usuário cadastrado para atualizar");
        }
    }
}
