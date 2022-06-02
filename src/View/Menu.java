package View;

import Controller.Database.Database;
import Model.Account;

public class Menu {

    public static void printWelcome() {
        System.out.println("**** Bem vindo(a) ao Unikut! ****");
    }

    public static void printAccountCreated() {
        System.out.println("----------------------");
        System.out.println("Usuário criado com sucesso!");
        System.out.println("----------------------");
    }

    public static void printUpdateAccountPassword() {
        System.out.println("-------------------------");
        System.out.println("Senha alterada com sucesso!");
        System.out.println("-------------------------");
    }

    public static void printWelcomeSignIn(String name) {
        System.out.println(" ");
        System.out.println("Bem vindo(a), " + name + "!");
    }

    public static void printEnterYourLogin() {
        System.out.println("-------------------");
        System.out.print("Digite o seu login: ");
    }

    public static void printEnterNewPassword() {
        System.out.println("-------------------");
        System.out.print("Digite a nova senha: ");
    }

    public static void printLine() {
        System.out.println("---------------------");
    }

    public static void printSearchUserByLogin() {
        System.out.println("---------------------");
        System.out.println("Digite o login do usuário a ser encontrado: ");
    }

    public static void printEnterYourName() {
        System.out.println("-------------------");
        System.out.print("Digite seu nome: ");
    }

    public static void printCreateYourLogin() {
        System.out.println("-------------------");
        System.out.print("Crie seu login: ");
    }

    public static void printCreateYourPassword() {
        System.out.println("-------------------");
        System.out.print("Crie sua senha: ");
    }

    public static void printEnterYourPassword() {
        System.out.println("-------------------");
        System.out.print("Digite sua senha: ");
    }

    public static void printFriendAccepted(String nameFriend) {
        System.out.println(" ");
        System.out.println(nameFriend + " foi aceito como amigo.");
        System.out.println("Agora vocês podem interagir! O que deseja fazer agora?");
    }

    public static void printUpdateAccountName() {
        System.out.println("-------------------------");
        System.out.println("Nome do usuário atualizado com sucesso!");
        System.out.println("-------------------------");
    }

    public static void printMenuSignInAndSignUp() {
        System.out.println("\n--- Menu Principal ---");
        System.out.println("1 - Login");
        System.out.println("2 - Cadastrar novo usuário Free");
        System.out.println("3 - Cadastrar novo usuário Premium");
        System.out.println("4 - Sair do Unikut");
        System.out.println("--> Digite uma das opções: ");
    }

    public static void printMenuSignInFree() {
        System.out.println("\n--- Menu Usuário Free ---");
        System.out.println("1 - Atualizar nome");
        System.out.println("2 - Atualizar password");
        System.out.println("3 - Procurar usuário");
        System.out.println("4 - Ver lista de amigos");
        System.out.println("5 - Solicitação de amizades pendentes");
        System.out.println("6 - Logout");
        System.out.println("--> O que deseja fazer agora? ");

    }
    public static void printMenuSignInPremium() {
        System.out.println("\n--- Menu Usuário Premium ---");
        System.out.println("1 - Atualizar nome");
        System.out.println("2 - Atualizar password");
        System.out.println("3 - Procurar usuário");
        System.out.println("4 - Ver lista de amigos");
        System.out.println("5 - Solicitação de amizades pendentes");
        System.out.println("6 - Ler mensagens recebidas");
        System.out.println("7 - Logout");
        System.out.println("--> O que deseja fazer agora? ");
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
        System.out.println("Deseja aceitar alguns deles como amigo?");
        System.out.println("1 - Aceitar amizade");
        System.out.println("2 - Voltar para o menu anterior");
    }

    public static void printUpdateName() {
        System.out.println("Nome alterado com sucesso!");
        System.out.println("-------------------------");
    }

    public static void printPendingFriendship() {
        System.out.println("Status de amizade: PENDENTE");
        System.out.println("Aguarde resposta");
    }

    public static void printNotFriends() {
        System.out.println("Vocês não são amigos\n");
    }

    public static void printFriends() {
        System.out.println("Status de amizade: AMIGOS\n");
    }

    public static void printPendingInv() {
        System.out.println("\nUsuários que você solicitou amizade:");
    }

    public static void printWaitInv() {
        System.out.println("Aguarde ele(a)(s) responder(em) sua solicitação para interagir!");
    }

    public static void printNeverUser() {
        System.out.println("- Nenhum usuário -");
    }

    public static void printPendingRequests() {
        System.out.println("---------------");
        System.out.println("Usuários que solicitaram sua amizade:");
    }

    public static void printYourFriends() {
        System.out.println("\n--- Seus amigos ---");
    }

    public static void printNotYourFriends() {
        System.out.println("Você ainda não tem amigos adicionados");
    }

    public static void printNotPosts() {
        System.out.println("\nVocê não tem nenhuma mensagem");
    }

    public static void printExit() {
        System.out.println(" ");
        System.out.println("Até a próxima!");
        System.out.println("\nObrigado por utilizar o Unikut!");
        System.out.println("*** Sessão encerrada! ***");
    }

    public static void printAdmin(int sizeDatabase, Account[] accounts) {
        System.out.println("Quantidade de contas cadastradas: " + sizeDatabase);
        System.out.println("\n--- Lista de contas ---");
        for(int i = 0; i < sizeDatabase; i++) {
            System.out.println("Nome: "+ accounts[i].getName() + "\nLogin: "+ accounts[i].getLogin() + "\nSenha: " +
                    accounts[i].getPassword() + "\nTipo de usuário: "+accounts[i].getCode());
            System.out.println("-------------------");
        }
    }
}