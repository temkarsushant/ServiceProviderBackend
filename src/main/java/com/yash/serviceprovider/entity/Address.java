package com.yash.serviceprovider.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@ToString
@Entity
@Getter
@Setter
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue
	private int aid;
	private String city;
	private String localarea;
	@OneToMany(mappedBy = "fkaid")
	@JsonIgnore
	private Collection<Categories> categories = new ArrayList<>();

	public Address(String city, String localarea) {
		super();
		this.city = city;
		this.localarea = localarea;
	}

}
