package com.yash.serviceprovider.dao;

import com.yash.serviceprovider.entity.ServiceProvider;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface ServiceProviderDao extends JpaRepository<ServiceProvider, Integer> {

	@Query("FROM ServiceProvider g where sname=:sname")
	ServiceProvider findByName(@RequestParam("sname") String sname);

}
