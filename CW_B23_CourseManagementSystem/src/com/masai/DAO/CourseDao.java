package com.masai.DAO;

import com.masai.DTO.Course;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomeThingWrongException;

public interface CourseDao {
	
	public void addCourse(Course course) throws SomeThingWrongException;
	public void UpdateCourse(Course course) throws SomeThingWrongException,NoRecordFoundException;
	public Course ViewCourse(int courseId) throws SomeThingWrongException, NoRecordFoundException;
	
}
