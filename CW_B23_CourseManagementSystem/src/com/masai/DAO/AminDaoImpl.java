package com.masai.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomeThingWrongException;



public class AminDaoImpl implements AdminDao {

	@Override
	public void loginAdmin(String username, String password) throws SomeThingWrongException{

		Connection connection = null;
		try {
			//connect to database
			connection = dbutils.connectTodatabase();
			//prepare the query
			String LOGIN_QUERY = "SELECT * FROM admin WHERE username = ? AND password = ?";
			
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
