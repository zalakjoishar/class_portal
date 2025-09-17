package com.learn.classPortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.learn.classPortal.entity.Trainer;
import com.learn.classPortal.projection.TrainerProjection;

@CrossOrigin
@RepositoryRestResource(path = "trainer",excerptProjection = TrainerProjection.class )
public interface TrainerRepository extends JpaRepository<Trainer, Integer> {

}
