package com.example.bootcalculatorproject.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.bootcalculatorproject.dataHelper.TestDataHelper;
import com.example.bootcalculatorproject.dto.MinMaxRequest;
import com.example.bootcalculatorproject.service.CalculatorService;

@SpringBootTest
public class CalculatorControllerTest {
	@InjectMocks
	private CalculatorController cal = new CalculatorController();

	@Mock
	CalculatorService calculatorService;

	public void setup() throws IOException {
		Mockito.when(calculatorService.findByRequest(Mockito.anyString()))
				.thenReturn(TestDataHelper.getRequestResponseEntity());
	}

	@Test
	public void getAddition() throws IOException {
		setup();
		assertNotNull(cal.getAddition(33.33, 7.0));
	}

	@Test
	public void getSubtraction() throws IOException {
		setup();
		assertNotNull(cal.getSubtraction(33.33, 7.0));
	}

	@Test
	public void getMultiplication() throws IOException {
		setup();
		assertNotNull(cal.getMultiplication(3.0, 7.0));
	}

	@Test
	public void getDivision() throws IOException {
		setup();
		assertNotNull(cal.getDivision(15.0, 3.0));
	}

	@Test
	public void getSquare() throws IOException {
		setup();
		assertNotNull(cal.getSquare(4.0));
	}

	@Test
	public void getSquareRoot() throws IOException {
		setup();
		assertNotNull(cal.getSquareRoot(144.0));
	}

	@Test
	public void getFactorial() throws IOException {
		setup();
		assertNotNull(cal.getFactorial(5.0));
	}

	@Test
	public void getMinMax() throws IOException {
		setup();
		MinMaxRequest minMaxRequest = TestDataHelper.getMinMaxRequest();
		assertNotNull(cal.getMinMax(minMaxRequest));
	}

}
