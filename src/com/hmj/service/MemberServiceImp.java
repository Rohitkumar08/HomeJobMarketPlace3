package com.hmj.service;

import java.util.List;

import com.hmj.dao.UserData;
import com.hmj.model.*;
import com.hmj.util.FactoryUtil;


public class MemberServiceImp {


	public boolean doRegister(Member mem) {
		// TODO Auto-generated method stub
		UserData ud = (UserData) FactoryUtil.mapClassInstance.get(FactoryUtil.USERDATA);
		System.out.println("***inside service");
			boolean register=ud.putUserData(mem);

			return register;
	}

	
	
}
