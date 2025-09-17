package com.learn.classPortal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	@Id
	private int id;
	@Column(nullable = false,length=20)
	private String name;
	private String phoneNo;
	@Column(unique = true, nullable = false)
	private String emailId;
	private String role;
	private String password;
	private String image;

}
