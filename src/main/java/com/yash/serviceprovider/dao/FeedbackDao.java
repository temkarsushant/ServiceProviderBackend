package com.yash.serviceprovider.dao;

import com.yash.serviceprovider.entity.Feedback;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackDao extends JpaRepository<Feedback, Integer> {

}
