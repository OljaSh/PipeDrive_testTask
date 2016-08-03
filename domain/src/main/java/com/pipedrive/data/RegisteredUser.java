package com.pipedrive.data;

import lombok.Data;

@Data
public class RegisteredUser {

    private String email;
    private String password;

    public RegisteredUser(final String email, final String password){
       this.email = email;
       this.password = password;
    }
}
