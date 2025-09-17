package com.learn.classPortal.projection;

import org.springframework.data.rest.core.config.Projection;

import com.learn.classPortal.entity.User;

@Projection(types = {User.class})
public interface UserProjection {
	int getId();
	String getName();
	String getPhoneNo();
	String getEmailId();
	String getRole();
	String getPassword();
	String getImage();
}
