package com.att.cache.HazleCast1.model;

import java.io.Serializable;

public class GenericResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Object responseObj;
	
	private String status;
	
	private String failureReason;

	public String getFailureReason() {
		return failureReason;
	}

	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}

	public Object getResponseObj() {
		return responseObj;
	}

	public void setResponseObj(Object responseObj) {
		this.responseObj = responseObj;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
