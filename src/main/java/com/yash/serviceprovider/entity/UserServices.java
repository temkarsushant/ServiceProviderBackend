package com.yash.serviceprovider.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

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
@Table(name = "userservices")
public class UserServices {

	@Id
	@GeneratedValue
	private int uid;

	@ManyToOne
	@JoinColumn(name = "rid", nullable = false)
//	@JsonIgnore
	private Registration fkregistrationuserid;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "cid", nullable = false)
//	@JsonIgnore
	private Categories fkcategoryid;

	private String userrequest;

	private String reviews;

	private Boolean isPayment;

	public UserServices(Registration fkregistrationuserid, Categories fkcategoryid, String userrequest, String reviews,
			Boolean isPayment) {
		super();
		this.fkregistrationuserid = fkregistrationuserid;
		this.fkcategoryid = fkcategoryid;
		this.userrequest = userrequest;
		this.reviews = reviews;
		this.isPayment = isPayment;
	}

}
