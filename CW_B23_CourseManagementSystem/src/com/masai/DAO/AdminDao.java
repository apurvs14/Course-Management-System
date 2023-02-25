package com.masai.DAO;

import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomeThingWrongException;

public interface AdminDao {
		
	public void loginAdmin(String username,String password) throws SomeThingWrongException, NoRecordFoundException;

}
