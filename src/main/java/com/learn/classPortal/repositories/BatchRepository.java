package com.learn.classPortal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.learn.classPortal.entity.Batch;
import com.learn.classPortal.projection.BatchProjection;

@RepositoryRestResource(path = "batch",excerptProjection = BatchProjection.class)
@CrossOrigin
public interface BatchRepository extends JpaRepository<Batch, Integer> {
	List<Batch> findByGenre(String genre);
	List<Batch> findBycertification(String certification);
}
