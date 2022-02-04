package com.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.main.model.Student;

public class App {
	public static void main(String[] args) {
		DBConfig db = new DBConfig();
		Scanner sc = new Scanner(System.in);  
		System.out.println("Welcome to the Project");
		Student s=new Student();
		while(true){
			System.out.println("****MENU******");
			System.out.println("Press 1. for insertion");
			System.out.println("Press 2. for deletion");
			System.out.println("Press 3. for updation");
			System.out.println("Press 4. for fetching the data");
			System.out.println("Press 0. to exit");
			System.out.println("*************");
			int input = sc.nextInt();
			if(input == 0) { //termination condition- to come out of while
				System.out.println("Exiting... Bye!!");
				break;
			}	
			switch(input) {
			case 1:
				
				System.out.println("Enter Student Details");
				System.out.println("Enter student name");
				s.setName(sc.next()); //take input and save it in object
				System.out.println("Enter city");
				s.setCity(sc.next());
				System.out.println("Enter Age");
				s.setAge(sc.nextInt());
				System.out.println("Enter Department ID");
				s.setDepartmentId(sc.nextInt());
				db.insertStudent(s); //pass object to DB class
				System.out.println("Record Inserted...");
				break;
			case 2: 
				System.out.println("Deletion Operation");
				System.out.println("Enter Student ID to delete");
				int id = sc.nextInt();
				db.deleteStudent(id);
				System.out.println("Student Record Deleted...");
				break;
			case 3:
				System.out.println("Update Operation");
				System.out.println("Enter the ID of student to update");
				id = sc.nextInt();
				Student student = db.fetchStudentById(id);
				System.out.println("Existing details for student with ID "+ id + " are:");
				System.out.println(student.getName() + "   " + student.getCity() + "   " 
								   + student.getAge() + "  " + student.getDepartmentId());
				System.out.println("Please provide new details to update");
				System.out.println("Enter Student Details");
				System.out.println("Enter student name");
				s.setName(sc.next()); //take input and save it in object
				System.out.println("Enter city");
				s.setCity(sc.next());
				System.out.println("Enter Age");
				s.setAge(sc.nextInt());
				System.out.println("Enter Department ID");
				s.setDepartmentId(sc.nextInt());
				db.updateStudent(s,id);
				System.out.println("Student Info Updated...");
				break;
			case 4:
				System.out.println("All Student Records");
				System.out.println("**********************************************");
				System.out.println("ID\tNAME\t\tCITY\tAGE\tDEPT_ID");
				System.out.println("-----------------------------------------------");
				List<Student> list= db.fetchAllStudents();
				for(Student stud : list) {
					System.out.println(stud.getId() + "\t" + stud.getName() + "\t" 
							+ stud.getCity() + "   " + stud.getAge() + "\t" + stud.getDepartmentId());
				}
				System.out.println("**********************************************");
				break;
			default:
				
			}
		}
	}
}
