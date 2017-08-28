package com.hmj.model;

public class Applications {
	private Jobs jobs;
	private Sitter sitter;
	private String status;
public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	//	private String status;
//	
//	public String getStatus() {
//		return status;
//	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
	public Jobs getJobs() {
		return jobs;
	}
	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
	}
	public Sitter getSitter() {
		return sitter;
	}
	public void setSitter(Sitter sitter) {
		this.sitter = sitter;
	}
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	private int expectedPay;
	public int getExpectedPay() {
		return expectedPay;
	}
	public void setExpectedPay(int expectedPay) {
		this.expectedPay = expectedPay;
	}
	
}
