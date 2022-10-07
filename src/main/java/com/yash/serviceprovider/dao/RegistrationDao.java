package com.yash.serviceprovider.dao;

import com.yash.serviceprovider.entity.Registration;
import com.yash.serviceprovider.pojo.Login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationDao extends JpaRepository<Registration, Integer> {

	public Registration save(Registration registration);

	public Registration getByEmailid(String emailid);
	
}
