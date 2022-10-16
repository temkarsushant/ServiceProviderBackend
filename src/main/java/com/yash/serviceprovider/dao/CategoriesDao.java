package com.yash.serviceprovider.dao;

import java.util.List;
import java.util.Optional;

import com.yash.serviceprovider.entity.Address;
import com.yash.serviceprovider.entity.Categories;
import com.yash.serviceprovider.entity.ServiceProvider;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoriesDao extends JpaRepository<Categories, Integer> {

	@Query("FROM Categories g where g.fkaid.aid=:aid and g.fkcategories.sid = :sid ORDER BY g.price DESC")
	List<Categories> findAllByServiceProviderAndAddress(@Param("sid") int sid, @Param("aid") int aid);

	@Query("FROM Categories g where cid=:cid")
	Categories findByFkCategoryId(@Param("cid") int id);

}
