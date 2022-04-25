package useCases;

import Database.Database;
import java.util.Objects;

public class LoginAlreadyExistsUseCase {

    public static boolean verify(String login, Database database) {
        if(database.isEmpty()) {
            return false;
        } else {
            for(int i = 0; i < database.getAccounts().length; i++) {
                if(Objects.equals(database.accounts[i].getLogin(), login)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean verifyUserFriend(String login, String nameFriend, Database database) throws RuntimeException {
        if (Objects.equals(login, nameFriend)) {
            throw new RuntimeException("Esse é o seu login!");
        } else {
            for (int i = 0; i < database.getAccounts().length; i++) {
                if (Objects.equals(database.accounts[i].getLogin(), nameFriend)) {
                    System.out.println(database.accounts[i].getName());
                    return true;
                }
            }
        }
        throw new RuntimeException("Usuário não encontrado!");
    }
}