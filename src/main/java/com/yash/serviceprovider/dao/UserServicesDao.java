package com.yash.serviceprovider.dao;

import java.util.List;

import com.yash.serviceprovider.entity.UserServices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserServicesDao extends JpaRepository<UserServices, Integer> {

	@Query("FROM UserServices g where g.fkregistrationuserid.rid=:rid and g.fkcategoryid.cid = :cid and g.userrequest=:userrequest ")
	List<UserServices> find(@Param("rid") int rid, @Param("cid") int cid, @Param("userrequest") String userrequest);

	@Query("FROM UserServices g where g.fkregistrationuserid.rid=:rid and g.userrequest=:userrequest and isPayment=false")
	List<UserServices> find(@Param("rid") int rid, @Param("userrequest") String userrequest);

	@Modifying
	@Query("UPDATE UserServices g set g.isPayment=:isPayment where g.fkregistrationuserid.rid=:rid and g.isPayment=false ")
	void save(@Param("rid") int rid,@Param("isPayment") Boolean isPayment);

	@Query("FROM UserServices g where g.userrequest=:userrequest and g.isPayment=true")
	List<UserServices> find(@Param("userrequest") String userrequest);

}
