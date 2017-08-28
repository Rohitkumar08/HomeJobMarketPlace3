package com.hmj.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hmj.model.Applications;
import com.hmj.model.Sitter;
import com.hmj.service.JobServiceImp;
import com.hmj.util.FactoryUtil;

public class ShowApplicantsAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		JobServiceImp jbs = (JobServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSERVICEIMP);
		Sitter sitter = (Sitter) FactoryUtil.mapClassInstance.get(FactoryUtil.SITTER);
		HttpSession session= request.getSession();
		int uid=(int) session.getAttribute("uid");
		
		String selected[]= request.getParameterValues("inputed");
		int jobId=Integer.parseInt(selected[0].substring(16));
			System.out.println(selected[0].substring(16));
			
			List<Applications> applicants =jbs.showApplicants(uid,jobId);
			System.out.println("^^^^^^^^^^^^^"+applicants.get(0).getExpectedPay()+" ,"+applicants.get(0).getSitter().getFirstName());
			if(applicants.size()!=0){
				
				//System.out.println("*****************"+applicants.get(0).getFirstName());
				
				request.setAttribute("sitter", applicants);
				return mapping .findForward("success");
			}
			else{
				return mapping.findForward("failure");
			}
		
	}
	
	

}
