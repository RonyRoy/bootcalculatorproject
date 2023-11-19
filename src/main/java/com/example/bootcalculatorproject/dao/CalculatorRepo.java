package com.example.bootcalculatorproject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bootcalculatorproject.jpa.RequestResponseEntity;

@Repository
public interface CalculatorRepo extends JpaRepository<RequestResponseEntity, Long> {
	public List<RequestResponseEntity> findByRequest(String request);
}
