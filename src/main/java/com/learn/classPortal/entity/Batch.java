package com.learn.classPortal.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@Column(nullable = false, length = 20)
	private String name;

	@Column(nullable = false, length = 20)
	private String certification;

	@Column(nullable = false, length = 20)
	private String genre;

	@ManyToOne
	@JsonIgnore
	private ClassRoom classRoom;

	@ManyToOne
	@JsonIgnore
	private Trainer trainer;

	@ManyToOne
	@JsonIgnore
	private Coordinator coordinator;

	@OneToMany(mappedBy = "batch")
	@JsonBackReference("student-batch")
	@JsonIgnore
	private List<Student> student;

	@OneToMany(mappedBy = "batch")
	@JsonBackReference("event-batch")
	@JsonIgnore
	private List<Event> event;

	@OneToMany(mappedBy = "batch")
	@JsonBackReference("slot-batch")
	@JsonIgnore
	private List<Slot> slot;
}
