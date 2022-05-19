package Controller.useCases.interactionsUseCases;

import java.util.Objects;
import java.util.Scanner;

import Controller.Database.Database;

public class SendMessage {

    public static void execute(int positionUser, String nameFriend, Database database) {
        Scanner sc = new Scanner(System.in);
        int indiceFriend = 0;
        System.out.println("-- Escreva a mensagem que deseja enviar a " + nameFriend);
        String message = sc.nextLine();
        for (int j = 0; j < database.accounts.length; j++) {
            if (Objects.equals(database.accounts[j].getLogin(), nameFriend)) {
                indiceFriend = j;
            }
        }
        if (database.accounts[indiceFriend].getMessageList() == null) {
            String[] listMessages = new String[1];
            String[] listWriters = new String[1];
            listMessages[0] = message;
            listWriters[0] = database.accounts[positionUser].getName();
            database.accounts[indiceFriend].setMessageList(listMessages);
            database.accounts[indiceFriend].setMessageWriters(listWriters);
            System.out.println("- Mensagem enviada a " + nameFriend + " -");
        } else {
            String[] listMessages = new String[database.accounts[indiceFriend].getMessageList().length + 1];
            String[] listWriters = new String[database.accounts[indiceFriend].getMessageWriters().length + 1];
            for (int i = 0; i < database.accounts[indiceFriend].getMessageList().length; i++) {
                listMessages[i] = database.accounts[indiceFriend].getMessageList()[i];
                listWriters[i] = database.accounts[indiceFriend].getMessageWriters()[i];
            }
            listMessages[database.accounts[indiceFriend].getMessageList().length] = message;
            listWriters[database.accounts[indiceFriend].getMessageWriters().length] = database.accounts[positionUser]
                    .getName();
            database.accounts[indiceFriend].setMessageList(listMessages);
            database.accounts[indiceFriend].setMessageWriters(listWriters);
            System.out.println("- Mensagem enviada a " + nameFriend + " -");
        }
    }
}
