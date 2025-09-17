package com.learn.classPortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.learn.classPortal.entity.Student;
import com.learn.classPortal.projection.StudentProjection;

@RepositoryRestResource(path = "student", excerptProjection = StudentProjection.class)
@CrossOrigin
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
