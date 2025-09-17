package com.learn.classPortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.learn.classPortal.entity.User;

@CrossOrigin
@RepositoryRestResource(path = "user")
public interface UserRepository extends JpaRepository<User, Integer> {

}
