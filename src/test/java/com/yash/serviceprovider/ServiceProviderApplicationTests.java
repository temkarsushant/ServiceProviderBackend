package com.yash.serviceprovider;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.yash.serviceprovider.entity.Registration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServiceProviderApplicationTests {

	@Test
	void contextLoads() {
	}

//	Test case to check password entered by user and actual password.
	@Test
	void checkLoginPassword() {
		String expectedPassword = "Sushant5";

		Registration registration = new Registration();
		registration.setPassword("Sushant5");

		assertEquals(registration.getPassword().toString(), expectedPassword.toString());
	}

	// Test case to check password entered by user and confirmed password are
	// matching or not.
	@Test
	void checkConfirmPassword() {

		Registration registration = new Registration();
		registration.setPassword("Sushant5");
		registration.setConfirmpassword("Sushant5");

		assertEquals(registration.getPassword().toString(), registration.getConfirmpassword().toString());
	}

	// Test case to check Email id entered by user is present or not.
	@Test
	void checkEmailId() {

		String expectedEmailId = "temkarsushant3@gmail.com";

		Registration registration = new Registration();
		registration.setEmailid("temkarsushant3@gmail.com");

		assertEquals(registration.getEmailid().toString(), expectedEmailId.toString());
	}

}
