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

import com.hmj.service.JobServiceImp;
import com.hmj.util.FactoryUtil;

public class DeleteJobAction extends Action {
		
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		JobServiceImp jbs = (JobServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSERVICEIMP);
		HttpSession session = request.getSession();
		int uid= (int) session.getAttribute("uid");
		List<Applications> lst = jbs.fetchAllJobsSitter(uid);
		if(lst==null) {
			return mapping.findForward("failure");
		}
		request.setAttribute("apps", lst);
		System.out.println("list= "+lst.size());
		
		if(lst.size()!=0)
		return mapping.findForward("success");
		else
			return mapping.findForward("failure");
	}


}
