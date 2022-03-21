package Model;

import java.util.Scanner;
public class Account {
    protected String login;
    protected String name;
    protected String password;

    public void signUp (){
        Scanner read = new Scanner(System.in);
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

    public Account (String login, String name, String password) {
        this.login = login;
        this.name = name;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
