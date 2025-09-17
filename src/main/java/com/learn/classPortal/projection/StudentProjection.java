package com.learn.classPortal.projection;

import com.learn.classPortal.entity.Batch;

public interface StudentProjection {
	int getId();
	String getName();
	int getAge();
	String getGender();
	String getPhoneNo();
	String getEmailId();
	Batch getBatch();
}
