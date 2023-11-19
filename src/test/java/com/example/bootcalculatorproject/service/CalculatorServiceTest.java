package com.example.bootcalculatorproject.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.bootcalculatorproject.dao.CalculatorRepo;
import com.example.bootcalculatorproject.dataHelper.TestDataHelper;
import com.example.bootcalculatorproject.jpa.RequestResponseEntity;

@SpringBootTest
public class CalculatorServiceTest {
	
	@InjectMocks
	private CalculatorService calculatorService = new CalculatorService();

	@Mock
	CalculatorRepo calculatorRepo;

	@Test
	public void saveRequstResponse() throws IOException {
		RequestResponseEntity requestResponseEntity = TestDataHelper.getRequestResponseEntity();
		Mockito.when(calculatorRepo.save(Mockito.any(RequestResponseEntity.class))).thenReturn(requestResponseEntity);
		calculatorService.saveRequstResponse(requestResponseEntity);
		assertNotNull(calculatorService);
	}

	@Test
	public void findById() {
		try {
			calculatorService.findById(1L);
		} catch (Exception e) {
			assertNotNull(e);
		}
	}
}
