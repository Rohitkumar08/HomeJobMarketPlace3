package com.hmj.model;

import com.hmj.enums.Status;

public class Applications {
	private Jobs jobs;
	private Sitter sitter;
	private Status status;
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Status getJobStatus() {
		return jobStatus;
	}
	public void setJobStatus(Status jobStatus) {
		this.jobStatus = jobStatus;
	}
	private Status jobStatus;

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
