package com.yash.serviceprovider.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "registration")
public class Registration {

	@Id
	@GeneratedValue
	private int rid;
	private String firstname;
	private String lastname;
	private String mobileno;
	private String emailid;
	private String password;
	private String confirmpassword;
	private String usertype;
	
	@OneToMany(mappedBy = "fkregistrationid")
	@JsonIgnore
	private Collection<ServiceProvider> serviceProviders = new ArrayList<>();

	@OneToMany(mappedBy = "fkregistrationuserid")
	@JsonIgnore
	private Collection<UserServices> userservices = new ArrayList<>();

	public Registration(String firstname, String lastname, String mobileno, String emailid) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobileno = mobileno;
		this.emailid = emailid;
	}
}
