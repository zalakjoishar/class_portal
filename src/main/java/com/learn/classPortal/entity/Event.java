package com.learn.classPortal.entity;

import java.sql.Date;

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
public class Event {
	@Id
	private int id;
	@Column(nullable = false,length=20)
	private String name;
	private Date date;
	private String location;
	@ManyToOne
	@JsonBackReference
	private Batch batch;
}
