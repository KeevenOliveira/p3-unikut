package View;

import java.util.Scanner;

import Controller.*;
import Controller.Database.Database;
import Controller.useCases.*;
import Model.Account;

public class UnikutMain {
    public static void main(String[] args) {
        // Design Pattern: Singleton Here
        Database database = Database.getInstance(null);
        try (Scanner read = new Scanner(System.in)) {
            Menu.printWelcome();
            do {
                Menu.printMenuSignInAndSignUp();

                int selected = read.nextInt();

                if (selected == 1) {
                    boolean verifyPass;
                    int position = 0;
                    String loginSession;
                    Account user;
                    try {

                        do {
                            Menu.printEnterYourLogin();
                            loginSession = read.next();
                            Menu.printEnterYourPassword();
                            String password = read.next();
                            verifyPass = AccountController.loginAndPasswordAlreadyExists(loginSession, password,
                                    database);
                            if (!verifyPass) {
                                throw new RuntimeException("Login ou senha incorretos!");
                            }

                        } while (!verifyPass);
                        user = AccountController.getUserByLogin(loginSession, database);

                        position = AccountController.getPositionByLogin(loginSession, database);

                        Menu.printWelcomeSignIn(user.getName());

                        boolean session = true;
                        do {
                            Menu.printMenuSignIn();
                            int selectedOptionSignIn = read.nextInt();
                            String nameFriend;
                            switch (selectedOptionSignIn) {
                                case 1: {
                                    Menu.printEnterYourName();
                                    String newName = read.next();
                                    Menu.printLine();
                                    AccountController.updateName(newName, loginSession, database);
                                    break;
                                }
                                case 2: {
                                    Menu.printEnterNewPassword();
                                    String newPassword = read.next();
                                    Menu.printLine();
                                    AccountController.updatePassword(newPassword, loginSession, database);
                                    break;
                                }
                                case 3: {
                                    boolean verify;
                                    try {
                                        do {
                                            Menu.printSearchUserByLogin();
                                            nameFriend = read.next();
                                            verify = InteractionsController.verifyUserFriend(loginSession, nameFriend,
                                                    database);

                                            if (verify) {
                                                NetworkController.verifyInvited(position, nameFriend, database);
                                            }

                                            Menu.printLine();
                                        } while (!verify);
                                        break;
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                case 4:
                                    NetworkController.listingFriends(position, database);
                                    break;
                                case 5:
                                    NetworkController.verifyPendingInvitations(position, database);
                                    break;
                                case 6:
                                    NetworkController.listingMessages(position, database);
                                    break;
                                case 7:
                                    session = false;
                                    break;
                            }
                        } while (session);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (selected == 2) {
                    try {
                        boolean verifyTwo;
                        String login;
                        do {
                            Menu.printCreateYourLogin();
                            login = read.next();

                            verifyTwo = AccountController.loginAlreadyExists(login, database);

                            if (verifyTwo) {
                                throw new RuntimeException("Já existe usuário com este login!");
                            }

                        } while (verifyTwo);
                        Menu.printEnterYourName();
                        String name = read.next();

                        if (name.trim().equals("")) {
                            name = "Convidado";
                        }

                        Menu.printCreateYourPassword();
                        String password = read.next();

                        Account user = new Account(login, name, password);
                        AccountController.createNewAccount(user, database);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (selected == 3) {
                    Menu.printExit();
                    break;
                } else {
                    try {
                        throw new RuntimeException("Opção inválida");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}