package com.learn.classPortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.classPortal.entity.Trainer;

public interface TrainerRepository extends JpaRepository<Trainer, Integer> {

}
