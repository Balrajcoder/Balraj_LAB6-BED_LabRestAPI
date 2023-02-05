package com.basepack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basepack.entity.Student;
import com.basepack.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		

		List<Student> theStudents = studentRepository.findAll();
		return theStudents;
		
	}

	@Override
	public Student findById(long theId) {
	
		
		Optional<Student> student= studentRepository.findById(theId);
		
		if(student.isPresent())
		{
			return student.get();
			
		}
		else
		{
		  throw new RuntimeException("Did not find student id - " + theId);
		}
		
	}

	@Override
	public void save(Student thestudent) {
		
		studentRepository.save(thestudent);
		
	}

	@Override
	public void deleteById(long theId) {
		
		studentRepository.deleteById(theId);
		
	}

}
