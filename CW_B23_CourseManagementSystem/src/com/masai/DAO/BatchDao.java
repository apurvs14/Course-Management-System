package com.masai.DAO;

import com.masai.DTO.Batch;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomeThingWrongException;

public interface BatchDao {
	
	public void addBatch(Batch batch) throws SomeThingWrongException;
	public void UpdateBatch(Batch batch) throws SomeThingWrongException,NoRecordFoundException;
	public Batch ViewBatch(int Batch_id) throws SomeThingWrongException, NoRecordFoundException;
	public void allocateFacultyToBatch(int Batch_id, int faculty_id) throws SomeThingWrongException;
	
}
