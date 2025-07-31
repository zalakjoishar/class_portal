package com.learn.classPortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.classPortal.entity.ClassRoom;

public interface ClassRoomRepository extends JpaRepository<ClassRoom, Integer> {

}
