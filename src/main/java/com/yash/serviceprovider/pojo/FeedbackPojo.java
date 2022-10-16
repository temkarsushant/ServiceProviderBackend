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
public class FeedbackPojo {
	private String firstname;
	private String lastname;
	private String mobileno;
	private String emailid;
	private String feedback;

}
