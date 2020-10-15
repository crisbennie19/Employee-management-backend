package com.starkmark.restapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
	
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
private long id;

@Column(name = "first_name")
private String firstname;

@Column(name = "last_name")
private String lastname;

@Column(name = "email_id")
private String emailId;



}
