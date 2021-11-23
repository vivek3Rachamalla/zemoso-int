package com.library.bootLibrary.formEntities;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginPojo {

    @NotNull
    @Size(min = 1, max = 45,message = "should be between 1 and 45")
    private String usernameLogin;
    @NotNull
    @Size(min = 1, max = 45,message = "should be between 1 and 45")
    private String passwordLogin;

    public LoginPojo(String username, String password) {
        this.usernameLogin = username;
        this.passwordLogin = password;
    }

    public LoginPojo() {

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
