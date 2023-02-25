package com.masai.DTO;


import java.time.LocalDate;

public interface Batch {

	public int getBatchId();
	public void setBatchId(int batchId) ;
	public Faculty getFaculty();
	public void setFaculty(Faculty faculty);
	public int getNumberofStudents();
	public void setNumberofStudents(int numberofStudents);
	public LocalDate getBatchstartDate();
	public void setBatchstartDate(LocalDate batchstartDate);
	public int getDuration();
	public void setDuration(int duration);
	public Course getCourse();
	public void setCourse(Course course);
	
}
