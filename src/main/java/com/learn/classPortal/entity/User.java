package com.learn.classPortal.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false,length=20)
	private String name;
	private String phoneNo;
	@Column(unique = true, nullable = false)
	private String emailId;
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
             fetch = FetchType.EAGER)
	@JoinTable(name = "user_role",
             joinColumns = @JoinColumn(name = "user_id"),
             inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	private String password;
	public User(String name, String phoneNo, String emailId, String password) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		this.password = password;
	}
	
	
}
