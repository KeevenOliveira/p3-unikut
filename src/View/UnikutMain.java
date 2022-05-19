package View;

import java.util.Scanner;

import Controller.AccountController;
import Controller.Database.Database;
import Controller.useCases.*;
import Controller.useCases.accountUseCases.GetUserByLogin;
import Controller.useCases.accountUseCases.LoginAlreadyExists;
import Controller.useCases.accountUseCases.LoginAndPasswordAlreadyExists;
import Controller.useCases.networkUseCases.*;
import Model.Account;

public class UnikutMain {
    public static void main(String[] args) {
        Database database = new Database();
        try (Scanner read = new Scanner(System.in)) {
            System.out.println("**** Bem vindo(a) ao Unikut! ****");
            do {
                Menu.printMenuSignInAndSignUp();

                int selected = read.nextInt();

                if (selected == 1) {
                    boolean verifyPass;
                    boolean verifyLogin;
                    String loginSession;
                    String login;
                    Account user;
                    try {
                        System.out.println("-------------------");
                        System.out.print("Digite o seu login: ");
                        loginSession = read.next();

                        do {
                            System.out.println("-------------------");
                            System.out.print("Digite sua senha: ");
                            String password = read.next();
                            verifyPass = LoginAndPasswordAlreadyExists.verify(loginSession, password, database);
                            if (!verifyPass) {
                                throw new RuntimeException("Login ou senha incorretos!");
                            }

                        } while (!verifyPass);
                        user = GetUserByLogin.execute(loginSession, database);

                        System.out.println(" ");
                        System.out.println("Bem vindo(a), " + user.getName() + "!");

                        boolean session = true;
                        do {
                            Menu.printMenuSignIn();
                            int selectedOptionSignIn = read.nextInt();
                            String nameFriend;
                            switch (selectedOptionSignIn) {
                                case 1: {
                                    System.out.println("-----------------------");
                                    System.out.print("Digite seu novo nome: ");
                                    String newName = read.next();
                                    System.out.println("-----------------------");
                                    AccountController.updateName(newName, loginSession, database);
                                }
                                case 2: {
                                    System.out.println("-------------------------");
                                    System.out.println("Digite sua nova senha: ");
                                    String newPassword = read.next();
                                    System.out.println("--------------------------");
                                    AccountController.updatePassword(newPassword, loginSession, database);
                                }
                                case 3: {
                                    boolean verify;
                                    try {
                                        do {
                                            System.out.println("---------------------");
                                            System.out.println("Digite o login do usuário a ser encontrado: ");
                                            nameFriend = read.next();
                                            verify = VerifyUserFriend.execute(login, nameFriend, database);

                                            if (verify) {
                                                VerifyInvited.execute(verifyLogin, nameFriend, database);
                                            }

                                            System.out.println(" ");
                                        } while (!verify);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                case 4:
                                    ListingFriends.execute(verifyLogin, database);

                                case 5:
                                    VerifyPendingInvitations.execute(verifyLogin, database);

                                case 6:
                                    ListingMessages.execute(verifyLogin, database);

                                case 7:
                                    session = false;
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
                            System.out.println("-----------------------");
                            System.out.println("Crie seu login: ");
                            login = read.next();

                            verifyTwo = LoginAlreadyExists.verify(login, database);

                            if (verifyTwo) {
                                throw new RuntimeException("Já existe usuário com este login!");
                            }

                        } while (verifyTwo);
                        System.out.println("------------------------");
                        System.out.print("Digite seu nome: ");
                        String name = read.next();

                        if (name.trim().equals("")) {
                            name = "Convidado";
                        }

                        System.out.println("----------------------");
                        System.out.print("Crie uma senha: ");
                        String password = read.next();

                        Account user = new Account(login, name, password);
                        AccountController.createNewAccount(user, database);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (selected == 3) {
                    System.out.println(" ");
                    System.out.println("Até a próxima!");
                    System.out.println("*** Sessão encerrada! ***");
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