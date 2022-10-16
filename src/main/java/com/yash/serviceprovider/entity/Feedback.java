package com.yash.serviceprovider.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "feedback")
public class Feedback {
	@Id
	@GeneratedValue
	private int fid;
	private String firstname;
	private String lastname;
	private String mobileno;
	private String emailid;
	private String feedback;

	public Feedback(String firstname, String lastname, String mobileno, String emailid, String feedback) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobileno = mobileno;
		this.emailid = emailid;
		this.feedback = feedback;
	}

}
