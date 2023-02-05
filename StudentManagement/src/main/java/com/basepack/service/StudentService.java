package com.basepack.service;

import java.util.List;

import com.basepack.entity.Student;



public interface StudentService {
	
	public List<Student> findAll();
	
	public Student findById(long theId);
	
	public void save(Student theBook);
	
	public void deleteById(long theId);

}
