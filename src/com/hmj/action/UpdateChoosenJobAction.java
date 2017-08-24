package com.hmj.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

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
		
		int uid=(int) session.getAttribute("uid");
		
//		String selected[]= request.getParameterValues("inputed");
//		String jobTitle=selected[0].substring(7);  //job title choosen for edit purpose
//			System.out.println(selected[0].substring(7));
			int jobId=Integer.parseInt(request.getParameter("inputed"));
			Jobs job = jbs.getJobDetails(jobId);
			System.out.println(job.getJobTitle());
			System.out.println(job.getStartDate());
			  request.setAttribute("jobs", job); 
			  System.out.println("skuvbwkuvchwouvwkuvhwifvgweifwkuvcwifbweufgewifebwu");
	          
		
	
		return mapping.findForward("success");
	}
	
	
	
	
}
