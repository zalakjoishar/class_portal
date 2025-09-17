package com.learn.classPortal.projection;

import java.sql.Date;

import org.springframework.data.rest.core.config.Projection;

import com.learn.classPortal.entity.Batch;
import com.learn.classPortal.entity.Event;

@Projection(types = {Event.class})
public interface EventProjection {
	int getId();
	String getName();
	Date getDate();
	String getLocation();
	Batch getBatch();
}
