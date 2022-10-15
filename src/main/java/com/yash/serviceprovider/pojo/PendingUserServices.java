package com.yash.serviceprovider.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PendingUserServices {

	private int usid;
	private String userrequest;
	private String ispayment;
	private String firstname;
	private String lastname;
	private String emialid;
	private String mobileno;

}
