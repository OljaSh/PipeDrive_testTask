package com.pipedrive.preset;

import java.util.Locale;
import java.util.ResourceBundle;


public enum Error {
	INCORRECT_EMAIL_OR_PASSWORD(ResourceBundle.getBundle("LabelsBundle", Locale.getDefault())
			.getString("label.error.message.wrongUserNamePassword")),
	INCORRECT_EMAIL_FORMAT(ResourceBundle.getBundle("LabelsBundle", Locale.getDefault())
			.getString("label.error.message.addValidEmailAddress")),
	EMPTY_EMAIL(ResourceBundle.getBundle("LabelsBundle", Locale.getDefault())
			.getString("label.error.message.addEmailAddress")),
	EMPTY_PASSWORD(ResourceBundle.getBundle("LabelsBundle", Locale.getDefault())
			.getString("label.error.message.addPassword"));

	private String text;

	Error(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}
