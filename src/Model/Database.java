package Model;

import Model.Account;

import java.util.ArrayList;
import java.util.LinkedList;

public class Database {
    public static Account[] accounts;

    public Account[] getAccounts() {
        return Database.accounts;
    }

    public void setAccounts(Account[] accounts) {
        Database.accounts = accounts;
    }

    public void setAccount(Account account){
        Account AccountsTemplate[] = new Account[this.accounts.length + 1];
        AccountsTemplate = this.accounts;
        AccountsTemplate[this.accounts.length + 1] = account;
    }

    public Account getAccount(String login, String password){

        for(int i = 0; i < this.accounts.length; i++){
            if(this.accounts[i].login == login && this.accounts[i].password == password){
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