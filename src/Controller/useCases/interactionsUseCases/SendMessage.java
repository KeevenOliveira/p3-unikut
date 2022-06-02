package Controller.useCases.interactionsUseCases;

import java.util.Objects;
import java.util.Scanner;

import Controller.Database.Database;
import Model.*;

public class SendMessage {

    public static void execute(int positionUser, String nameFriend, Database database) {
        Scanner sc = new Scanner(System.in);
        int indiceFriend = 0;
        Account[] accounts = database.getAccounts();
        System.out.println("-- Escreva a mensagem que deseja enviar a " + nameFriend);
        String message = sc.nextLine();
        for (int j = 0; j < accounts.length; j++) {
            if (Objects.equals(accounts[j].getLogin(), nameFriend)) {
                indiceFriend = j;
            }
        }
        if (accounts[indiceFriend].getMessageList() == null) {
            String[] listMessages = new String[1];
            String[] listWriters = new String[1];
            listMessages[0] = message;
            listWriters[0] = accounts[positionUser].getName();
            accounts[indiceFriend].setMessageList(listMessages);
            accounts[indiceFriend].setMessageWriters(listWriters);
            System.out.println("- Mensagem enviada a " + nameFriend + " -");
        } else {
            String[] listMessages = new String[accounts[indiceFriend].getMessageList().length + 1];
            String[] listWriters = new String[accounts[indiceFriend].getMessageWriters().length + 1];
            for (int i = 0; i < accounts[indiceFriend].getMessageList().length; i++) {
                listMessages[i] = accounts[indiceFriend].getMessageList()[i];
                listWriters[i] = accounts[indiceFriend].getMessageWriters()[i];
            }
            listMessages[accounts[indiceFriend].getMessageList().length] = message;
            listWriters[accounts[indiceFriend].getMessageWriters().length] = accounts[positionUser]
                    .getName();
            accounts[indiceFriend].setMessageList(listMessages);
            accounts[indiceFriend].setMessageWriters(listWriters);
            System.out.println("- Mensagem enviada a " + nameFriend + " -");
        }
    }
}
