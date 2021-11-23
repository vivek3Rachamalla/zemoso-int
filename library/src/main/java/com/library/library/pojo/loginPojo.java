package com.library.pojo;


public class loginPojo {
    private String username;
    private String password;

    public loginPojo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public loginPojo() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "loginPojo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
