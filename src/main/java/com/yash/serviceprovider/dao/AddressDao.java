package com.yash.serviceprovider.dao;

import com.yash.serviceprovider.entity.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

public interface AddressDao extends JpaRepository<Address, Integer> {

	@Query("FROM Address g where g.city=:city")
	Address findByCity(@RequestParam("city") String city);

}
