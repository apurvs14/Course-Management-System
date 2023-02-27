package com.masai.UI;

import java.util.Scanner;

import com.masai.DAO.LoggedINFaculty;

public class ProjectUIMain {
	
	private static FacultyMethodsUI fac;
	private static AdminMethodsUI admin;

	
	static void displayAdminMenu() {
		System.out.println("---------------------------");
		System.out.println("How can we help you today");
		System.out.println("1.Courses Operations");
		System.out.println("2.Batch Operations");
		System.out.println("3.Faculty Operations");
		System.out.println("4.CoursePlan Operations");
		System.out.println("0.Exit");
		System.out.println("---------------------------");
	}
	
	static void coursedisplay() {
		System.out.println("---------------------------");
		System.out.println("1.Create a New Course");
		System.out.println("2.Update details of a Course");
		System.out.println("3.View details of a Course");
		System.out.println("0.Exit");
		System.out.println("---------------------------");
	}
	
	static void coursefun() {
		Scanner sc = new Scanner(System.in);
		
		int select = 0;
		do {
			coursedisplay();
			select = sc.nextInt();
			switch(select) {
			case 0:
				adminMenu(sc);
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
			default:
				System.out.println("Invalid Selection, try again");
				System.out.println();
			}
			
		} while(select!=0);
		sc.close();
		
	}
	
	static void Batchdisplay() {
		System.out.println("---------------------------");
		System.out.println("1.Create a New Batch");
		System.out.println("2.Update details of a Batch");
		System.out.println("3.View details of a Batch");
		System.out.println("0.Exit");
		System.out.println("---------------------------");
	}
	
	static void Batchfun() {
		Scanner sc = new Scanner(System.in);
		
		int select = 0;
		do {
			Batchdisplay();
			select = sc.nextInt();
			switch(select) {
			case 0:
				adminMenu(sc);
				break;
			case 1:
				admin.addNewBatch();
				break;
			case 2:
				admin.updatetheBatch();
				break;
			case 3:
				admin.ViewTheBatch();
				break;
			default:
				System.out.println("Invalid Selection, try again");
				System.out.println();
			}
			
		} while(select!=0);
		sc.close();
		
	}
	
	static void Facultydisplay() {
		System.out.println("---------------------------");
		System.out.println("1.Create a New Faculty");
		System.out.println("2.Update details of a Faculty");
		System.out.println("3.View details of a Faculty");
		System.out.println("4.Allocate Faculty to a batch");
		System.out.println("0.Exit");
		System.out.println("---------------------------");
	}
	
	static void Facultyfun() {
		Scanner sc = new Scanner(System.in);
		
		int select = 0;
		do {
			Facultydisplay();
			select = sc.nextInt();
			switch(select) {
			case 0:
				adminMenu(sc);
				break;
			case 1:
				admin.addNewFaculty();
				break;
			case 2:
				admin.UpdateTheFaculty();
				break;
			case 3:
				admin.ViewTheFaculty();
				break;
			case 4:
				admin.allotFaculty();
				break;
			default:
				System.out.println("Invalid Selection, try again");
				System.out.println();
			}
			
		} while(select!=0);
		sc.close();
		
		
	}
	
	static void CoursePlandisplay() {
		System.out.println("---------------------------");
		System.out.println("1.Create a New CoursePlan");
		System.out.println("2.Update details of a CoursePlan");
		System.out.println("3.View details of a CoursePlan");
		System.out.println("0.Exit");
		System.out.println("---------------------------");
	}
	
	static void CoursePlanfun() {
		Scanner sc = new Scanner(System.in);
		
		int select = 0;
		do {
			CoursePlandisplay();
			select = sc.nextInt();
			switch(select) {
			case 0:
				adminMenu(sc);
				break;
			case 1:
				admin.CreateCoursePlan();
				break;
			case 2:
				admin.UpdateCoursePlan();
				break;
			case 3:
				admin.ViewTheCoursePlan();
				break;
			default:
				System.out.println("Invalid Selection, try again");
				System.out.println();
			}
			
		} while(select!=0);
		sc.close();
		
		
	}
	
	
	
	static void adminMenu(Scanner sc) {
		int choice = 0;
		do {
			displayAdminMenu();
			System.out.print("Enter selection ");
			choice = sc.nextInt();
			switch(choice) {
				case 0:
					System.out.println("Visit again admin");
					break;
				case 1:
					coursefun();
					break;
				case 2:
					Batchfun();
					break;
				case 3:
					Facultyfun();
					break;
				case 4:
					CoursePlanfun();
					break;
				default:
					System.out.println("Invalid Selection, try again");
					System.out.println();
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
			System.out.println();
		}
	}
	
	
	
	static void displayfacultyMenu(){
		System.out.println("-----------------------------");
		System.out.println("1. View course plan");
		System.out.println("2. Update/Change password");
		System.out.println("0. Logout");
		System.out.println("-----------------------------");
		
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
					System.out.println();
			}
		}while(LoggedINFaculty.loggedInFacultyId != 0);
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		admin = new AdminMethodsUI(sc);
		fac = new FacultyMethodsUI(sc);
		int choice = 0;
		do {
			System.out.println("=========Welcome to the Course Monitoring System=========\nEnter your choice");
			System.out.println("1. Admin Login\n2. Faculty Login\n0. Exit");
			System.out.println("=========================================================");
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
					System.out.println();
			}
		}while(choice != 0);
		sc.close();
		
	}
	
}
