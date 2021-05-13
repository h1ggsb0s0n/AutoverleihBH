package ch.autoverleih;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestEmail {
	
	
	@Test
	void testEmail()
	{
		EmailValidator emailValidator = new EmailValidator();
		
		assertTrue(emailValidator.isMailValid("example.example@gmail.com"));
		
		assertFalse(emailValidator.isMailValid(".example.@gmail.com"));
		
		assertFalse(emailValidator.isMailValid(".example@gmail.com"));
		assertFalse(emailValidator.isMailValid("example.@gmail.com"));
		
		
		assertFalse(emailValidator.isMailValid("example..example@gmail.com"));
		assertFalse(emailValidator.isMailValid("example...example@gmail.com"));
		
		assertFalse(emailValidator.isMailValid("example@example@gmail.com"));
		
		
		assertFalse(emailValidator.isMailValid("example@gmail"));
		assertTrue(emailValidator.isMailValid("example@example.example.ch"));
	}



}
