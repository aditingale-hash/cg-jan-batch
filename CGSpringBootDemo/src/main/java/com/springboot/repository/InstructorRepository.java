package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.model.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long>{

	@Query("select MIN(i.salary) as max, MAX(i.salary) as sal, COUNT(i.id) as cnt from Instructor i")
	List<Double[]> getMaxSalary();

}


/*
	List list = [{80000,  88000,  2.0}]
	
	Double[] d = list.get(0);
	
	d={80000,  88000,  2.0};
	
	d[0] 
	d[1]
	d[2]
*/