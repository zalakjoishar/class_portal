package com.learn.classPortal.projection;

import java.time.LocalTime;

import com.learn.classPortal.entity.Batch;
import com.learn.classPortal.entity.ClassRoom;

public interface SlotProjection {
	int getId();
	String getDay();
	LocalTime getStartTime();
	LocalTime getEndTime();
	Batch getBatch();
	ClassRoom getClassRoom();
}
