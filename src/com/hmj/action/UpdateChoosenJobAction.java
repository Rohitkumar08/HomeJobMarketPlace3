package com.hmj.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hmj.FormBeans.JobIdForm;
import com.hmj.model.Jobs;
import com.hmj.service.JobServiceImp;
import com.hmj.util.FactoryUtil;


public class UpdateChoosenJobAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(); 
		JobServiceImp jbs = (JobServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSERVICEIMP);
		JobIdForm jobIdForm = (JobIdForm)form;
		int uid=(int) session.getAttribute("uid");
		
		String selected[]= request.getParameterValues("inputed");System.out.println(selected[0]);
		int selectedJobId=Integer.parseInt(selected[0].substring(7));  
			System.out.println(selected[0].substring(7));
			int jobId=selectedJobId;
			Jobs job = jbs.getJobDetails(jobId);
			
			  request.setAttribute("jobs", job); 
			
	          
		
	
		return mapping.findForward("success");
	}
	
	
	
	
}
