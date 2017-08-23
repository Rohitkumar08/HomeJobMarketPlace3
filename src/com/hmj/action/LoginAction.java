package com.hmj.action;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hmj.FormBeans.LoginForm;
import com.hmj.model.Member;
import com.hmj.service.MemberServiceImp;
import com.hmj.util.FactoryUtil;

public class LoginAction extends Action {
	
	private static final long serialVersionUID = 1L;
	public static final String SALT = "my-salt-text";
	Member mem= (Member) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBER);
	MemberServiceImp svc = (MemberServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBERSERVICEIMP);
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		LoginForm loginForm = (LoginForm)form;
		String email=loginForm.getEmail();
		String pwd= loginForm.getPassword();
		String saltedPassword = SALT + pwd;
		String hashedPassword = generateHash(saltedPassword);
		String loginStatus=svc.validateUser(email,hashedPassword);
		if(loginStatus.equals("valid")){
	
			HttpSession session=request.getSession();  
	        mem=svc.getUserData(email);
	        session.setAttribute("uname",mem.getFirstName()); 
	        session.setAttribute("uid", mem.getId());
	        System.out.println(session.getAttribute("uid"));
			String uType=mem.getMemberType();
			System.out.println("********"+uType);
			session.setAttribute("utype", uType);
			if(uType.equals("Seeker")){
				RequestDispatcher rd = request.getRequestDispatcher("PerformSeeker");
				rd.forward(request, response);
			}
			if(uType.equals("Sitter")){
				RequestDispatcher rd = request.getRequestDispatcher("PerformSitter");
				rd.forward(request, response);
			}
			if(uType.equals("Admin")){
				RequestDispatcher rd = request.getRequestDispatcher("AdminLoggedIn");
				rd.forward(request, response);
			
			}
		
			return mapping.findForward("valid");
		}
		if(loginStatus.equals("invalid")){
			return mapping.findForward("invalid");
		}
		if(loginStatus.equals("noEmail")){
			return mapping.findForward("noEmail");
		}
		
		
		return super.execute(mapping, form, request, response);
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
