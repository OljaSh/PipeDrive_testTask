package com.pipedrive.data;

import lombok.Data;

@Data

public class NewUserPredefined{

    private String userName;
    private String companyName;
    private String userEmail;
    private String userPassword;
    private String teamSize;
    private String companyIndustry;

    public NewUserPredefined(final String userName, final String companyName, final String userEmail,
                             final String userPassword, final String teamSize, final String companyIndustry){
        this.userName = userName;
        this.companyName = companyName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.teamSize = teamSize;
        this.companyIndustry = companyIndustry;
    }
}
