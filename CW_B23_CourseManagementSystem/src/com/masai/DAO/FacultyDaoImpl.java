package com.masai.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.DTO.Faculty;
import com.masai.DTO.FacultyImpl;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomeThingWrongException;

public class FacultyDaoImpl implements FacultyDao{

	@Override
	public void addFaculty(Faculty faculty) throws SomeThingWrongException {
		
		Connection connection = null;
		try {
			//connect to database
			connection = dbutils.connectTodatabase();
			//prepare the query
			String INSERT_QUERY = "INSERT INTO faculty "
					+ "(facultyid,facultyname,facultyaddress,mobile,email,userName,password) VALUES (?,?,?,?,?,?,?)";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
			
			//stuff the data in the query
			ps.setInt(1, faculty.getFacultyid());
			ps.setString(2, faculty.getFacultyname());
			ps.setString(3, faculty.getFacultyaddress());
			ps.setString(4, faculty.getMobile());
			ps.setString(5, faculty.getEmail());
			ps.setString(6, faculty.getUsername());
			ps.setString(7, faculty.getPassword());
			
			
			//execute query
			ps.executeUpdate();
		}catch(SQLException sqlEx) {
			sqlEx.printStackTrace();
			//code to log the error in the file
			throw new SomeThingWrongException();
		}finally {
			try {
				//close the connection
				dbutils.closeConnection(connection);				
			}catch(SQLException sqlEX) {
				throw new SomeThingWrongException();
			}
		}
		
		
	}

	@Override
	public void UpdateFaculty(Faculty faculty) throws SomeThingWrongException, NoRecordFoundException {
		
		Connection connection = null;
		try {
			//connect to database
			connection = dbutils.connectTodatabase();
			
			//prepare the query
			String UPDATE_QUERY = "UPDATE course SET "
					+ "facultyname = ?,facultyaddress = ?,mobile = ?,email = ?,userName = ?,password = ? WHERE facultyid = ?";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY);
			
			//stuff the data in the query
			ps.setInt(7, faculty.getFacultyid());
			ps.setString(1, faculty.getFacultyname());
			ps.setString(2, faculty.getFacultyaddress());
			ps.setString(3, faculty.getMobile());
			ps.setString(4, faculty.getEmail());
			ps.setString(5, faculty.getUsername());
			ps.setString(6, faculty.getPassword());
			
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
	public Faculty ViewFaculty(int faculty_id) throws SomeThingWrongException, NoRecordFoundException {

		Connection connection = null;
		Faculty faculty = null;
		try {
			//connect to database
			connection = dbutils.connectTodatabase();
			//prepare the query
			String SELECT_QUERY = "SELECT * FROM course WHERE facultyid = ?";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
			ps.setInt(1, faculty_id);
			//execute query
			ResultSet resultSet = ps.executeQuery();
			
			//check if result set is empty
			if(isResultSetEmpty(resultSet)) {
				throw new NoRecordFoundException(" for this course id");
			}
			resultSet.next();
			faculty = new FacultyImpl();
			faculty.setFacultyid(resultSet.getInt("facultyid"));
			faculty.setFacultyname(resultSet.getString("facultyname"));
			faculty.setFacultyaddress(resultSet.getString("facultyaddress"));
			faculty.setMobile(resultSet.getString("mobile"));
			faculty.setEmail(resultSet.getString("email"));
			faculty.setUsername(resultSet.getString("userName"));
			faculty.setPassword(resultSet.getString("password"));
			
			

			
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

		return faculty;
	}

	static boolean isResultSetEmpty(ResultSet rs) throws SQLException {
		return (!rs.isBeforeFirst() && rs.getRow() == 0)?true:false;
	}

	@Override
	public void UpdatePassword(String username,String password) throws SomeThingWrongException {
		
		Connection connection = null;
		try {
			//connect to database
			connection = dbutils.connectTodatabase();
			
			//prepare the query
			String QUERY = "UPDATE faculty SET password=? WHERE userName=?";
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(QUERY);
			
			//stuff the data in the query
			ps.setString(1, username);
			ps.setString(1, password);
			
			
			//execute query
			ps.executeUpdate();
			System.out.println("Password Changed Succesfully");
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
	public void loginFaculty(String username, String password) throws SomeThingWrongException, NoRecordFoundException {
		Connection connection = null;
		try {
			//connect to database
			connection = dbutils.connectTodatabase();
			//prepare the query
			String LOGIN_QUERY = "SELECT * FROM faculty WHERE username = ? AND password = ?";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(LOGIN_QUERY);
			
			//stuff the data in the query
			ps.setString(1, username);
			ps.setString(2, password);
			
			//execute query
			ResultSet resultSet = ps.executeQuery();
			if(dbutils.isResultSetEmpty(resultSet)) {
				throw new NoRecordFoundException("Invalid Username and Password");
			} else {
				
				System.out.println("Welcome " + username);
				
			}
			
			//you are here means username and password combination is correct
			resultSet.next();

		}catch(SQLException sqlEx) {
			//code to log the error in the file
			throw new SomeThingWrongException();
		} catch (NoRecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//close the exception
				dbutils.closeConnection(connection);				
			}catch(SQLException sqlEX) {
				throw new SomeThingWrongException();
			}
		
	}

		
	}
	
	
	
	
}
