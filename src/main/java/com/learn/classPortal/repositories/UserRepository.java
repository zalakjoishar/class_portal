package com.learn.classPortal.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.learn.classPortal.entity.User;
import com.learn.classPortal.projection.UserProjection;

@CrossOrigin
@RepositoryRestResource(path = "user",excerptProjection = UserProjection.class)
public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmailId(String email);
  boolean existsByEmailId(String email);


}
