package com.patika.kredinbizdeservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.patika.kredinbizdeservice.model.Bank;
@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

	Optional<Bank> findByName(String name);

}
