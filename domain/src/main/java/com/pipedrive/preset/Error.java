package com.pipedrive.preset;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Serhii Korol
 */
public enum Error {
	INCORRECT_EMAIL_OR_PASSWORD(ResourceBundle.getBundle("LabelsBundle", Locale.getDefault())
			.getString("label.error.message"));

	private String text;

	Error(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}
