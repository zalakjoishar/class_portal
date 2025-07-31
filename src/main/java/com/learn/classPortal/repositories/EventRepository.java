package com.learn.classPortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.classPortal.entity.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {

}
