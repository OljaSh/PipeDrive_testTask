package com.pipedrive.data;


public class RegisteredUser {

    private String email;
    private String password;

    public RegisteredUser(final String email, final String password){
        this.email = "sh.olja@gmail.com";
        this.password = "nalT5g8S";
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
