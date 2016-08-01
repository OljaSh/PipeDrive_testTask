package com.pipedrive.data;

import org.testng.annotations.DataProvider;

import java.util.Collections;
import java.util.Iterator;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class DataProviders {

	@DataProvider(name = "positiveDP")
	public static Iterator<Object[]> positiveDP() {
	/*	Arrays.asList(new RegisteredUser("sh.olja@gmail.com", "nalT5g8S"),
				new RegisteredUser("sh.olja@gmail.com", "nalT5g8S")).stream()*/
		return Collections.singletonList(new RegisteredUser("sh.olja@gmail.com", "nalT5g8S")).stream()
				.map(user -> new Object[]{user})
				.iterator();
	}

	@DataProvider(name = "negativeDP")
	public static Iterator<Object[]> negariveDP() {
		return Stream.of(new RegisteredUser("sh.olja", "nalT5g8S"),
				new RegisteredUser("@gmail.com", "nalT5g8S"),
				new RegisteredUser("sh.olja@", "nalT5g8S"),
				new RegisteredUser("sh.olja@gmail.com", "pass"),
				new RegisteredUser(" ", " "),
				new RegisteredUser("", ""))
				.map(user -> new Object[]{user})
				.collect(toList())
				.iterator();
	}

	// DataProvidesrs for AllErrorsTest

	@DataProvider(name = "incorrectEmailFormatDP")
	public static Iterator<Object[]> incorrectEmailFormatDP() {
		return Stream.of(new RegisteredUser("sh.olja", "nalT5g8S"),
				new RegisteredUser("gmail.com", "nalT5g8S"),
				new RegisteredUser(" ", "nalT5g8S"))
				.map(user -> new Object[]{user})
				.collect(toList())
				.iterator();
	}

	@DataProvider(name = "incorrectEmailorPasswordDP")
	public static Iterator<Object[]> incorrectEmailorPassword() {
		return Stream.of(new RegisteredUser("sh.olja", "nalT5g8S"),
				new RegisteredUser("gmail.com", "nalT5g8S"),
				new RegisteredUser(" ", "nalT5g8S"),
				new RegisteredUser("sh.olja@gmail.com", "psddd"))
				.map(user -> new Object[]{user})
				.collect(toList())
				.iterator();
	}

	@DataProvider(name = "expiredUserDP")
	public static Iterator<Object[]> expiredUserDP() {
	return Collections.singletonList(new RegisteredUser("sh.olja@gmail.com", "nalT5g8S")).stream()
	.map(user -> new Object[]{user})
			.iterator();
}
}


