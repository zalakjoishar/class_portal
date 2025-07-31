package com.learn.classPortal.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Trainer {
	@Id
	private int id;
	@Column(nullable = false,length=20)
	private String name;
	private String phoneNo;
	@Column(unique = true, nullable = false)
	private String emailId;
	@OneToMany(mappedBy = "trainer")
	@JsonBackReference
	private List<Batch> batch;
}
