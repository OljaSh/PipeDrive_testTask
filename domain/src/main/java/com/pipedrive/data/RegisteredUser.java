package com.pipedrive.data;


public class RegisteredUser {

    private String email;
    private String password;

    public RegisteredUser(final String email, final String password){
       this.email = email;
       this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
