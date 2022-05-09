package View;

public class Menu {

    public static void printAccountCreated(){
        System.out.println("----------------------");
        System.out.println("Usuário criado com sucesso!");
        System.out.println("----------------------");
    }

    public static void printUpdateAccountPassword(){
        System.out.println("-------------------------");
        System.out.println("Senha alterada com sucesso!");
        System.out.println("-------------------------");
    }

    public static void printUpdateAccountName(){
        System.out.println("-------------------------");
        System.out.println("Nome do usuário atualizado com sucesso!");
        System.out.println("-------------------------");
    }

    public static void printMenuSignInAndSignUp() {
        System.out.println(" ");
        System.out.println("--- Menu Principal ---");
        System.out.println("1 - Login");
        System.out.println("2 - Cadastrar novo usuário");
        System.out.println("3 - Sair do Unikut");
        System.out.println("--> Digite uma das opções: ");
    }

    public static void printMenuSignIn() {
        System.out.println(" ");
        System.out.println("--> O que deseja fazer agora? ");
        System.out.println("1 - Atualizar nome");
        System.out.println("2 - Atualizar password");
        System.out.println("3 - Procurar usuário");
        System.out.println("4 - Ver lista de amigos");
        System.out.println("5 - Solicitação de amizades pendentes");
        System.out.println("6 - Ler mensagens recebidas");
        System.out.println("7 - Logout");

    }

    public static void printMenuNoFriend() {
        System.out.println("1 - Enviar solicitação de amizade");
        System.out.println("2 - Voltar para o menu anterior");
    }

    public static void printMenuFriend() {
        System.out.println("1 - Enviar mensagem");
        System.out.println("2 - Voltar para o menu anterior");
    }

    public static void printMenuAcceptFriend() {
        System.out.println("1 - Aceitar amizade");
        System.out.println("2 - Voltar para o menu anterior");
    }

    public static void printUpdateName(){
        System.out.println("Nome alterado com sucesso!");
        System.out.println("-------------------------");
    }

}