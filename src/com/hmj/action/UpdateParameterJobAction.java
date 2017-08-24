package com.hmj.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hmj.FormBeans.CreateJobForm;
import com.hmj.service.JobServiceImp;
import com.hmj.util.FactoryUtil;

public class UpdateParameterJobAction extends Action {

	
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		CreateJobForm createJobForm = (CreateJobForm) form;
		JobServiceImp jbs = (JobServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSERVICEIMP);
		int jobId= Integer.parseInt(request.getParameter("jobId"));
		boolean updated=jbs.updateChoosenParam(jobId, createJobForm.getJobTitle(), createJobForm.getStartDate(), createJobForm.getEndDate(), createJobForm.getStartTime(), createJobForm.getEndTime(),createJobForm.getPayPerHour());
		if(updated)
		return mapping.findForward("success");
		else
			return mapping.findForward("failure");	
	}
	
	
}
