package com.hmj.action;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hmj.dao.*;
import com.hmj.FormBeans.RegisterForm;
import com.hmj.model.*;
import com.hmj.service.MemberServiceImp;
import com.hmj.util.FactoryUtil;


public class RegisterAction extends Action{

	public static final String SALT = "my-salt-text";
//	Member mem=new Member();
//	MemberServiceImp svc= new MemberServiceImp();
	
    
	MemberServiceImp svc = (MemberServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBERSERVICEIMP);
	UserData ud = (UserData) FactoryUtil.mapClassInstance.get(FactoryUtil.USERDATA);
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		
		RegisterForm registerForm= (RegisterForm)form;
		String password=registerForm.getPassword();
		String saltedPassword = SALT + password;
		String hashedPassword = generateHash(saltedPassword);
		System.out.println("*******"+hashedPassword);
		registerForm.setPassword(hashedPassword);
		 System.out.println("********** "+request.getParameter("noOfChilds"));
		 System.out.println("********** "+request.getParameter("spouseName"));
		int uid=svc.doRegister(registerForm.getFirstName(), registerForm.getLastName(), registerForm.getPhone(),registerForm.getEmail(),registerForm.getPassword(),registerForm.getMemberType(), registerForm.getNoOfChilds(), registerForm.getSpouseName(), registerForm.getExpectedPay(),registerForm.getYearsOfExperience());
		if(uid==0) {
			
			return mapping.findForward("emailAlreadyExist");
		}
		
		
		
		HttpSession session = request.getSession();
		session.setAttribute("uid", uid);
		if(registerForm.getMemberType().equals("Seeker")){
			session.setAttribute("uname", registerForm.getFirstName());
			 session.setAttribute("uemail", registerForm.getEmail());
			 session.setAttribute("utype", "Seeker");
			 Seeker seeker = svc.getUserDetails((int) session.getAttribute("uid"));
				session.setAttribute("sessionData", seeker);
			return mapping.findForward("seeker");
		}
		if(registerForm.getMemberType().equals("Sitter")){
			session.setAttribute("uname", registerForm.getFirstName());
			session.setAttribute("uemail", registerForm.getEmail());
			 session.setAttribute("utype", "Sitter");
			 Sitter sitter = svc.getSitterUserDetails((int) session.getAttribute("uid"));
				session.setAttribute("sessionData", sitter);
			return mapping.findForward("sitter");
		}
		return mapping.findForward("failure");
		
		
//		if(registered){
//			String uType = mem.getMemberType();
//			int uid = ud.getID(mem.getEmail());
//			HttpSession session = request.getSession();
//			session.setAttribute("uname", mem.getFirstName());
//			session.setAttribute("utype", uType);
//	        session.setAttribute("uid",uid);  
//			if(uType.equals("Sitter")){
//				sitter.setExpectedPay(Integer.parseInt(request.getParameter("expectedPay")));
//				sitter.setYearsOfExperience(Integer.parseInt(request.getParameter("yoe")));
//				svc.doRegisterSitter(uid,sitter);
//				
//				RequestDispatcher rd= request.getRequestDispatcher("PerformSitter");
//				rd.forward(request, response);
//				
//					//TODO sitter operations
////				fillSitterDetails(uid,sc);
////				performSitterTask(uid,sc);
//			}
//		
		
	}
	  public static String generateHash(String input) {
			StringBuilder hash = new StringBuilder();

			try {
				MessageDigest sha = MessageDigest.getInstance("SHA-1");
				byte[] hashedBytes = sha.digest(input.getBytes());
				char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
						'a', 'b', 'c', 'd', 'e', 'f' };
				for (int idx = 0; idx < hashedBytes.length; ++idx) {
					byte b = hashedBytes[idx];
					hash.append(digits[(b & 0xf0) >> 4]);
					hash.append(digits[b & 0x0f]);
				}
			} catch (NoSuchAlgorithmException e) {
				// handle error here.
			}

			return hash.toString();
		}
	
	
	
}
