package com.testCases;
import static org.junit.Assert.*;

import org.junit.Test;

import com.hmj.Validations.Validator;

public class TestLogic {
	
	Validator validate= new Validator();
	
	@Test
	public void validateName() {
		assertEquals("name empty",false,validate.validateFirstName(" "));
		assertFalse("Min 3 alphabets",validate.validateFirstName("As"));
		assertFalse("Numeric not allowed",validate.validateFirstName("1123"));
		assertFalse("only aphabets",validate.validateFirstName("dcw2"));
		assertFalse("special char not allowed",validate.validateFirstName("vsdv@#"));
		
		
	}
	@Test
	public void validateEmail() {
		assertEquals("email empty",false,validate.validateEmail(""));
		assertFalse("@required",validate.validateEmail("ckwjck"));
		assertFalse("after @ char req.",validate.validateEmail("ghsdvj@"));
		assertFalse("not valid",validate.validateFirstName("jsvj.@"));
		assertFalse("domain name is req.",validate.validateEmail("hjsdc@kdbcw"));
		
		
	}

}
