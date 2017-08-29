package com.hmj.action;

import java.util.List;

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

public class ListAllJobAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub	
		JobServiceImp jbs = (JobServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSERVICEIMP);
		HttpSession session = request.getSession();
		int uid= (int) session.getAttribute("uid");
		try {
            List<Jobs> job = jbs.listAllJobsForSeekers(uid);
           // System.out.println(job.get(0).getJobTitle());
            if(job.size()==0){
            	return mapping.findForward("failure");
            }
            request.setAttribute("jobs", job); 
            System.out.println("skuvbwkuvchwouvwkuvhwifvgweifwkuvcwifbweufgewifebwu");

            
        } catch (Exception e) {
            ;
        }
		return mapping.findForward("success");
	}
	
	
}
