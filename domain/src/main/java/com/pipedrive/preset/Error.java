package com.pipedrive.preset;

import java.util.Locale;
import java.util.ResourceBundle;


public enum Error {

	//User Registration errors
	EMPTY_USER_NAME(ResourceBundle.getBundle("LabelsBundle", Locale.getDefault())
			.getString("label.error.message.addUserName")),
	EMPTY_COMPANY_NAME(ResourceBundle.getBundle("LabelsBundle", Locale.getDefault())
			.getString("label.error.message.addCompanyName")),
	EMPTY_COMPANY_INDUSTRY(ResourceBundle.getBundle("LabelsBundle", Locale.getDefault())
			.getString("label.error.message.addCompanyIndustry")),

	//User Login errors
	INCORRECT_EMAIL_OR_PASSWORD(ResourceBundle.getBundle("LabelsBundle", Locale.getDefault())
			.getString("label.error.message.wrongUserNamePassword")),
	INCORRECT_EMAIL_FORMAT(ResourceBundle.getBundle("LabelsBundle", Locale.getDefault())
			.getString("label.error.message.addValidEmailAddress")),
	EMPTY_EMAIL(ResourceBundle.getBundle("LabelsBundle", Locale.getDefault())
			.getString("label.error.message.addEmailAddress")),
	EMPTY_PASSWORD(ResourceBundle.getBundle("LabelsBundle", Locale.getDefault())
			.getString("label.error.message.addPassword")),
	EXPIRED_USER(ResourceBundle.getBundle("LabelsBundle", Locale.getDefault())
			.getString("label.error.message.expiredUser"));

	private String text;

	Error(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}
