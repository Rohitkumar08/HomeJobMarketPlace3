package com.hmj.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hmj.FormBeans.CreateJobForm;
import com.hmj.service.JobServiceImp;
import com.hmj.util.FactoryUtil;


public class CreateJobAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		CreateJobForm createJobForm = (CreateJobForm) form;
		JobServiceImp jbs = (JobServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSERVICEIMP);
		HttpSession session = request.getSession();
		int uid = (int) session.getAttribute("uid");
		
		int id=jbs.newJob(createJobForm.getJobTitle(), createJobForm.getStartDate(), createJobForm.getEndDate(), createJobForm.getStartTime(), createJobForm.getEndTime(),uid, createJobForm.getPayPerHour());
		

		
		return mapping.findForward("success");
	}
	
	
	
}
