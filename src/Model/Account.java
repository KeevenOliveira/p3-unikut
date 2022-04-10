package Model;

import java.util.Scanner;
public class Account {
    protected String login;
    protected String name;
    protected String password;

    public Account (String login, String name, String password) {
        this.login = login;
        this.name = name;
        this.password = password;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = this.login;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
