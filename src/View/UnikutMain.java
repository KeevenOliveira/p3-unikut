package View;

import java.util.Scanner;

import Controller.*;
import Controller.Database.Database;
import Controller.useCases.*;
import Controller.useCases.accountUseCases.*;
import Controller.useCases.networkUseCases.*;
import Model.Account;

public class UnikutMain {
    public static void main(String[] args) {
        // Design Pattern: Singleton Here
        Account adminAccount = new Account("admin", "admin", "admin");
        Account[] accounts = {adminAccount};
        Database database = Database.getInstance(accounts);
        
        try (Scanner read = new Scanner(System.in)) {
            Menu.printWelcome();
            do {
                Menu.printMenuSignInAndSignUp();

                int selected = read.nextInt();

                if (selected == 1) {
                    boolean verifyPass;
                    int position = 0;
                    String loginSession;
                    String password;
                    Account user;
                    try {

                        do {
                            Menu.printEnterYourLogin();
                            loginSession = read.next();
                            Menu.printEnterYourPassword();
                            password = read.next();
                            verifyPass = LoginAndPasswordAlreadyExists.verify(loginSession, password, database);
                            if (!verifyPass) {
                                throw new RuntimeException("Login ou senha incorretos!");
                            }

                        } while (!verifyPass);
                        user = GetUserByLogin.execute(loginSession, database);

                        try {
                            Thread.sleep(500);
                            position = GetAccountPosition.execute(loginSession, database);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        Menu.printWelcomeSignIn(user.getName());

                        boolean session = true;
                        do {
                            Menu.printMenuSignIn();
                            int selectedOptionSignIn = read.nextInt();
                            String nameFriend;

                            if(loginSession == "admin" && password == "admin"){
                                Menu.printAdmin(sizeDatabase);

                            } else{
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
                                                verify = VerifyUserFriend.execute(loginSession, nameFriend, database);

                                                if (verify) {
                                                    VerifyInvited.execute(position, nameFriend, database);
                                                }

                                                Menu.printLine();
                                            } while (!verify);
                                            break;
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    case 4:
                                        ListingFriends.execute(position, database);
                                        break;
                                    case 5:
                                        VerifyPendingInvitations.execute(position, database);
                                        break;
                                    case 6:
                                        ListingMessages.execute(position, database);
                                        break;
                                    case 7:
                                        session = false;
                                        break;

                                }
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

                            verifyTwo = LoginAlreadyExists.verify(login, database);

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