package com.learn.classPortal.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Batch {
	@Id
	private int id;
	@Column(nullable = false,length=20)
	private String name;
	private String day;
	@Column(nullable = false,length=20)
	private String certification;
	@Column(nullable = false,length=20)
	private String genre;
	@ManyToOne
	@JsonManagedReference
	private ClassRoom classRoom;
	@ManyToOne
	@JsonManagedReference
	private Trainer trainer;
	@ManyToOne
	@JsonManagedReference
	private Coordinator coordinator;
	@OneToMany(mappedBy = "batch")
	@JsonBackReference
	private List<Student> student;
	@OneToMany(mappedBy = "batch")
	@JsonBackReference
	private List<Event> event;
	@OneToMany(mappedBy = "batch")
	@JsonBackReference
	private List<Slot> slot;
}
