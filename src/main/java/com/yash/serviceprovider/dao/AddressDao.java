package com.yash.serviceprovider.dao;

import com.yash.serviceprovider.entity.Address;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDao extends JpaRepository<Address, Integer> {

}
