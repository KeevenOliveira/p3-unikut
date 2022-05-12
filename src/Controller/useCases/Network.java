package Controller.useCases;

import View.Menu;

import java.util.Objects;
import java.util.Scanner;

import Controller.Database.Database;

public class Network {

    public static void verifyInvited(int positionUser, String nameFriend, Database database) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        if(database.accounts[positionUser].getInvited() == null) {
            verifyInvitations(positionUser, nameFriend, database);
        } else {
            for (int i = 0; i < database.accounts[positionUser].getInvited().length; i++) {
                if (Objects.equals(database.accounts[positionUser].getInvited()[i], nameFriend)) {
                    System.out.println(nameFriend + " convidou você para serem amigos");
                    System.out.println(" ");
                    count = 1;
                    Menu.printMenuAcceptFriend();
                    int select = sc.nextInt();
                    if (select == 1) {
                        Interactions.acceptFriendship(positionUser, nameFriend, database);
                    }
                }
            }
            if (count < 1) {
                verifyInvitations(positionUser, nameFriend, database);
            }
        }
        count = 0;
    }

    public static void verifyInvitations(int positionUser, String nameFriend, Database database) {
        int cont = 0;
        if(database.accounts[positionUser].getInvitations() == null) {
            verifyFriendship(positionUser, nameFriend, database);
        } else {
            for (int j = 0; j < database.accounts[positionUser].getInvitations().length; j++) {
                if (Objects.equals(database.accounts[positionUser].getInvitations()[j], nameFriend)) {
                    Menu.printPendigFriendship();
                    cont = 1;
                }
            }
            if (cont < 1) {
                verifyFriendship(positionUser, nameFriend, database);
            }
        }
        cont = 0;
    }

    public static void verifyFriendship(int positionUser, String nameFriend, Database database) {
        Scanner sc = new Scanner(System.in);
        int cont = 0;
        if (database.accounts[positionUser].getFriends() == null) {
            Menu.printNotFriends();
            Menu.printMenuNoFriend();
            int select = sc.nextInt();
            if (select == 1) {
                Interactions.addFriend(positionUser, nameFriend, database);
            }
        } else {
            for (int k = 0; k < database.accounts[positionUser].getFriends().length; k++) {
                if (Objects.equals(database.accounts[positionUser].getFriends()[k], nameFriend)) {
                    Menu.printFriends();
                    Menu.printMenuFriend();
                    int selected = sc.nextInt();
                    if(selected == 1) {
                        Interactions.sendMessage(positionUser, nameFriend, database);
                    }
                    cont = 1;
                }
            }
            if (cont < 1) {
                Menu.printNotFriends();
                Menu.printMenuNoFriend();
                int select = sc.nextInt();
                if (select == 1) {
                    Interactions.addFriend(positionUser, nameFriend, database);
                }
            }
        }
        cont = 0;
    }

    public static void verifyPendingInv(int positionUser, Database database) {
        Scanner sc = new Scanner(System.in);
        Menu.printPendingInv();
        int cont = 0;
        if (database.accounts[positionUser].getInvitations() == null) {
            Menu.printNeverUser();
        } else {
            for (int i = 0; i < database.accounts[positionUser].getInvitations().length; i++) {
                if (database.accounts[positionUser].getInvitations()[i] != null) {
                    System.out.println(database.accounts[positionUser].getInvitations()[i]);
                    cont++;
                }
            }
            if (cont != 0) {
                Menu.printWaitInv();
            } else {
                Menu.printNeverUser();
            }
        }
        Menu.printPendingRequests();
        cont = 0;
        if (database.accounts[positionUser].getInvited() == null) {
            Menu.printNeverUser();
        } else {
            for (int i = 0; i < database.accounts[positionUser].getInvited().length; i++) {
                if (database.accounts[positionUser].getInvited()[i] != null) {
                    System.out.println(database.accounts[positionUser].getInvited()[i]);
                    cont++;
                }
            }
            if (cont != 0) {
                Menu.printMenuAcceptFriend();
                int selected = sc.nextInt();
                if (selected == 1) {
                    String nameUser = sc.next();
                    Interactions.acceptFriendship(positionUser, nameUser, database);
                }
            } else {
                Menu.printNeverUser();
            }
        }
        System.out.println("---------------");
    }
    public static void listingFriends(int positionUser, Database database) {
        Menu.printYourFriends();
        if (database.accounts[positionUser].getFriends() == null) {
            Menu.printNotYourFriends();
        } else {
            for (int i = 0; i < database.accounts[positionUser].getFriends().length; i++) {
                System.out.println(database.accounts[positionUser].getFriends()[i]);
            }
        }
        System.out.println("----------------");
    }
    public static void listingMessages(int positionUser, Database database) {
        if (database.accounts[positionUser].getMessageList() == null) {
            Menu.printNotPosts();
        } else {
            for (int i = 0; i < database.accounts[positionUser].getMessageList().length; i++) {
                System.out.println("** Mensagem "+(i+1)+" **");
                System.out.println(database.accounts[positionUser].getMessageList()[i]);
                System.out.println("-- Enviada por: "+database.accounts[positionUser].getMessageWriters()[i]);
                System.out.println("---------------------------------------------");
            }
        }
    }
}
