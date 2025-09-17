package com.learn.classPortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.learn.classPortal.entity.Coordinator;
import com.learn.classPortal.projection.CoordinatorProjection;

@CrossOrigin
@RepositoryRestResource(path = "coordinator",excerptProjection = CoordinatorProjection.class)
public interface CoordinatorRepository extends JpaRepository<Coordinator, Integer> {

}
