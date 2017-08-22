package com.hmj.action;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hmj.FormBeans.RegisterForm;
import com.hmj.model.*;
import com.hmj.service.MemberServiceImp;
import com.hmj.util.FactoryUtil;


public class RegisterAction extends Action{

	public static final String SALT = "my-salt-text";
//	Member mem=new Member();
//	MemberServiceImp svc= new MemberServiceImp();
	 Member mem= (Member) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBER);
     Sitter sitter = (Sitter) FactoryUtil.mapClassInstance.get(FactoryUtil.SITTER);
	MemberServiceImp svc = (MemberServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBERSERVICEIMP);
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		RegisterForm registerForm= (RegisterForm)form;
		
		 System.out.println("********** "+registerForm.getFirstName());
		 
		mem.setFirstName(request.getParameter("firstName"));
		mem.setPhone(request.getParameter("phone"));
		mem.setEmail(request.getParameter("email"));
		
		String password=request.getParameter("password");
		String saltedPassword = SALT + password;
		String hashedPassword = generateHash(saltedPassword);
		System.out.println("*******"+hashedPassword);
		mem.setPassword(hashedPassword);
		
		mem.setAdd(request.getParameter("address"));
		mem.setMemberType(request.getParameter("memberType"));
		System.out.println(mem.getMemberType());
		
		
		boolean registered=svc.doRegister(mem);
		
		
		return mapping.findForward("success");
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
