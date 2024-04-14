package com.patika.kredinbizdeservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patika.kredinbizdeservice.model.CardApplication;
import com.patika.kredinbizdeservice.model.LoanApplication;

public interface CardApplicationRepository extends JpaRepository<CardApplication, Long> {

	List<CardApplication> findByUserId(Long id);

}
