package com.hmj.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hmj.dao.UserData;
import com.hmj.enums.Status;
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
		 mem.setStatus(Status.ACTIVE);
		
		 if(memberType.equals("Seeker")){
			 int noOfChild= Integer.parseInt(noOfChilds);
			 seeker.setFirstName(name);
			 seeker.setLastName(lname);
			 seeker.setPhone(phone);
			 seeker.setEmail(email);
			 seeker.setPassword(password);
			 seeker.setMemberType(memberType);
			 seeker.setStatus(Status.ACTIVE);
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
			 sitter.setStatus(Status.ACTIVE);
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
	private static HashMap<Integer, Member> getMembersMap() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public  List<Member> getAllMembers() {
		UserData ud = (UserData) FactoryUtil.mapClassInstance.get(FactoryUtil.USERDATA);

		System.out.println("inside serice api");
		int key=1;
		List<Member> listOfMembers = ud.getAllUsers();
		System.out.println(listOfMembers.get(0).getFirstName());
		return listOfMembers;
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

	public boolean updateUser(int uid, String firstName, String lastName, String phone, String noOfChilds, String spouseName) {
		// TODO Auto-generated method stub
		UserData ud = (UserData) FactoryUtil.mapClassInstance.get(FactoryUtil.USERDATA);
		 Member mem= (Member) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBER);
		 
		 int noOfChild;
		 try {
			 
			noOfChild=Integer.parseInt(noOfChilds);
		 }catch(Exception e) {
			 
			 
			 return false;
		 }
		 mem=ud.getMemberDetailsDao(uid);
		Seeker seeker= ud.getUserDetailsDao(uid);
		
		
		 mem.setFirstName(firstName);
		 mem.setLastName(lastName);
		 mem.setPhone(phone);
		 seeker.setFirstName(firstName);
		 seeker.setLastName(lastName);
		 seeker.setPhone(phone);
		 seeker.setNoOfChilds(noOfChild);
		 seeker.setSpouseName(spouseName);
		 
		 
		if(ud.updateSeekerDetails(mem,seeker, uid))
			return true;
		else
			return false;
		
	}

	public boolean deleteSeekerDetails(int uid, String email) {
		// TODO Auto-generated method stub
		UserData ud = (UserData) FactoryUtil.mapClassInstance.get(FactoryUtil.USERDATA);
		 //Member mem= (Member) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBER);
		 Member mem= ud.getMemberDetailsDao(uid);
		System.out.println(mem.getStatus());
		 mem.setStatus(Status.INACTIVE);

		 String pipedEmail=email.concat(""+mem.getId());
		 mem.setEmail(pipedEmail);

		 ud.deleteMember(mem);
		
		return true;
	}

	public Sitter getSitterUserDetails(int uid) {
		// TODO Auto-generated method stub
		
		UserData ud = (UserData) FactoryUtil.mapClassInstance.get(FactoryUtil.USERDATA);

		Sitter sitter = ud.getSitterUserDetailsDao(uid);
		return sitter;
		
	}

	public boolean updateUserSitter(int uid, String firstName, String lastName,String phone, String expectedPays, String yearsOfExperiences) {
		// TODO Auto-generated method stub
		UserData ud = (UserData) FactoryUtil.mapClassInstance.get(FactoryUtil.USERDATA);
		 Member mem= (Member) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBER);
	
		 int expectedPay;
		 int yearsOfExperience;
		 try {
			expectedPay= Integer.parseInt(expectedPays);
			if(expectedPay<0)
				return false;
		 }catch(Exception e) {
			 
			 
			 return false;
		 }
		 try {
			 yearsOfExperience= Integer.parseInt(yearsOfExperiences);
			 if(yearsOfExperience<0)
				 return false;
		 }catch(Exception e) {
			 
			 
			 return false;
		 }
		 mem=ud.getMemberDetailsDao(uid);
			Sitter sitter= ud.getSitterUserDetailsDao(uid);
		
		 mem.setFirstName(firstName);
		 mem.setLastName(lastName);
		 mem.setPhone(phone);
		sitter.setFirstName(firstName);
		sitter.setLastName(lastName);
		 sitter.setPhone(phone);
		sitter.setExpectedPay(expectedPay);
		sitter.setYearsOfExperience(yearsOfExperience);
		 
		 
		if(ud.updateSitterDetails(mem, sitter, uid))
			return true;
		else
			return false;
	
	}

	public List<Member> getSearchData(String keyWord) {
		// TODO Auto-generated method stub
		UserData ud = (UserData) FactoryUtil.mapClassInstance.get(FactoryUtil.USERDATA);

		List<Member> members= ud.getSearchedEmails(keyWord);
		
		return members;
	}

	public int deleteSitterDetails(int uid, String email) {
		UserData ud = (UserData) FactoryUtil.mapClassInstance.get(FactoryUtil.USERDATA);
		 int res=ud.deleteSitter(uid,email);
		return res;
	}

	public List<SeekerActivity> getActivity(int uid) {
		// TODO Auto-generated method stub
		
		UserData ud = (UserData) FactoryUtil.mapClassInstance.get(FactoryUtil.USERDATA);
		List<SeekerActivity> activities= ud.getUserActivity(uid);
		
		return activities;
	}



	public Member getMember(int id) {
		// TODO Auto-generated method stub
		UserData ud = (UserData) FactoryUtil.mapClassInstance.get(FactoryUtil.USERDATA);

		Member mem = ud.getUserDetailsDaoAPI(id);
		
		return mem;
	}



	public Member addMember(Member mem) {
		// TODO Auto-generated method stub
		UserData ud = (UserData) FactoryUtil.mapClassInstance.get(FactoryUtil.USERDATA);
		
		int id=ud.registerMember(mem);
	
		return mem;
	}

	
	
}
