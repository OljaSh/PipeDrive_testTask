package com.pipedrive.preset;

import java.util.Locale;

public enum Language {

	ENGLISH("en", Locale.ENGLISH),
	ESTONIAN("et", Locale.forLanguageTag("et-EE")),
	RUSSIAN("ru", Locale.forLanguageTag("ru"));

	private String language;
	private Locale locale;

	Language(String language, Locale locale) {
		this.language = language;
		this.locale = locale;
	}

	public String getLanguage() {
		return language;
	}

	public Locale getLocale() {
		return locale;
	}
}
