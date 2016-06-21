package com.pipedrive.data;


import org.apache.commons.lang3.RandomStringUtils;

public class NewUser {

    private String userName;
    private String companyName;
    private String userEmail;
    private String userPassword;
    private String teamSize;
    private String companyIndustry;

    public NewUser (final String userName, final String companyName, final String userEmail,
                    final String userPassword, final String teamSize, final String companyIndustry){
        this.userName = RandomStringUtils.randomAlphabetic(8);
        this.companyName = RandomStringUtils.randomAlphabetic(8);
        this.userEmail = RandomStringUtils.randomAlphabetic(8) + "@email.com";
        this.userPassword = RandomStringUtils.randomAlphabetic(8);
        this.teamSize = teamSize;
        this.companyIndustry = companyIndustry;
    }

    public String getUserName(){return userName;}
    public String getCompanyName(){return  companyName;}
    public String getUserEmail(){return  userEmail;}
    public String getUserPassword(){return userPassword;}
    public String getTeamSize(){return teamSize;}
    public String getCompanyIndustry(){return companyIndustry;}

}
