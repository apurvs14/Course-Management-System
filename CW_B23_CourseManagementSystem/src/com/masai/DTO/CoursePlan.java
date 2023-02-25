package com.masai.DTO;

public interface CoursePlan {

	public int getPlanId();
	public void setPlanId(int planId);
	public Batch getBatch();
	public void setBatch(Batch batch);
	public int getDaynumber();
	public void setDaynumber(int daynumber);
	public String getTopic();
	public void setTopic(String topic);
	public boolean isStatus();
	public void setStatus(boolean status);
	
}
