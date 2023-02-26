package com.masai.UI;

import java.time.LocalDate;
import java.util.Scanner;

import com.masai.DAO.BatchDao;
import com.masai.DAO.BatchDaoImpl;
import com.masai.DAO.CourseDao;
import com.masai.DAO.CourseDaoImpl;
import com.masai.DAO.CoursePlanDao;
import com.masai.DAO.CoursePlanDaoImpl;
import com.masai.DAO.FacultyDao;
import com.masai.DAO.FacultyDaoImpl;
import com.masai.DTO.Batch;
import com.masai.DTO.BatchImpl;
import com.masai.DTO.Course;
import com.masai.DTO.CourseImpl;
import com.masai.DTO.CoursePlan;
import com.masai.DTO.CoursePlanImpl;
import com.masai.DTO.Faculty;
import com.masai.DTO.FacultyImpl;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomeThingWrongException;

public class AdminMethodsUI {
	private CourseDao courseDao;
	private Scanner scanner;
	private BatchDao batchDao;
	private FacultyDao facultyDao;
	private CoursePlanDao courseplanDao;
	
	
	public AdminMethodsUI(Scanner scanner) {
		courseplanDao = new CoursePlanDaoImpl();
		batchDao = new BatchDaoImpl();
		courseDao = new CourseDaoImpl();
		facultyDao = new FacultyDaoImpl();
		this.scanner = scanner;
	}

	public void addNewCourse() {
		
		//code to take input Course details
				System.out.print("Enter course id ");
				int courseId = scanner.nextInt();
				System.out.print("Enter course name ");
				String courseName = scanner.next();
				System.out.print("Enter fee ");
				double fee = scanner.nextDouble();
				System.out.print("Enter course description ");
				String courseDesc = scanner.next();
				
				//create object for Course with Course id ,name,fee and coursedesc;
				Course course = new CourseImpl(courseId, courseName,fee,courseDesc);
				
				try {
					courseDao.addCourse(course);
					System.out.println("Course added successfully");
				}catch(SomeThingWrongException ex) {
					System.out.println(ex);
				}
		
		
	}
	
	public void upadateCourse() {
		
		
		//code to take input Course details
		System.out.print("Enter course id ");
		int courseId = scanner.nextInt();
		System.out.print("Enter course name ");
		String courseName = scanner.next();
		System.out.print("Enter fee ");
		double fee = scanner.nextDouble();
		System.out.print("Enter course description ");
		String courseDesc = scanner.next();
		
		//create object for Course with Course id ,name,fee and coursedesc;
		Course course = new CourseImpl(courseId, courseName,fee,courseDesc);
		
		try {
			courseDao.UpdateCourse(course);
			System.out.println("Course Updated successfully");
		}catch(SomeThingWrongException | NoRecordFoundException ex) {
			System.out.println(ex);
		}
		
		
	}
	
	public void ViewTheCourse() {
		
		
		//code to take input Course details
		System.out.print("Enter course id ");
		int courseId = scanner.nextInt();
		
		
		
		try {
			Course course = courseDao.ViewCourse(courseId);
			System.out.println(course);
		}catch(SomeThingWrongException | NoRecordFoundException ex) {
			System.out.println(ex);
		}
		
		
	}
	
	
	public void addNewBatch() {
		
		//code to take input Batch details
				System.out.print("Enter batch id ");
				int BatchId = scanner.nextInt();
				System.out.print("Enter CourseId ");
				int CourseId = scanner.nextInt();
				System.out.print("Enter FacultyId ");
				int FacultyId = scanner.nextInt();
				System.out.print("Enter Number of Students ");
				int TotalStudents = scanner.nextInt();
				System.out.print("Enter Batch start date ");
				LocalDate StartDate = LocalDate.parse(scanner.next());
				System.out.print("Enter Duration in days");
				int Duration = scanner.nextInt();
				
				//create object for batch with all details
				Batch batch= new BatchImpl(BatchId, new FacultyImpl(FacultyId,null, null, null, null,null,null) ,new CourseImpl(CourseId, null,0.00,null), TotalStudents, StartDate,Duration);
				
				try {
					batchDao.addBatch(batch);
					System.out.println("Batch added successfully");
				}catch(SomeThingWrongException ex) {
					System.out.println(ex);
				}
		
	}
	
	public void updatetheBatch() {
		
		//code to take input Batch details
		System.out.print("Enter batch id ");
		int BatchId = scanner.nextInt();
		System.out.print("Enter CourseId ");
		int CourseId = scanner.nextInt();
		System.out.print("Enter FacultyId ");
		int FacultyId = scanner.nextInt();
		System.out.print("Enter Number of Students ");
		int TotalStudents = scanner.nextInt();
		System.out.print("Enter Batch start date ");
		LocalDate StartDate = LocalDate.parse(scanner.next());
		System.out.print("Enter Duration in days");
		int Duration = scanner.nextInt();
		
		//create object for batch with all details
		Batch batch= new BatchImpl(BatchId, new FacultyImpl(FacultyId,null, null, null, null,null,null) ,new CourseImpl(CourseId, null,0.00,null), TotalStudents, StartDate,Duration);
		
		try {
			batchDao.UpdateBatch(batch);
			System.out.println("Batch added successfully");
		}catch(SomeThingWrongException | NoRecordFoundException  ex) {
			System.out.println(ex);
		}
		
	}
	
	
	public void ViewTheBatch() {
		//code to take input Batch details
				System.out.print("Enter batch id ");
				int BatchId = scanner.nextInt();
				
				try {
					Batch batch = batchDao.ViewBatch(BatchId);
					System.out.println(batch);
				}catch(SomeThingWrongException | NoRecordFoundException ex) {
					System.out.println(ex);
				}
	
		
	}
	
	
	
	public void addNewFaculty() {
	
		
		//code to take input Course details
				System.out.print("Enter faculty id ");
				int facultyid = scanner.nextInt();
				System.out.print("Enter faculty name ");
				String facultyname = scanner.next();
				System.out.print("Enter faculty address ");
				String facultyaddress = scanner.next();
				System.out.print("Enter faculty mobile number ");
				String mobile = scanner.next();
				System.out.print("Enter faculty email id");
				String email = scanner.next();
				System.out.print("Enter faculty username");
				String username = scanner.next();
				System.out.print("Enter faculty password");
				String password = scanner.next();
				
				//create object for Course with Course id ,name,fee and coursedesc;
				Faculty faculty = new FacultyImpl(facultyid,facultyname,facultyaddress,mobile,email,username,password);
				
				try {
					facultyDao.addFaculty(faculty);
					System.out.println("Faculty added successfully");
				}catch(SomeThingWrongException ex) {
					System.out.println(ex);
				}
		
		
	}

	public void UpdateTheFaculty() {
	
	
	//code to take input Course details
			System.out.print("Enter faculty id ");
			int facultyid = scanner.nextInt();
			System.out.print("Enter faculty name ");
			String facultyname = scanner.next();
			System.out.print("Enter faculty address ");
			String facultyaddress = scanner.next();
			System.out.print("Enter faculty mobile number ");
			String mobile = scanner.next();
			System.out.print("Enter faculty email id");
			String email = scanner.next();
			System.out.print("Enter faculty username");
			String username = scanner.next();
			System.out.print("Enter faculty password");
			String password = scanner.next();
			
			//create object for Course with Course id ,name,fee and coursedesc;
			Faculty faculty = new FacultyImpl(facultyid,facultyname,facultyaddress,mobile,email,username,password);
			
			try {
				facultyDao.UpdateFaculty(faculty);
				System.out.println("Faculty details updated successfully");
			}catch(SomeThingWrongException | NoRecordFoundException ex) {
				System.out.println(ex);
			}
	
	
}

	public void ViewTheFaculty() {
	
	
	//code to take input Course details
			System.out.print("Enter faculty id ");
			int facultyid = scanner.nextInt();
			 
			
			try {
				Faculty faculty = facultyDao.ViewFaculty(facultyid);
				System.out.println(faculty);
			}catch(SomeThingWrongException | NoRecordFoundException ex) {
				System.out.println(ex);
			}
	
	
	}
	
	
	public void allotFaculty() {
		
		System.out.print("Enter faculty id ");
		int facultyid = scanner.nextInt();
		System.out.print("Enter Batch");
		int Batchid = scanner.nextInt();
		
		
		try {
			batchDao.allocateFacultyToBatch(Batchid,facultyid);
			System.out.println("Faculty alloted successfully");
		}catch(SomeThingWrongException ex) {
			System.out.println(ex);
		}
		
		
	}
	
//	public void CreateCoursePlan() {
//		
//				//code to take input Batch details
//				System.out.print("Enter PlanId ");
//				int planId = scanner.nextInt();
//				System.out.print("Enter BatchId ");
//				int BatchId = scanner.nextInt();
//				System.out.print("Enter Day Number ");
//				int daynumber = scanner.nextInt();
//				System.out.print("Enter status true - if completed\nfalse - if pending");
//				boolean status = scanner.nextBoolean();
//				
//				
//				//create object for batch with all details
//				CoursePlanDao CoursePlan = new CoursePlanDaoImpl();
//				CoursePlan.setPlanId();
////				CoursePlan CoursePlan = new CoursePlanImpl();
//				
//				try {
//					courseplanDao.addCoursePlan(CoursePlan);
//					System.out.println("Batch added successfully");
//				}catch(SomeThingWrongException ex) {
//					System.out.println(ex);
//				}
//		
//	}
	
	public void ViewTheCoursePlan() {
		//code to take input Batch details
			System.out.print("Enter PlanId ");
			int planId = scanner.nextInt();
				
				try {
					CoursePlan CoursePlan = courseplanDao.ViewCoursePlan(planId);
					System.out.println(CoursePlan);
				}catch(SomeThingWrongException | NoRecordFoundException ex) {
					System.out.println(ex);
				}
	
		
	}
	
	
	

}















