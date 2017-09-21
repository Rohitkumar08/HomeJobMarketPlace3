package com.hmj.Validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validator {

	
	//_______________----
	public boolean validate(String text, int min, int max) {
		  if (validate_min(text, min)) {
		   return validate_max(text, max);
		  } else {
		   return false;
		  }
		 }

		 public boolean validate_min(String text, int min) {
		  if (text == null || text.contentEquals(" ") || text.length() < min) {
		   return false;
		  } else {

		   return true;
		  }
		 }

		 public boolean validate_max(String text, int max) {
		  if (text == null || text.contentEquals(" ") || text.length() > max) {
		   return false;
		  } else {

		   return true;
		  }
		 }
		 public boolean validateName(String text) {
		  char a[] = text.toCharArray();
		  for (Character c : a) {
		   if (Character.isAlphabetic(c) || c == ' ') {

		   } else {
		    System.out.println(c);
		    return false;
		   }
		  }
		  return true;
		 }
		 public boolean validateFirstName(String text) {

		  if (validate(text, 3, 50)) {
		   return validateName(text);
		  } else {
		   return false;
		  }
		 
		 }

		 public boolean validateLastName(String text) {
		  if (validate(text, 1, 50)) {
		   return validateName(text);
		  } else {
		   return false;
		  }
		 }

	
	//_-----------
	
public boolean validateEmail(String email) {
	 final String EMAIL_REGEX="^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})";
	    //static Pattern object, since pattern is fixed
	    Pattern pattern;
	    //non-static Matcher object because it's created from the input String
	    Matcher matcher;
	    pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
	    matcher = pattern.matcher(email);
	    if(matcher.matches()){
	    	return true;
	    }
	    else{
	    		return false;
	    
	    }
		
	}
	
public boolean validatePhoneNo(String phone) {
	
	 if (phone.matches("\\d{10}")) {
		 
		return true;
	 }
	 else
		 return false;
	
}
	
}
