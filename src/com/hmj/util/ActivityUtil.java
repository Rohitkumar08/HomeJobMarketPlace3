package com.hmj.util;

import java.util.ArrayList;
import java.util.List;

public class ActivityUtil {
	
	private static List<String> activity = new ArrayList<>();

	public static void add(String data) {
		if(activity==null) {
			activity=new ArrayList<String>();
		}
		System.out.println("**********inside activityUtil**********"+data);
		activity.add(data);
		System.out.println(activity.get(0));
		
	}
	public static List<String> getActivity() {
		return activity;
	}
	public static void makeNull() {
		activity=null;
	}
	
}
