package com.learn.classPortal.entity;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
public class Slot {
	@Id
	private int id;
	private String day;
	private LocalTime startTime;
	//yyyy-mm-dd-hr-min
	private LocalTime endTime;
	@ManyToOne
	@JsonManagedReference
	@JsonIgnore
	private Batch batch;
	@ManyToOne
	@JsonManagedReference
	@JsonIgnore
	private ClassRoom classRoom;
}
