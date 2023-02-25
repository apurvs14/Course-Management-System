package com.masai.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.masai.DTO.BatchImpl;
import com.masai.DTO.CoursePlan;
import com.masai.DTO.CoursePlanImpl;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomeThingWrongException;


//
//courseplan;
//+-----------+-------------+------+-----+---------+-------+
//| Field     | Type        | Null | Key | Default | Extra |
//+-----------+-------------+------+-----+---------+-------+
//| planid    | int         | NO   | PRI | NULL    |       |
//| batchid   | int         | NO   | MUL | NULL    |       |
//| topic     | varchar(50) | YES  |     | NULL    |       |
//| status    | tinyint(1)  | YES  |     | 0       |       |
//| daynumber | int         | YES  |     | NULL    |       |
//+-----------+-------------+------+-----+---------+-------+


public class CoursePlanDaoImpl implements CoursePlanDao {

	@Override
	public void addCoursePlan(CoursePlan courseplan) throws SomeThingWrongException {
		
		Connection connection = null;
		try {
			//connect to database
			connection = dbutils.connectTodatabase();
			//prepare the query
			String INSERT_QUERY = "INSERT INTO courseplan (planid,batchid,topic,status,daynumber) VALUES (?,?,?,?,?)";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
			
			//stuff the data in the query
			ps.setInt(1, courseplan.getPlanId());
			ps.setInt(2, courseplan.getBatch().getBatchId());
			ps.setString(3, courseplan.getTopic());
			ps.setBoolean(4, courseplan.isStatus());
			ps.setInt(5, courseplan.getDaynumber());
			
			//execute query
			ps.executeUpdate();
			System.out.println("Course Plan added succesfully");
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
	public void UpdateCoursePlan(CoursePlan courseplan) throws SomeThingWrongException, NoRecordFoundException {
		
		Connection connection = null;
		try {
			//connect to database
			connection = dbutils.connectTodatabase();
			
			//prepare the query
			String UPDATE_QUERY = "UPDATE courseplan SET"
					+ " batchid = ?,topic = ?,status = ?,daynumber = ? WHERE planid = ?";
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY);
			
			//stuff the data in the query
			ps.setInt(5, courseplan.getPlanId());
			ps.setInt(1, courseplan.getBatch().getBatchId());
			ps.setString(2, courseplan.getTopic());
			ps.setBoolean(3, courseplan.isStatus());
			ps.setInt(4, courseplan.getDaynumber());
			
			//execute query
			ps.executeUpdate();
			System.out.println("Courseplan updated successfully");
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
	public CoursePlan ViewCoursePlan(int PlanId) throws SomeThingWrongException, NoRecordFoundException {
		
		Connection connection = null;
		CoursePlan courseplan = null;
		try {
			//connect to database
			connection = dbutils.connectTodatabase();
			//prepare the query
			String SELECT_QUERY = "SELECT * FROM courseplan WHERE planid = ?";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
			ps.setInt(1, PlanId);
			//execute query
			ResultSet resultSet = ps.executeQuery();
			
			//check if result set is empty
			if(isResultSetEmpty(resultSet)) {
				throw new NoRecordFoundException(" for this batch id");
			}
			resultSet.next();
			courseplan = new CoursePlanImpl();
			
			courseplan.setPlanId(resultSet.getInt("planid"));
			
			BatchImpl batch = new BatchImpl();
			batch.setBatchId(resultSet.getInt("batchid"));
			courseplan.setBatch(batch);
			
			
			courseplan.setTopic(resultSet.getString("topic"));
			courseplan.setStatus(resultSet.getBoolean("status"));
			courseplan.setDaynumber(resultSet.getInt("daynumber"));
			
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
		return courseplan;
		
		
	}
	
	static boolean isResultSetEmpty(ResultSet rs) throws SQLException {
		return (!rs.isBeforeFirst() && rs.getRow() == 0)?true:false;
	}


}
