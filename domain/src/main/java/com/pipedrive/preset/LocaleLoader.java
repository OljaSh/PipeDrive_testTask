package com.pipedrive.preset;

import com.pipedrive.utils.UTF8Control;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.ResourceBundle;


public class LocaleLoader {

	private ResourceBundle bundle;

	public LocaleLoader(String bundle) {
		this(bundle, Locale.getDefault());
	}

	public LocaleLoader(String bundle, Locale locale) {
		this.bundle = ResourceBundle.getBundle(bundle, locale, new UTF8Control());
	}

	public String getValue(String key) {
		return bundle.getString(key);
	}
}
