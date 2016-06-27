package com.pipedrive.preset;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Serhii Korol
 */
public class LocaleLoader {

	private ResourceBundle bundle;

	public LocaleLoader(String bundle) {
		this.bundle = ResourceBundle.getBundle(bundle, Locale.getDefault());
	}

	public String getValue(String key) {
		return bundle.getString(key);
	}
}
