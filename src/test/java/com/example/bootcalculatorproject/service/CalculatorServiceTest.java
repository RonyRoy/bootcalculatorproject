package com.example.bootcalculatorproject.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.bootcalculatorproject.dao.CalculatorRepo;
import com.example.bootcalculatorproject.dataHelper.TestDataHelper;
import com.example.bootcalculatorproject.dto.MinMaxRequest;
import com.example.bootcalculatorproject.jpa.RequestResponseEntity;

@SpringBootTest
public class CalculatorServiceTest {

	@InjectMocks
	private CalculatorService calculatorService = new CalculatorService();

	@Mock
	CalculatorRepo calculatorRepo;

	RequestResponseEntity requestResponseEntity = new RequestResponseEntity();

	public void setup() throws IOException {
		requestResponseEntity = TestDataHelper.getRequestResponseEntity();
		List<RequestResponseEntity> requestResponseEntityList = new ArrayList<>();
		requestResponseEntityList.add(requestResponseEntity);
		Mockito.when(calculatorRepo.save(Mockito.any(RequestResponseEntity.class))).thenReturn(requestResponseEntity);
		Mockito.when(calculatorRepo.findByRequest(Mockito.anyString())).thenReturn(requestResponseEntityList);
	}

	@Test
	public void saveRequstResponse() throws IOException {
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

	@Test
	public void addition() throws IOException {
		setup();
		assertNotNull(calculatorService.addition(10.0, 9.0));
	}

	@Test
	public void subtraction() throws IOException {
		setup();
		assertNotNull(calculatorService.subtraction(10.0, 4.0));
	}

	@Test
	public void multiplication() throws IOException {
		setup();
		assertNotNull(calculatorService.multiplication(2.0, 9.0));
	}

	@Test
	public void division() throws IOException {
		setup();
		assertNotNull(calculatorService.division(10.0, 2.0));
	}

	@Test
	public void square() throws IOException {
		setup();
		assertNotNull(calculatorService.square(4.0));
	}

	@Test
	public void squareroot() throws IOException {
		setup();
		assertNotNull(calculatorService.squareroot(16.0));
	}

	@Test
	public void factorial() throws IOException {
		setup();
		assertNotNull(calculatorService.factorial(5.0));
	}

	@Test
	public void min_max() throws IOException {
		setup();
		MinMaxRequest minMaxRequest = TestDataHelper.getMinMaxRequest();
		assertNotNull(calculatorService.min_max(minMaxRequest));
	}
}
