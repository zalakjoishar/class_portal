package com.learn.classPortal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.classPortal.entity.Batch;

public interface BatchRepository extends JpaRepository<Batch, Integer> {
	List<Batch> findByGenre(String genre);
	List<Batch> findByCertificate(String certificate);
}
