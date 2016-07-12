package com.pipedrive.data;

import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/**
 * Author: Serhii Korol.
 */
public class DataProviders {

	@DataProvider(name = "positiveDP")
	public static Iterator<Object[]> positiveDP() {
		/*Arrays.asList(new RegisteredUser("sh.olja@gmail.com", "nalT5g8S"),
				new RegisteredUser("sh.olja@gmail.com", "nalT5g8S")).stream()*/
		return Collections.singletonList(new RegisteredUser("sh.olja@gmail.com", "nalT5g8S")).stream()
				.map(user -> new Object[]{user})
				.iterator();
	}
}
