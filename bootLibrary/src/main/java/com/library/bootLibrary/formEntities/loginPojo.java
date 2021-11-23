package com.library.bootLibrary.formEntities;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class loginPojo {

    @NotNull
    @Size(min = 1, message = "You can't leave this empty.")
    private String usernameLogin;
    @NotNull
    @Size(min = 1, message = "You can't leave this empty.")
    private String passwordLogin;

    public loginPojo(String username, String password) {
        this.usernameLogin = username;
        this.passwordLogin = password;
    }

    public loginPojo() {

    }

    public String getUsernameLogin() {
        return usernameLogin;
    }

    public void setUsernameLogin(String username) {
        this.usernameLogin = username;
    }

    public String getPasswordLogin() {
        return passwordLogin;
    }

    public void setPasswordLogin(String password) {
        this.passwordLogin = password;
    }

    @Override
    public String toString() {
        return "loginPojo{" +
                "username='" + usernameLogin + '\'' +
                ", password='" + passwordLogin + '\'' +
                '}';
    }
}
