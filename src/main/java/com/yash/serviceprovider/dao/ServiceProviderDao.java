package com.yash.serviceprovider.dao;

import com.yash.serviceprovider.entity.ServiceProvider;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceProviderDao extends JpaRepository<ServiceProvider, Integer>{

}
