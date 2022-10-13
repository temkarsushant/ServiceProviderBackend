package com.yash.serviceprovider.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserServicePojo {
	private int rid;
	private int cid;
	private String userrequest;
	private String reviews;
	private Boolean isPayment;
	private int uid;
}
