package Controller.useCases.interactionsUseCases;

import java.util.Objects;

import Controller.Database.Database;

public class AddFriend {
    public static void execute(int positionUser, String nameFriend, Database database) {
        int indiceFriend = 0;
        if (database.accounts[positionUser].getInvitations() == null) {
            String[] listInvite = new String[1];
            listInvite[0] = nameFriend;
            database.accounts[positionUser].setInvitations(listInvite);
            System.out.println(" ");
            System.out.println("Solicitação de amizade enviada a " + nameFriend);
            System.out.println("Aguarde resposta para interagir");
            for (int i = 0; i < database.accounts.length; i++) {
                if (Objects.equals(database.accounts[i].getLogin(), nameFriend)) {
                    indiceFriend = i;
                }
            }
            if (database.accounts[indiceFriend].getInvited() == null) {
                String[] listInvited = new String[1];
                listInvited[0] = database.accounts[positionUser].getLogin();
                database.accounts[indiceFriend].setInvited(listInvited);
            } else {
                String[] listInvited = new String[database.accounts[indiceFriend].getInvited().length + 1];
                for (int i = 0; i < database.accounts[indiceFriend].getInvited().length; i++) {
                    listInvited[i] = database.accounts[indiceFriend].getInvited()[i];
                }
                listInvited[database.accounts[indiceFriend].getInvited().length] = database.accounts[positionUser]
                        .getLogin();
                database.accounts[indiceFriend].setInvited(listInvited);
            }

        } else {
            String[] listInvite = new String[database.accounts[positionUser].getInvitations().length + 1];
            for (int i = 0; i < database.accounts[positionUser].getInvitations().length; i++) {
                listInvite[i] = database.accounts[positionUser].getInvitations()[i];
            }
            listInvite[database.accounts[positionUser].getInvitations().length] = nameFriend;
            database.accounts[positionUser].setInvitations(listInvite);
            System.out.println(" ");
            System.out.println("Solicitação de amizade enviada a " + nameFriend);
            System.out.println("Aguarde resposta para interagir");
            for (int i = 0; i < database.accounts.length; i++) {
                if (Objects.equals(database.accounts[i].getLogin(), nameFriend)) {
                    indiceFriend = i;
                }
            }
            if (database.accounts[indiceFriend].getInvited() == null) {
                String[] listInvited = new String[1];
                listInvited[0] = database.accounts[positionUser].getLogin();
                database.accounts[indiceFriend].setInvited(listInvited);
            } else {
                String[] listInvited = new String[database.accounts[indiceFriend].getInvited().length + 1];
                for (int i = 0; i < database.accounts[indiceFriend].getInvited().length; i++) {
                    listInvited[i] = database.accounts[indiceFriend].getInvited()[i];
                }
                listInvited[database.accounts[indiceFriend].getInvited().length] = database.accounts[positionUser]
                        .getLogin();
                database.accounts[indiceFriend].setInvited(listInvited);
            }
        }
    }
}
