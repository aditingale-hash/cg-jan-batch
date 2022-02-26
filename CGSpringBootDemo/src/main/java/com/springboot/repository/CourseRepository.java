package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.model.Course;
import com.springboot.model.Instructor;

public interface CourseRepository extends JpaRepository<Course, Long>{
	
	@Query("select i from Instructor i join i.course c where c.id=?1")
	List<Instructor> getInstructorByCourseId(Long cid);

}
