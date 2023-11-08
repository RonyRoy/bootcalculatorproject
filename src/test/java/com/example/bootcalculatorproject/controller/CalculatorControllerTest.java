package com.example.bootcalculatorproject.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.bootcalculatorproject.dataHelper.TestDataHelper;
import com.example.bootcalculatorproject.dto.MinMaxRequest;
import com.example.bootcalculatorproject.dto.Response;
import com.example.bootcalculatorproject.dto.ResponseMinMax;

@SpringBootTest
public class CalculatorControllerTest {
	private CalculatorController cal = new CalculatorController();

	@Test
	public void getAddition() {
		Response res = new Response(40.33, "description");
		assertEquals(res.getAnswer().toString(), cal.getAddition(33.33, 7.0).getAnswer().toString());
	}

	@Test
	public void getSubtraction() {
		Response res = new Response(26.33, "description");
		assertEquals(res.getAnswer().toString(), cal.getSubtraction(33.33, 7.0).getAnswer().toString());
	}

	@Test
	public void getMultiplication() {
		Response res = new Response(21.0, "description");
		assertEquals(res.getAnswer().toString(), cal.getMultiplication(3.0, 7.0).getAnswer().toString());
	}

	@Test
	public void getDivision() {
		Response res = new Response(5.0, "description");
		assertEquals(res.getAnswer().toString(), cal.getDivision(15.0, 3.0).getAnswer().toString());
	}

	@Test
	public void getSquare() {
		Response res = new Response(16.0, "description");
		assertEquals(res.getAnswer().toString(), cal.getSquare(4.0).getAnswer().toString());
	}

	@Test
	public void getSquareRoot() {
		Response res = new Response(12.0, "description");
		assertEquals(res.getAnswer().toString(), cal.getSquareRoot(144.0).getAnswer().toString());
	}

	@Test
	public void getFactorial() {
		Response res = new Response(120.0, "description");
		assertEquals(res.getAnswer().toString(), cal.getFactorial(5.0).getAnswer().toString());
	}

	@Test
	public void getMinMax() {
		MinMaxRequest minMaxRequest = TestDataHelper.getMinMaxRequest();
		ResponseMinMax res = new ResponseMinMax(90, -100);
		assertEquals(res.getMax(), cal.getMinMax(minMaxRequest).getMax());
	}
}
