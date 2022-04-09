package Database;

import Model.Account;

import java.util.Objects;

public class Database {
    public Account[] accounts;

    public Account[] getAccounts() {
        return this.accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public void setAccount(Account account){
        if(isEmpty()){
            Account[] AccountsTemplate = new Account[1];
            AccountsTemplate[0] = account;
            setAccounts(AccountsTemplate);
            System.out.println("Criou!");
        }else{
            Account[] AccountsTemplate = new Account[this.accounts.length + 1];
            AccountsTemplate = this.accounts;
            AccountsTemplate[this.accounts.length + 1] = account;
            System.out.println("Criou!");
        }
    }

    public Account getAccount(String login, String password){

        for(int i = 0; i < this.accounts.length; i++){
            if(this.accounts[i].getLogin() == login && Objects.equals(this.accounts[i].getPassword(), password)){
                return this.accounts[i];
            }
        }

        return null;
    }
    public boolean isEmpty(){
        if(this.accounts == null){
            return true;
        }else{
            return false;
        }
    }
}