package com.hmj.service;

import java.util.List;

import com.hmj.dao.UserData;
import com.hmj.model.*;
import com.hmj.util.FactoryUtil;


public class MemberServiceImp {


	public int doRegister(String name, String phone, String email, String password, String memberType, int noOfChild, String spouseName, int expectedPay, int yearsOfExperience) {
		// TODO Auto-generated method stub
		UserData ud = (UserData) FactoryUtil.mapClassInstance.get(FactoryUtil.USERDATA);
		 Member mem= (Member) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBER);
		 Seeker seeker =(Seeker) FactoryUtil.mapClassInstance.get(FactoryUtil.SEEKER); 
		 Sitter sitter = (Sitter) FactoryUtil.mapClassInstance.get(FactoryUtil.SITTER);
		 
		 int id=0;
		 mem.setFirstName(name);
		 mem.setPhone(phone);
		 mem.setEmail(email);
		 mem.setPassword(password);
		 mem.setMemberType(memberType);
		
		 if(memberType.equals("Seeker")){
			 seeker.setFirstName(name);
			 seeker.setPhone(phone);
			 seeker.setEmail(email);
			 seeker.setPassword(password);
			 seeker.setMemberType(memberType);
			 seeker.setNoOfChilds(noOfChild);
			 seeker.setSpouseName(spouseName);
			 id=ud.registerSeeker(seeker);
		 }
		 if(memberType.equals("Sitter")){
			 
			 sitter.setExpectedPay(expectedPay);
			 sitter.setYearsOfExperience(yearsOfExperience);
			id=ud.registerSitter(sitter);
		 }
		 
		System.out.println("***inside service");
			//boolean register=ud.putUserData(mem);

			return id;
	}

	public String validateUser(String email, String password) {
		// TODO Auto-generated method stub
		UserData ud = (UserData) FactoryUtil.mapClassInstance.get(FactoryUtil.USERDATA);
		 
		 System.out.println(email);
		 boolean check=ud.checkEmail(email);
		 if(check){
			 Member mem=ud.getPassword(email);
			 String originalPassword=mem.getPassword();
			 if(password.equals(originalPassword)){
				 return "valid";
			 }
			 else{
				 return "invalid";
			 }
		 }
		 else{
			 
			 return "noEmail";
		 }
		
	}

	public Member getUserData(String email) {
		// TODO Auto-generated method stub
		UserData ud = (UserData) FactoryUtil.mapClassInstance.get(FactoryUtil.USERDATA);
		Member mem = ud.getPassword(email);
		return mem;
	}

	
	
}
