package View;

import java.util.Scanner;

import Model.UserController;

public class UnikutMain {
    public static void main(String[] args) {

        try (Scanner read = new Scanner(System.in)) {

            System.out.println("Digite uma das opções: ");
            System.out.println("1 - Login");
            System.out.println("2 - Cadastrar");

            int selected = read.nextInt();

            if(selected == 1){
                System.out.println("-------------------");

                System.out.print("Digite o seu login: ");
                String login = read.next();

                System.out.println("-------------------");

                System.out.print("Digite sua senha: ");
                String password = read.next();

            }else if( selected == 2){
                Boolean verify;
                do{
                    System.out.println("-----------------------");
                    System.out.println("Crie seu login: ");
                    String login = read.next();
    
                    verify = UserController.verify(login);
                }while(!verify);
                System.out.println("------------------------");
                System.out.println("Digite seu nome: ");
                
                String name = read.next();

                System.out.println("----------------------");

                System.out.println("Crie uma senha:");
                String password = read.next();

                System.out.println("----------------------");
                
            }
        }
    }
}