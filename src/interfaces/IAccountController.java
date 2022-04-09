package interfaces;

import Model.Account;

public interface IUserController {
    public Account getAccount(String login);
    public Account updateName(String name, String login);
    public void createNewAccount(Account account);
}
