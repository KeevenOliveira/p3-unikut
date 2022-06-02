package Model;

public class UserPremium extends Account {

    public UserPremium(String login, String name, String password) {
        super();
        this.login = login;
        this.name = name;
        this.password = password;
        code = "premium";
    }

}