package com.masai.DTO;

public class CoursePlanImpl implements CoursePlan {
	
	int planId;
	Batch batch;
	int daynumber;
	String topic;
	boolean status;
	
	
	public CoursePlanImpl() {};
	
	public CoursePlanImpl(int planId, Batch batch, int daynumber, String topic, boolean status) {
		super();
		this.planId = planId;
		this.batch = batch;
		this.daynumber = daynumber;
		this.topic = topic;
		this.status = status;
	}
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public Batch getBatch() {
		return batch;
	}
	public void setBatch(Batch batch) {
		this.batch = batch;
	}
	public int getDaynumber() {
		return daynumber;
	}
	public void setDaynumber(int daynumber) {
		this.daynumber = daynumber;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "planId=" + planId + ", batchId= " + batch.getBatchId() + ", daynumber=" + daynumber + ", topic=" + topic
				+ ", status=" + status;
	}
	
	
	
	

	
}
