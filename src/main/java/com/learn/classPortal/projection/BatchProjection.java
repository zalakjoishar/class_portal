package com.learn.classPortal.projection;

import com.learn.classPortal.entity.ClassRoom;
import com.learn.classPortal.entity.Coordinator;
import com.learn.classPortal.entity.Trainer;

public interface BatchProjection {
	int getId();
	String getName();
	String getCertification();
	String getGenre();
	ClassRoom getClassRoom();
	Trainer getTrainer();
	Coordinator getCoordinator();
}