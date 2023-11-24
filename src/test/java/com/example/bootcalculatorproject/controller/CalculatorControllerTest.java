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
import com.example.bootcalculatorproject.dto.Response;
import com.example.bootcalculatorproject.dto.ResponseMinMax;
import com.example.bootcalculatorproject.service.CalculatorService;

@SpringBootTest
public class CalculatorControllerTest {
	@InjectMocks
	private CalculatorController cal = new CalculatorController();

	@Mock
	CalculatorService calculatorService;

	@Test
	public void getAddition() throws IOException {
		Mockito.when(calculatorService.addition(Mockito.anyDouble(), Mockito.anyDouble()))
				.thenReturn(new Response(3.4, "detail"));
		assertNotNull(cal.getAddition(33.33, 7.0));
	}

	@Test
	public void getSubtraction() throws IOException {
		Mockito.when(calculatorService.subtraction(Mockito.anyDouble(), Mockito.anyDouble()))
				.thenReturn(new Response(3.4, "detail"));
		assertNotNull(cal.getSubtraction(33.33, 7.0));
	}

	@Test
	public void getMultiplication() throws IOException {
		Mockito.when(calculatorService.multiplication(Mockito.anyDouble(), Mockito.anyDouble()))
				.thenReturn(new Response(3.4, "detail"));
		assertNotNull(cal.getMultiplication(3.0, 7.0));
	}

	@Test
	public void getDivision() throws IOException {
		Mockito.when(calculatorService.division(Mockito.anyDouble(), Mockito.anyDouble()))
				.thenReturn(new Response(3.4, "detail"));
		assertNotNull(cal.getDivision(15.0, 3.0));
	}

	@Test
	public void getSquare() throws IOException {
		Mockito.when(calculatorService.square(Mockito.anyDouble())).thenReturn(new Response(3.4, "detail"));
		assertNotNull(cal.getSquare(4.0));
	}

	@Test
	public void getSquareRoot() throws IOException {
		Mockito.when(calculatorService.squareroot(Mockito.anyDouble())).thenReturn(new Response(3.4, "detail"));
		assertNotNull(cal.getSquareRoot(144.0));
	}

	@Test
	public void getFactorial() throws IOException {
		Mockito.when(calculatorService.factorial(Mockito.anyDouble())).thenReturn(new Response(3.4, "detail"));
		assertNotNull(cal.getFactorial(5.0));
	}

	@Test
	public void getMinMax() throws IOException {
		Mockito.when(calculatorService.min_max(Mockito.any(MinMaxRequest.class)))
				.thenReturn(new ResponseMinMax("Min_Max"));
		MinMaxRequest minMaxRequest = TestDataHelper.getMinMaxRequest();
		assertNotNull(cal.getMinMax(minMaxRequest));
	}

}
