package com.masai.UI;

import java.util.Scanner;

import com.masai.DAO.LoggedINFaculty;

public class ProjectUIMain {
	
	private static FacultyMethodsUI fac;
	private static AdminMethodsUI admin;

	
	static void displayAdminMenu() {
		System.out.println("How can we help you today");
		System.out.println("1.Create a New Course");
		System.out.println("2.Update details of a Course");
		System.out.println("3.View details of a Course");
		System.out.println("4.Create a New Batch");
		System.out.println("5.Update details of a Batch");
		System.out.println("6.View details of a Batch");
		System.out.println("7.Create a New Faculty");
		System.out.println("8.Update details of a Faculty");
		System.out.println("9.View details of a Faculty");
		System.out.println("10.Allocate Faculty to a batch");
		System.out.println("11.Create a New CoursePlan");
		System.out.println("12.Update details of a CoursePlan");
		System.out.println("13.View details of a CoursePlan");
		System.out.println("0.Exit");
	}
	
	static void adminMenu(Scanner sc) {
		int choice = 0;
		do {
			displayAdminMenu();
			System.out.print("Enter selection ");
			choice = sc.nextInt();
			switch(choice) {
				case 0:
					System.out.println("Bye Bye admin");
					break;
				case 1:
					admin.addNewCourse();
					break;
				case 2:
					admin.upadateCourse();
					break;
				case 3:
					admin.ViewTheCourse();
					break;
				case 4:
					admin.addNewBatch();
					break;
				case 5:
					admin.updatetheBatch();
					break;
				case 6:
					admin.ViewTheBatch();
					break;
				case 7:
					admin.addNewFaculty();
					break;
				case 8:
					admin.UpdateTheFaculty();
					break;
				case 9:
					admin.ViewTheFaculty();
					break;
				case 10:
					admin.allotFaculty();
					break;
					
				default:
					System.out.println("Invalid Selection, try again");
			}
		}while(choice != 0);
	}
	
	
	static void adminLogin(Scanner sc) {
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		
		if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
			adminMenu(sc);
		}else {
			System.out.println("Invalid Username and Password");
		}
	}
	
	
	
static void displayfacultyMenu(){
		
		System.out.println("1. View course plan");
		System.out.println("2. Update/Change password");
//		System.out.println("3. Fill day wise planner");
		System.out.println("0. Logout");
		
	}
	
	
	static void FacultyLogin(Scanner sc) {
		
		if(!fac.login()) {
			return;
		}
		
		
		int choice = 0;
		do {
			displayfacultyMenu();
			System.out.print("Enter selection ");
			choice = sc.nextInt();
			switch(choice) {
				case 1:
					admin.ViewTheCoursePlan();
					break;
				case 2:
					fac.changePassword();
					break;
				case 0:
					fac.logout();
					break;
				default:
					System.out.println("Invalid Selection, try again");
			}
		}while(LoggedINFaculty.loggedInFacultyId != 0);
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		admin = new AdminMethodsUI(sc);
		fac = new FacultyMethodsUI(sc);
		int choice = 0;
		do {
			System.out.println("1. Admin Login\n2. Faculty Login\n0. Exit");
			choice = sc.nextInt();
			switch(choice) {
				case 0:
					System.out.println("Thank you, Visit again");
					break;
				case 1:
					adminLogin(sc);
					break;
				case 2:
					FacultyLogin(sc);
					break;
				default:
					System.out.println("Invalid Selection, try again");
			}
		}while(choice != 0);
		sc.close();
		
	}
	
}
