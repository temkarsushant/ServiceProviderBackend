package com.yash.serviceprovider.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConfirmPassword {
	private String emailid;
	private String password;
	private String confirmnewpassword;
}
