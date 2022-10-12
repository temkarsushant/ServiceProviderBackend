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
@Entity
@Getter
@Setter
@Table(name = "categories")
public class Categories {

	@Id
	@GeneratedValue
	private int cid;
	private String categoryname;
	@ManyToOne
	@JoinColumn(name = "sid", nullable = false)
	@JsonIgnore
	private ServiceProvider fkcategories;

	@OneToMany(mappedBy = "fkcategoryid")
	@JsonIgnore
	private Collection<UserServices> userservices = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "aid", nullable = false)
	@JsonIgnore
	private Address fkaid;
	
	private int price;

	public Categories(String categoryname, ServiceProvider fkcategories, Address fkaid) {
		super();
		this.categoryname = categoryname;
		this.fkcategories = fkcategories;
		this.fkaid = fkaid;
	}

}
