package com.learn.classPortal.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class ClassRoom {
	@Id
	private int id;
	@Column(nullable = false,length=20)
	private String name;
	@OneToMany(mappedBy = "classRoom")
	@JsonIgnore
	private List<Batch> batch;
	@OneToMany(mappedBy = "classRoom")
	@JsonIgnore
	private List<Slot> slot;
}
