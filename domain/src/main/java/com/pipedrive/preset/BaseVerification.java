package com.pipedrive.preset;

import ru.yandex.qatools.allure.annotations.Step;

import static com.pipedrive.core.BaseTest.getSoftAssert;

/**
 * Created by Serhii Korol
 */
public class BaseVerification
{
	@Step("Verify that {2} = {1}")
	public static void verifyTextEquals(String actual, String expected, String message) {
		getSoftAssert().assertEquals(actual, expected);
	}
}
