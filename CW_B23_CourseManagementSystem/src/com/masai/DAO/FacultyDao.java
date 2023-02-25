package com.masai.DAO;

import com.masai.DTO.Faculty;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomeThingWrongException;

public interface FacultyDao {
	
	public void loginFaculty(String username,String password) throws SomeThingWrongException, NoRecordFoundException;
	public void UpdatePassword(String username,String password) throws SomeThingWrongException;
	public void addFaculty(Faculty faculty) throws SomeThingWrongException;
	public void UpdateFaculty(Faculty faculty) throws SomeThingWrongException,NoRecordFoundException;
	public Faculty ViewFaculty(int faculty_id) throws SomeThingWrongException, NoRecordFoundException;
	
}
