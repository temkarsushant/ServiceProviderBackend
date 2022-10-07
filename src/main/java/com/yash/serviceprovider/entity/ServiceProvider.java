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
@Table(name = "service_provider")
public class ServiceProvider {

	@Id
	@GeneratedValue
	private int sid;
	private String sname;

	@ManyToOne
	@JoinColumn(name = "rid", nullable = false)
	@JsonIgnore
	private Registration fkregistrationid;

	
	@OneToMany(mappedBy="fkcategories")
	@JsonIgnore
	private Collection<Categories> Categories = new ArrayList<>();


	public ServiceProvider(String sname, Registration fkregistrationid) {
		super();
		this.sname = sname;
		this.fkregistrationid = fkregistrationid;
	}
	
	
	
}
