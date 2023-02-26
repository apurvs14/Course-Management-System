package com.masai.DAO;

import com.masai.DTO.Faculty;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomeThingWrongException;

public interface FacultyDao {
	
	void loginFaculty(String username,String password) throws SomeThingWrongException, NoRecordFoundException;
	public void UpdatePassword(String old_password,String password) throws SomeThingWrongException, NoRecordFoundException;
	public void addFaculty(Faculty faculty) throws SomeThingWrongException;
	public void UpdateFaculty(Faculty faculty) throws SomeThingWrongException,NoRecordFoundException;
	public Faculty ViewFaculty(int faculty_id) throws SomeThingWrongException, NoRecordFoundException;
	public boolean isOldPasswordCorrect(String oldPassword) throws SomeThingWrongException;
	void logout();
	
}
