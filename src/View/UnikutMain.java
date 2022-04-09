package View;

import java.util.Scanner;

import Database.Database;
import Model.Account;
import useCases.EmailAlreadyExistsUseCase;
import useCases.VerifyPasswordEqualsUseCase;

public class UnikutMain {
    public static void main(String[] args) {
        Database database = new Database();
            try (Scanner read = new Scanner(System.in)) {
                do{
                    Menu.printMenuSignInAndSignUp();

                    int selected = read.nextInt();
                    switch (selected){
                        case 1:
                            boolean verifyOne;
                            do{
                                System.out.println("-------------------");

                                System.out.print("Digite o seu login: ");
                                String login = read.next();

                                System.out.println("-------------------");

                                System.out.print("Digite sua senha: " );
                                String password = read.next();
                                verifyOne = VerifyPasswordEqualsUseCase.verify(login, password, database);
                            }while(!verifyOne);
                            boolean session = false;
                            do{
                                Menu.printMenuSignIn();
                                int selectedOptionSignIn = read.nextInt();
                                switch (selectedOptionSignIn){
                                    case 1:
                                        System.out.println("-----------------------");
                                        System.out.print("Digite seu novo nome de usuário:");
                                        String newName = read.next();

                                }

                            }while(session);
                            break;
                        case 2:
                            boolean verifyTwo;
                            String login;
                            do{
                                System.out.println("-----------------------");
                                System.out.println("Crie seu login: ");
                                login = read.next();

                                verifyTwo = EmailAlreadyExistsUseCase.verify(login, database);
                            }while(verifyTwo);

                            System.out.println("------------------------");
                            System.out.print("Digite seu nome: ");

                            String name = read.next();

                            System.out.println("----------------------");

                            System.out.print("Crie uma senha: ");
                            String password = read.next();

                            System.out.println("----------------------");
                            Account user = new Account(login, name, password);
                            database.setAccount(user);
                            break;
                    }
                }while(true);
            }
    }
}