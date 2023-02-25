package com.masai.DAO;


import com.masai.DTO.CoursePlan;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomeThingWrongException;

public interface CoursePlanDao {
		
	public void addCoursePlan(CoursePlan courseplan) throws SomeThingWrongException;
	public void UpdateCoursePlan(CoursePlan courseplan) throws SomeThingWrongException,NoRecordFoundException;
	public CoursePlan ViewCoursePlan(int PlanId) throws SomeThingWrongException, NoRecordFoundException;
	
}
