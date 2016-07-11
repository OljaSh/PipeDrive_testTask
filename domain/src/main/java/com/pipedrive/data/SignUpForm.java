package com.pipedrive.data;

import com.pipedrive.preset.LocaleLoader;

public class SignUpForm {

	private LocaleLoader localeLoader;

	public SignUpForm() {
		localeLoader = new LocaleLoader("SignUpLabels");
	}

	public String getUsername() {
		return localeLoader.getValue("label.username");
	}
}
