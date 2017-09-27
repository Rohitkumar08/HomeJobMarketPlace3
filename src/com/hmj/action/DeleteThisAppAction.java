package com.hmj.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hmj.service.JobServiceImp;
import com.hmj.util.FactoryUtil;

public class DeleteThisAppAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
	
//		String selected[]= request.getParameterValues("inputed");
//		int selectedJobId=Integer.parseInt(selected[0].substring(7));  //job title choosen for edit purpose
//			System.out.println(selected[0].substring(7));
//			int jobId=selectedJobId;
	
		int jobId= Integer.parseInt(request.getParameter("id"));
		int uid=(int) session.getAttribute("uid");
		JobServiceImp jbs = (JobServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSERVICEIMP);
		 boolean deleted= jbs.deleteApp(jobId,uid);
		 if(deleted)
		return mapping.findForward("success");
		 else
			 return mapping.findForward("failure");
		
	}
	
	
	
}
