package com.hmj.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hmj.model.Member;
import com.hmj.model.Seeker;
import com.hmj.service.MemberServiceImp;
import com.hmj.util.FactoryUtil;

@RestController
public class MemberController {

	MemberServiceImp svc = (MemberServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBERSERVICEIMP);
	
	@RequestMapping( value="/members", method = RequestMethod.GET, produces = "application/json")
	public  List<Member> getAllMembers() {
	System.out.println("inside controller api");
		List<Member> listOfMembers = svc.getAllMembers();
		return listOfMembers;
	}
	
	@RequestMapping(value = "/member/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Member getMemberById(@PathVariable int id) {
		return svc.getMember(id);
	}

	@RequestMapping(value = "/members", method = RequestMethod.POST, headers = "Accept=application/json")
	public Member addMember(@RequestBody Member member) {
		System.out.println("called method");
		return svc.addMember(member);
	}
	
}
