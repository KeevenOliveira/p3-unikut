package Controller.useCases.networkUseCases;

import Controller.Database.Database;
import Model.*;
import View.Menu;

public class ListingMessages {
    public static void execute(int positionUser, Database database) {
        Account[] accounts = database.getAccounts();
        if (accounts[positionUser].getMessageList() == null) {
            Menu.printNotPosts();
        } else {
            for (int i = 0; i < accounts[positionUser].getMessageList().length; i++) {
                System.out.println("** Mensagem " + (i + 1) + " **");
                System.out.println(accounts[positionUser].getMessageList()[i]);
                System.out.println("-- Enviada por: " + accounts[positionUser].getMessageWriters()[i]);
                System.out.println("---------------------------------------------");
            }
        }
    }
}
