package com.learn.classPortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.learn.classPortal.entity.ClassRoom;
import com.learn.classPortal.projection.ClassRoomProjection;

@CrossOrigin
@RepositoryRestResource(path = "classRoom", excerptProjection = ClassRoomProjection.class)
public interface ClassRoomRepository extends JpaRepository<ClassRoom, Integer> {

}
