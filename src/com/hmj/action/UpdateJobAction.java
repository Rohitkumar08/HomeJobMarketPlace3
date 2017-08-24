package com.hmj.action;

import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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


public class UpdateJobAction extends Action {
	
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		JobServiceImp jbs = (JobServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSERVICEIMP);
		HttpSession session = request.getSession();
		Map map;
		int uid =(int) session.getAttribute("uid");
		try {
            List<Jobs> job = jbs.updateJob(uid);
            if(job.size()!=0){
            	
            	  System.out.println(job.get(0).getJobTitle());
                  request.setAttribute("jobs", job); 
                  return mapping.findForward("success");
                  
            }
            else{
            	return mapping.findForward("noJobs");
            }
          
        } catch (Exception e) {
            throw new Exception("Cannot obtain jobs from DB", e);
        }
	
	}

	
	
}
