package com.hmj.action;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hmj.model.Member;
import com.hmj.service.MemberServiceImp;
import com.hmj.util.FactoryUtil;

public class SearchEmailAction extends Action {


	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		MemberServiceImp svc = (MemberServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBERSERVICEIMP);
		String keyWord=request.getParameter("searchEmail");
		List<Member> emails=svc.getSearchData(keyWord);
		System.out.println(emails.size());
		request.setAttribute("member", emails);
		if(emails.size()==0){
			
			return mapping.findForward("failure");
			
		}
		else{
			return mapping.findForward("success");
		}
	}
	
	
}
