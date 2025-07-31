package com.learn.classPortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.classPortal.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
