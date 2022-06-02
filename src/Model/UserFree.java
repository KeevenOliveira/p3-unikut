package Model;

public class UserFree extends Account {

    public UserFree(String login, String name, String password) {
        super();
        this.login = login;
        this.name = name;
        this.password = password;
        code = "free";
    }

}