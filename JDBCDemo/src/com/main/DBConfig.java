package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.main.model.Student;

public class DBConfig {

	/*
	 * Step 1: Declare all DB Variables
	 */
	private String userDB="root";
	private String passDB="";
	private String url="jdbc:mysql://localhost:3306/collegedb";
	private String driver="com.mysql.cj.jdbc.Driver";
	
	private Connection conn;
	
	public void dbConnect() {
		//Load the Driver
		try {
			Class.forName(driver);
			//System.out.println("driver loaded");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver loading issue..");
			e.printStackTrace();
		}
		//establish the connection 
		try {
			conn = DriverManager.getConnection(url, userDB, passDB);
			//System.out.println("conn made " + conn);
		} catch (SQLException e) {
			System.out.println("DB Connection Issue..");
			e.printStackTrace();
		} 
	}
	
	public void dbClose() {
		try {
			conn.close();
			//System.out.println("conn closed");
		} catch (SQLException e) {
			System.out.println("DB Close Issue...");
			e.printStackTrace();
		}
	}
	
	public void insertStudent(Student s)   {
		dbConnect();
		String sql="insert into student(name,city,age,dept_id) values (?,?,?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getName());
			pstmt.setString(2, s.getCity());
			pstmt.setInt(3, s.getAge());
			pstmt.setInt(4, s.getDepartmentId());
			
			/*
			 * executeQuery() : select 
			 * executeUpdate() : insert, delete, update/edit
			 */
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dbClose();
	}

	public void deleteStudent(int id) {
		dbConnect();
		String sql="delete from student where id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL Issue");
			e.printStackTrace();
		}
		dbClose();
		
	}

	public Student fetchStudentById(int id) {
		dbConnect();
		String sql="select * from student where id=?";
		Student s = new Student();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rst = pstmt.executeQuery();
			
			while(rst.next()) {
				String name = rst.getString("name");
				String city = rst.getString("city");
				int age = rst.getInt("age");
				int dept_id = rst.getInt("dept_id");
				
				s.setId(id);
				s.setName(name);
				s.setCity(city);
				s.setAge(age);
				s.setDepartmentId(dept_id);
				
			}
		} catch (SQLException e) {
			System.out.println("SQL Issue");
			e.printStackTrace();
		}
		dbClose();
		return s;
		
	}

	public void updateStudent(Student s, int id) {
		dbConnect();
		String sql="update student SET name=?,city=?,age=?,dept_id=? where id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getName());
			pstmt.setString(2, s.getCity());
			pstmt.setInt(3, s.getAge());
			pstmt.setInt(4, s.getDepartmentId());
			pstmt.setInt(5, id);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL Issue");
			e.printStackTrace();
		}
		dbClose();
		
	}
}
/*
 ResultSet rst=
 * +----+------------------+----------+------+---------+
| id | name             | city     | age  | dept_id |
+----+------------------+----------+------+---------+
|  1 | harry potter     | hogwards |   18 |       2 |
==> convert ==> Student Object()

rst.next() -> true
 */









