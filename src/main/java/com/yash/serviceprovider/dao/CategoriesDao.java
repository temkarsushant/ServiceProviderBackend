package com.yash.serviceprovider.dao;

import java.util.List;

import com.yash.serviceprovider.entity.Categories;
import com.yash.serviceprovider.entity.ServiceProvider;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesDao extends JpaRepository<Categories, Integer>{

	List<Categories> findByFkcategories(ServiceProvider serviceProvider);

}
