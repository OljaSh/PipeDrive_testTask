package com.pipedrive.preset;

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
		this.bundle = ResourceBundle.getBundle(bundle, locale);
	}

	public String getValue(String key) {
		String value = bundle.getString(key);
		try {
			System.out.println(StandardCharsets.UTF_8.encode(value));
			return new String(value.getBytes(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return value;
	}


}
