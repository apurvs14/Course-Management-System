package com.masai.DTO;

public class CourseImpl implements Course {
	
	private int courseId;
	private String courseName;
	private double fee;
	private String courseDescription;
	
	public CourseImpl() {};
	
	public CourseImpl(int courseId, String courseName, double fee, String courseDescription) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.fee = fee;
		this.courseDescription = courseDescription;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	@Override
	public String toString() {
		return "courseId=" + courseId + ", courseName=" + courseName + ", fee=" + fee
				+ ", courseDescription=" + courseDescription;
	}
	
	
	
}
