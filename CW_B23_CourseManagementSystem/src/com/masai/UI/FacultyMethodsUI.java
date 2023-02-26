package com.masai.UI;

import java.util.Scanner;

import com.masai.DAO.BatchDao;
import com.masai.DAO.BatchDaoImpl;
import com.masai.DAO.CourseDao;
import com.masai.DAO.CourseDaoImpl;
import com.masai.DAO.FacultyDao;
import com.masai.DAO.FacultyDaoImpl;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomeThingWrongException;

public class FacultyMethodsUI {
	
	private CourseDao courseDao;
	private Scanner scanner;
	private BatchDao batchDao;
	private FacultyDao facultyDao;
	
	
	public FacultyMethodsUI(Scanner scanner) {
		batchDao = new BatchDaoImpl();
		courseDao = new CourseDaoImpl();
		facultyDao = new FacultyDaoImpl();
		this.scanner = scanner;
	}
	

	public boolean login() {
		boolean loginSuccessful = false;
		//code to take input username and password
		System.out.print("Enter username ");
		String username = scanner.next();
		
		System.out.print("Enter password ");
		String password = scanner.next();
		
		try {
			facultyDao.loginFaculty(username, password);
			loginSuccessful = true;
		}catch(SomeThingWrongException | NoRecordFoundException ex) {
			System.out.println(ex);
		}
		return loginSuccessful;
	}
	
	
	public void changePassword() {
		//code to take input new name
		System.out.print("Enter old password ");
		String oldPassword = scanner.next();
		
		System.out.print("Enter new password ");
		String newPassword = scanner.next();
		
		System.out.print("Re-type new password ");
		String newPasswordAgain = scanner.next();
		if(newPassword.equals(newPasswordAgain)) {
			try {
				facultyDao.UpdatePassword(oldPassword, newPassword);
				System.out.println("Password updated successfully");
			}catch(SomeThingWrongException |NoRecordFoundException ex) {
				System.out.println(ex);
			}			
		}else {
			System.out.println("New password mismatched with re-typed new password");
		}
	}
	
	public void logout() {
		facultyDao.logout();
	}
	
	
	

}


























