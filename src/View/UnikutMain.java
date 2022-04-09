package View;

import java.util.Scanner;

import Database.Database;
import Model.Account;
import useCases.EmailAlreadyExistsUseCase;

public class UnikutMain {
    public static void main(String[] args) {
        Database database = new Database();
            try (Scanner read = new Scanner(System.in)) {
                do{
                    Menu.printMenuSignInAndSignUp();

                    int selected = read.nextInt();

                    if(selected == 1){
                        boolean verify;
                        String login;
                        do{
                            System.out.println("-------------------");

                            System.out.print("Digite o seu login: ");
                            login = read.next();
                            verify= EmailAlreadyExistsUseCase.verify(login, database);

                        }while(verify);

                        System.out.println("-------------------");

                        System.out.print("Digite sua senha: " );
                        String password = read.next();
                        
                        boolean session = true;
                        do{
                            Menu.printMenuSignIn();

                        }while(session);

                    }else if( selected == 2){
                        boolean verify ;
                        String login;
                        do{
                            System.out.println("-----------------------");
                            System.out.println("Crie seu login: ");
                            login = read.next();

                            verify = EmailAlreadyExistsUseCase.verify(login, database);
                        }while(verify);

                        System.out.println("------------------------");
                        System.out.print("Digite seu nome: ");

                        String name = read.next();

                        System.out.println("----------------------");

                        System.out.print("Crie uma senha: ");
                        String password = read.next();

                        System.out.println("----------------------");
                        Account user = new Account(login, name, password);
                        database.setAccount(user);
                    }
                }while(true);
            }
    }
}