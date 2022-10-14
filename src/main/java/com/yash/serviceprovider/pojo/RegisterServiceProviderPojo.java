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
public class RegisterServiceProviderPojo {
	private int rid;
	private String sname;
	private String city;
	private String categoryname;
	private String price;

}
