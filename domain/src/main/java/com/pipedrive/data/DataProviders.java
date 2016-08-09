package com.pipedrive.data;

import org.testng.annotations.DataProvider;

import java.util.Collections;
import java.util.Iterator;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class DataProviders {
	//-------------------------------------

	// Data providers  for Registration test cases

	// Data provider fot positive Registration test cases

	@DataProvider(name = "positiveRegistrationDP")
	public static Iterator<Object[]> positiveRegistrationDP() {
		return Stream.of(new NewUser("userName", "companyName", "email", "password", "6-15 members", "Health"))
				.map(user -> new Object[]{user})
				.collect(toList())
				.iterator();
	}

	//Data provider for negative Registration test cases
	@DataProvider(name = "registrationAllFieldsEmptyDP")
	public static Iterator<Object[]> registrationAllFieldsEmptyDP() {
		return Stream.of(
				new NewUserPredefined("", "", "", "", "50+ members", "Consulting")
				//new NewUser("userName", "", "email", "password", "6-15 members", "Health"),
				//new NewUser("userName", "companyName", "", "password", "6-15 members", "Health")
		)
				.map(user -> new Object[]{user})
				.collect(toList())
				.iterator();
	}

	@DataProvider(name = "userExistDP")
	public static Iterator<Object[]> userExistDP() {
		return Stream.of(
				new NewUser("Olja", "companyName", "sh.olja@gmail.com", "password", "6-15 members", "Health")
		)
				.map(user -> new Object[]{user})
				.collect(toList())
				.iterator();
	}


	//--------------------------------------

	// Data providers for Login test cases

	// Data provider for positive Login test case

	@DataProvider(name = "positiveLoginDP")
	public static Iterator<Object[]> positiveLoginDP() {
	/*	Arrays.asList(new RegisteredUser("sh.olja@gmail.com", "nalT5g8S"),
				new RegisteredUser("sh.olja@gmail.com", "nalT5g8S")).stream()*/
		return Collections.singletonList(new RegisteredUser("shseven@hotmail.com", "TestTest")).stream()
				.map(user -> new Object[]{user})
				.iterator();
	}


	// Data providers for negative Login test cases

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


