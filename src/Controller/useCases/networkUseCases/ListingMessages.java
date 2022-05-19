package Controller.useCases.networkUseCases;

import Controller.Database.Database;
import View.Menu;

public class ListingMessages {
    public static void execute(int positionUser, Database database) {
        if (database.accounts[positionUser].getMessageList() == null) {
            Menu.printNotPosts();
        } else {
            for (int i = 0; i < database.accounts[positionUser].getMessageList().length; i++) {
                System.out.println("** Mensagem " + (i + 1) + " **");
                System.out.println(database.accounts[positionUser].getMessageList()[i]);
                System.out.println("-- Enviada por: " + database.accounts[positionUser].getMessageWriters()[i]);
                System.out.println("---------------------------------------------");
            }
        }
    }
}
