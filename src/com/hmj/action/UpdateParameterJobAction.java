package com.hmj.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hmj.FormBeans.CreateJobForm;
import com.hmj.FormBeans.UpdateJobForm;
import com.hmj.service.JobServiceImp;
import com.hmj.util.FactoryUtil;

public class UpdateParameterJobAction extends Action {

	
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		UpdateJobForm updateJobForm = (UpdateJobForm) form;
		JobServiceImp jbs = (JobServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSERVICEIMP);
		int jobId= updateJobForm.getId();
	
		
		HttpSession session = request.getSession();
		int uid= (int) session.getAttribute("uid");
		boolean updated=jbs.updateChoosenParam(uid, jobId, updateJobForm.getJobTitle(), updateJobForm.getStartDate(), updateJobForm.getEndDate(),updateJobForm.getPayPerHour());
		if(updated)
		return mapping.findForward("success");
		else
			return mapping.findForward("failure");	
	}
	
	
}
