package com.basepack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basepack.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{

}
