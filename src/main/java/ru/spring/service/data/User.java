package ru.spring.service.data;

public class User {

    private   String login;
    private   String password;

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{ login: " + login +  ", password: " + password + " }";
    }
}
