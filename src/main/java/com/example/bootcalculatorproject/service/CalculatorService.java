package com.example.bootcalculatorproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bootcalculatorproject.dao.CalculatorRepo;
import com.example.bootcalculatorproject.jpa.RequestResponseEntity;

@Service
public class CalculatorService {
	@Autowired
	CalculatorRepo calculatorRepo;

	public void saveRequstResponse(RequestResponseEntity requestResponseEntity) {
		calculatorRepo.save(requestResponseEntity);
	}

	public RequestResponseEntity findById(Long id) {
		return calculatorRepo.findById(id).get();
	}

	public RequestResponseEntity findByRequest(String request) {
		List<RequestResponseEntity> requestResponseEntityList = calculatorRepo.findByRequest(request);
		if (!requestResponseEntityList.isEmpty())
			return requestResponseEntityList.get(0);
		else
			return null;
	}

}
