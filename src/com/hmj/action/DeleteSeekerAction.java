package com.hmj.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hmj.service.MemberServiceImp;
import com.hmj.util.FactoryUtil;

public class DeleteSeekerAction extends Action{

	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		MemberServiceImp svc = (MemberServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBERSERVICEIMP);

		int uid=(int) session.getAttribute("uid");
		String email= (String) session.getAttribute("uemail");
		
		svc.deleteSeekerDetails(uid, email);
		
				return mapping.findForward("success");
		
//			else{
//				return mapping.findForward("error");
//			}

	}
	
	
}
