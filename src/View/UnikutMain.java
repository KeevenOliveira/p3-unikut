package View;

import java.util.Scanner;

import Controller.AccountController;
import Controller.Database.Database;
import Controller.Services.Network;
import Controller.useCases.*;
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
                        int verifyLogin;
                        String loginSession;
                        String login;
                        try{
                            do {
                                System.out.println("-------------------");
                                System.out.print("Digite o seu login: ");
                                login = read.next();
                                loginSession = login;
                                verifyLogin = VerifyPasswordEquals.verifyLogin(login, database);
        
                                if(verifyLogin == -1){
                                    throw new RuntimeException("Não existe usuário com este login :(");
                                }
        
                            } while (verifyLogin == -1);
        
                            do {
                                System.out.println("-------------------");
                                System.out.print("Digite sua senha: ");
                                String password = read.next();
                                verifyPass = VerifyPasswordEquals.verify(password, database, verifyLogin);
                                if(!verifyPass){
                                    throw new RuntimeException("Senha incorreta!");
                                }
    
                            } while (!verifyPass);
        
                            System.out.println(" ");
                            System.out.println("Bem vindo(a), "+database.accounts[verifyLogin].getName()+"!");
        
                            boolean session = true;
                            do {
                                Menu.printMenuSignIn();
                                int selectedOptionSignIn = read.nextInt();
                                String nameFriend;
                                switch (selectedOptionSignIn) {
                                    case 1 -> {
                                        System.out.println("-----------------------");
                                        System.out.print("Digite seu novo nome: ");
                                        String newName = read.next();
                                        System.out.println("-----------------------");
                                        AccountController.updateName(newName, loginSession, database);
                                    }
                                    case 2 -> {
                                        System.out.println("-------------------------");
                                        System.out.println("Digite sua nova senha: ");
                                        String newPassword = read.next();
                                        System.out.println("--------------------------");
                                        AccountController.updatePassword(newPassword, loginSession, database);
                                    }
                                    case 3 -> {
                                        boolean verify;
                                        try{
                                            do {
                                                System.out.println("---------------------");
                                                System.out.println("Digite o login do usuário a ser encontrado: ");
                                                nameFriend = read.next();
                                                verify = VerifyUserFriend.execute(login, nameFriend, database);
                                                
                                                if(verify) {
                                                    Network.verifyInvited(verifyLogin, nameFriend, database);
                                                }
                                                
                                                System.out.println(" ");
                                            } while (!verify);
                                        }catch(Exception e){
                                            e.printStackTrace();
                                        }
                                    }
                                    case 4 ->
                                        Network.listingFriends(verifyLogin, database);
        
                                    case 5 ->
                                        Network.verifyPendingInv(verifyLogin, database);
        
                                    case 6 ->
                                        Network.listingMessages(verifyLogin, database);
        
                                    case 7 -> session = false;
                                }
                            } while (session);
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    } else if (selected == 2) {
                        try{
                            boolean verifyTwo;
                            String login;
                            do {
                                System.out.println("-----------------------");
                                System.out.println("Crie seu login: ");
                                login = read.next();
        
                                verifyTwo = LoginAlreadyExists.verify(login, database);
        
                                if(verifyTwo){
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
                        }catch(Exception e){
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
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}