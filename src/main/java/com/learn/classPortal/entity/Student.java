package com.learn.classPortal.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
	@Id
	private int id;
	@Column(nullable = false,length=20)
	private String name;
	@Column(nullable = false)
	private int age;
	private String gender;
	private String phoneNo;
	@Column(unique = true, nullable = false)
	private String emailId;
	@ManyToOne
	@JsonBackReference
	private Batch batch;
}
