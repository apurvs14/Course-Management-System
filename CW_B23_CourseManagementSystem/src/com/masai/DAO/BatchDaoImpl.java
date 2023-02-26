package com.masai.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.DTO.Batch;
import com.masai.DTO.BatchImpl;

import com.masai.DTO.CourseImpl;
import com.masai.DTO.FacultyImpl;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomeThingWrongException;

public class BatchDaoImpl implements BatchDao{

	@Override
	public void addBatch(Batch batch) throws SomeThingWrongException {
		
		Connection connection = null;
		try {
			//connect to database
			connection = dbutils.connectTodatabase();
			//prepare the query
			String INSERT_QUERY = "INSERT INTO batch (batchid,courseid, facultyid,number_of_students,startdate,durationdays) VALUES (?,?,?,?,?,?)";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
			
			//stuff the data in the query
			ps.setInt(1, batch.getBatchId());
			ps.setInt(2, batch.getCourse().getCourseId());
			ps.setInt(3, batch.getFaculty().getFacultyid());
			ps.setInt(4, batch.getNumberofStudents());
			ps.setDate(5, Date.valueOf(batch.getBatchstartDate()));
			ps.setInt(6, batch.getDuration());
			
			//execute query
			ps.executeUpdate();
		}catch(SQLException sqlEx) {
			sqlEx.printStackTrace();
			//code to log the error in the file
			throw new SomeThingWrongException();
		}finally {
			try {
				//close the exception
				dbutils.closeConnection(connection);				
			}catch(SQLException sqlEX) {
				throw new SomeThingWrongException();
			}
		}
		
	}

	@Override
	public void UpdateBatch(Batch batch) throws SomeThingWrongException, NoRecordFoundException {
		
		Connection connection = null;
		try {
			//connect to database
			connection = dbutils.connectTodatabase();
			
			//prepare the query
			String UPDATE_QUERY = "UPDATE batch SET courseid = ?,facultyid = ?,number_of_students = ?,startdate = ?,durationdays = ? WHERE batchid = ?";
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY);
			
			//stuff the data in the query
			ps.setInt(6, batch.getBatchId());
			ps.setInt(1, batch.getCourse().getCourseId());
			ps.setInt(2, batch.getFaculty().getFacultyid());
			ps.setInt(3, batch.getNumberofStudents());
			ps.setDate(4, Date.valueOf(batch.getBatchstartDate()));
			ps.setInt(5, batch.getDuration());
			
			//execute query
			ps.executeUpdate();
		}catch(SQLException sqlEx) {
			//code to log the error in the file
			throw new SomeThingWrongException();
		}finally {
			try {
				//close the exception
				dbutils.closeConnection(connection);				
			}catch(SQLException sqlEX) {
				throw new SomeThingWrongException();
			}
		}	
		
	}

	@Override
	public Batch ViewBatch(int Batch_id) throws SomeThingWrongException, NoRecordFoundException {
		Connection connection = null;
		Batch batch = null;
		try {
			//connect to database
			connection = dbutils.connectTodatabase();
			//prepare the query
			String SELECT_QUERY = "SELECT * FROM batch WHERE batchid = ?";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
			ps.setInt(1, Batch_id);
			//execute query
			ResultSet resultSet = ps.executeQuery();
			
			//check if result set is empty
			if(isResultSetEmpty(resultSet)) {
				throw new NoRecordFoundException(" for this batch id");
			}
			resultSet.next();
			batch = new BatchImpl();
			batch.setBatchId(resultSet.getInt("batchid"));
			
			CourseImpl course = new CourseImpl();
			course.setCourseId(resultSet.getInt("courseid"));
			batch.setCourse(course);
			batch.setNumberofStudents(resultSet.getInt("number_of_students"));
			
			FacultyImpl fac = new FacultyImpl();
			fac.setFacultyid(resultSet.getInt("facultyid"));
			batch.setFaculty(fac);
			
			batch.setBatchstartDate(resultSet.getDate("startdate").toLocalDate());
			batch.setDuration(resultSet.getInt("durationdays"));

			
		}catch(SQLException sqlEx) {
			//code to log the error in the file
			throw new SomeThingWrongException();
		}finally {
			try {
				//close the exception
				dbutils.closeConnection(connection);				
			}catch(SQLException sqlEX) {
				throw new SomeThingWrongException();
			}
		}
		return batch;
	}

@Override
public void allocateFacultyToBatch(int Batch_id, int faculty_id)
			throws SomeThingWrongException {
		
	Connection connection = null;
	try {
		//connect to database
		connection = dbutils.connectTodatabase();
		
		//prepare the query
		String QUERY = "UPDATE batch SET facultyid=? WHERE batchid=?";
		//get the prepared statement object
		PreparedStatement ps = connection.prepareStatement(QUERY);
		
		//stuff the data in the query
		ps.setInt(1, faculty_id);
		ps.setInt(2, Batch_id);
		
		//execute query
		ps.executeUpdate();
		}catch(SQLException sqlEx) {
		//code to log the error in the file
		throw new SomeThingWrongException();
		}finally {
		try {
			//close the exception
			dbutils.closeConnection(connection);				
		}catch(SQLException sqlEX) {
			throw new SomeThingWrongException();
		}
	}	
		
		
	}
	

	static boolean isResultSetEmpty(ResultSet rs) throws SQLException {
		return (!rs.isBeforeFirst() && rs.getRow() == 0)?true:false;
	}

}
