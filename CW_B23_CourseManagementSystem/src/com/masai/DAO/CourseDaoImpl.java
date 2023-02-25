package com.masai.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.DTO.Course;
import com.masai.DTO.CourseImpl;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomeThingWrongException;

public class CourseDaoImpl implements CourseDao {

	public void addCourse(Course course) throws SomeThingWrongException {
		
		Connection connection = null;
		try {
			//connect to database
			connection = dbutils.connectTodatabase();
			//prepare the query
			String INSERT_QUERY = "INSERT INTO course (course_id, course_name,fee,course_description) VALUES (?, ?,?,?)";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
			
			//stuff the data in the query
			ps.setInt(1, course.getCourseId());
			ps.setString(2, course.getCourseName());
			ps.setDouble(3, course.getFee());
			ps.setString(4, course.getCourseDescription());
			
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

	public void UpdateCourse(Course course) throws SomeThingWrongException,NoRecordFoundException {
		
//		getCourseById(course.getCourseId());
		//you are here means course found for the given course id

		Connection connection = null;
		try {
			//connect to database
			connection = dbutils.connectTodatabase();
			
			//prepare the query
			String UPDATE_QUERY = "UPDATE course SET course_name = ?,fee = ?,course_description = ? WHERE course_id = ?";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY);
			
			//stuff the data in the query
			ps.setString(1, course.getCourseName());
			ps.setDouble(2, course.getFee());
			ps.setString(3, course.getCourseDescription());
			ps.setInt(4, course.getCourseId());
			
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

	public Course ViewCourse(int courseId) throws SomeThingWrongException, NoRecordFoundException {
		
		Connection connection = null;
		Course course = null;
		try {
			//connect to database
			connection = dbutils.connectTodatabase();
			//prepare the query
			String SELECT_QUERY = "SELECT * FROM course WHERE course_id = ?";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
			ps.setInt(1, courseId);
			//execute query
			ResultSet resultSet = ps.executeQuery();
			
			//check if result set is empty
			if(isResultSetEmpty(resultSet)) {
				throw new NoRecordFoundException(" for this course id");
			}
			resultSet.next();
			course = new CourseImpl();
			course.setCourseId(resultSet.getInt("course_id"));
			course.setCourseName(resultSet.getString("course_name"));
			course.setFee(resultSet.getDouble("fee"));
			course.setCourseDescription(resultSet.getString("course_description"));
			
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
		return course;
		
	}

	static boolean isResultSetEmpty(ResultSet rs) throws SQLException {
		return (!rs.isBeforeFirst() && rs.getRow() == 0)?true:false;
	}
	
	
	
}












