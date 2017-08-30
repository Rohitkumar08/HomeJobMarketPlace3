package com.hmj.service;

import java.util.List;

import com.hmj.dao.UserData;
import com.hmj.model.*;
import com.hmj.util.FactoryUtil;


public class MemberServiceImp {


	public int doRegister(String name,String lname, String phone, String email, String password, String memberType, String noOfChilds, String spouseName, String expectedPays, String yearsOfExperiences) {
		// TODO Auto-generated method stub
		UserData ud = (UserData) FactoryUtil.mapClassInstance.get(FactoryUtil.USERDATA);
		 Member mem= (Member) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBER);
		 Seeker seeker =(Seeker) FactoryUtil.mapClassInstance.get(FactoryUtil.SEEKER); 
		 Sitter sitter = (Sitter) FactoryUtil.mapClassInstance.get(FactoryUtil.SITTER);
		 int id=0;
		if(ud.checkEmail(email)) {
			return 0;
			
		}
		
		
	
		 mem.setFirstName(name);
		mem.setLastName(lname);
		 mem.setPhone(phone);
		 mem.setEmail(email);
		 mem.setPassword(password);
		 mem.setMemberType(memberType);
		 mem.setStatus("ACTIVE");
		
		 if(memberType.equals("Seeker")){
			 int noOfChild= Integer.parseInt(noOfChilds);
			 seeker.setFirstName(name);
			 seeker.setLastName(lname);
			 seeker.setPhone(phone);
			 seeker.setEmail(email);
			 seeker.setPassword(password);
			 seeker.setMemberType(memberType);
			 seeker.setStatus("ACTIVE");
			 seeker.setNoOfChilds(noOfChild);
			 seeker.setSpouseName(spouseName);
			 id=ud.registerSeeker(seeker);
		 }
		 if(memberType.equals("Sitter")){
				int expectedPay=Integer.parseInt(expectedPays);
				int yearsOfExperience=Integer.parseInt(yearsOfExperiences);
			 sitter.setFirstName(name);
			 sitter.setLastName(lname);
			 sitter.setPhone(phone);
			 sitter.setEmail(email);
			 sitter.setPassword(password);
			 sitter.setMemberType(memberType);
			 sitter.setStatus("ACTIVE");
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
			 
			 if(mem==null) {
				 return "invalid";
			 }
			 
			 
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

	public Seeker getUserDetails(int uid) {
		// TODO Auto-generated method stub
		UserData ud = (UserData) FactoryUtil.mapClassInstance.get(FactoryUtil.USERDATA);

		Seeker seeker = ud.getUserDetailsDao(uid);
		return seeker;
	}

	public boolean updateUser(int uid, String firstName, String phone, String noOfChilds, String spouseName) {
		// TODO Auto-generated method stub
		UserData ud = (UserData) FactoryUtil.mapClassInstance.get(FactoryUtil.USERDATA);
		 Member mem= (Member) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBER);
		 Seeker seeker = (Seeker) FactoryUtil.mapClassInstance.get(FactoryUtil.SEEKER);
		 int noOfChild=Integer.parseInt(noOfChilds);
		 mem.setFirstName(firstName);
		 mem.setPhone(phone);
		 seeker.setFirstName(firstName);
		 seeker.setPhone(phone);
		 seeker.setNoOfChilds(noOfChild);
		 seeker.setSpouseName(spouseName);
		 
		 
		int updatedUserData= ud.updateSeekerDetails(seeker, uid);
		
		
		
		return false;
	}

	public boolean deleteSeekerDetails(int uid, String email) {
		// TODO Auto-generated method stub
		UserData ud = (UserData) FactoryUtil.mapClassInstance.get(FactoryUtil.USERDATA);
		 //Member mem= (Member) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBER);
		 Member mem= ud.getMemberDetailsDao(uid);
		System.out.println(mem.getStatus());
		 mem.setStatus("INACTIVE");
		 String pipedEmail=email.concat("|");
		 mem.setEmail(pipedEmail);
		//int res=ud.deleteSeeker(uid,email);
		 ud.deleteMember(mem);
		
		return true;
	}

	public Sitter getSitterUserDetails(int uid) {
		// TODO Auto-generated method stub
		
		UserData ud = (UserData) FactoryUtil.mapClassInstance.get(FactoryUtil.USERDATA);

		Sitter sitter = ud.getSitterUserDetailsDao(uid);
		return sitter;
		
	}

	public boolean updateUserSitter(int uid, String firstName, String phone, String expectedPays, String yearsOfExperiences) {
		// TODO Auto-generated method stub
		UserData ud = (UserData) FactoryUtil.mapClassInstance.get(FactoryUtil.USERDATA);
		 Member mem= (Member) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBER);
		 Sitter sitter = (Sitter) FactoryUtil.mapClassInstance.get(FactoryUtil.SITTER);
		 
		 int expectedPay= Integer.parseInt(expectedPays);
		 int yearsOfExperience= Integer.parseInt(yearsOfExperiences);
		 mem.setFirstName(firstName);
		 mem.setPhone(phone);
		sitter.setFirstName(firstName);
		 sitter.setPhone(phone);
		sitter.setExpectedPay(expectedPay);
		sitter.setYearsOfExperience(yearsOfExperience);
		 
		 
		int updatedUserData= ud.updateSitterDetails(sitter, uid);
		
		
		
		return true;
	}

	public List<Member> getSearchData(String keyWord) {
		// TODO Auto-generated method stub
		UserData ud = (UserData) FactoryUtil.mapClassInstance.get(FactoryUtil.USERDATA);

		List<Member> members= ud.getSearchedEmails(keyWord);
		
		return members;
	}

	public int deleteSitterDetails(int uid, String email) {
		UserData ud = (UserData) FactoryUtil.mapClassInstance.get(FactoryUtil.USERDATA);
		 Member mem= (Member) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBER);
		 
		 int res=ud.deleteSitter(uid,email);

		
		// TODO Auto-generated method stub
		return res;
	}

	
	
}
