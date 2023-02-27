package com.masai.DTO;

import java.time.LocalDate;

public class BatchImpl implements Batch {
	
	private int batchId;
	private Course course;
	private Faculty faculty;
	private int numberofStudents;;
	private LocalDate batchstartDate;
	private int duration;
	
	
	public BatchImpl() {}
	
	public BatchImpl(int batchId) {
		
		this.batchId = batchId;
		
	}
	
	public BatchImpl(int batchId, Faculty faculty,Course course, int numberofStudents, LocalDate batchstartDate, int duration) {
		super();
		this.batchId = batchId;
		this.faculty = faculty;
		this.course = course;
		this.numberofStudents = numberofStudents;
		this.batchstartDate = batchstartDate;
		this.duration = duration;
		
	}
	
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public int getNumberofStudents() {
		return numberofStudents;
	}
	public void setNumberofStudents(int numberofStudents) {
		this.numberofStudents = numberofStudents;
	}
	public LocalDate getBatchstartDate() {
		return batchstartDate;
	}
	public void setBatchstartDate(LocalDate batchstartDate) {
		this.batchstartDate = batchstartDate;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		
		return "-----------------------------\n Batch ID : " + batchId + ",\n Course ID : " + course.getCourseId() + ",\n Faculty ID : " + faculty.getFacultyid() + ",\n Number Of Students : "
				+ numberofStudents + ",\n Batch Start Date : " + batchstartDate + ",\n Duration : " + duration +"\n-----------------------------";
	}
	

	
}
