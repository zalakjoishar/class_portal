package com.learn.classPortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.learn.classPortal.entity.Slot;
import com.learn.classPortal.projection.SlotProjection;

@CrossOrigin
@RepositoryRestResource(path = "slot",excerptProjection = SlotProjection.class)
public interface SlotRepository extends JpaRepository<Slot, Integer> {

}
