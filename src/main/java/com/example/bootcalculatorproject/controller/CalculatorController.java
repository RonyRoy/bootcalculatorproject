package com.example.bootcalculatorproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bootcalculatorproject.dto.MinMaxRequest;
import com.example.bootcalculatorproject.dto.Operation;
import com.example.bootcalculatorproject.dto.Response;
import com.example.bootcalculatorproject.dto.ResponseMinMax;
import com.example.bootcalculatorproject.jpa.RequestResponseEntity;
import com.example.bootcalculatorproject.service.CalculatorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/calculatorapi/v1")
@Slf4j
public class CalculatorController {
	@Autowired
	CalculatorService calculatorService;

	@Cacheable(value = "requestResponseEntity", cacheManager = "requestResponseEntityManager")
	@GetMapping(path = "/addition")
	public Response getAddition(@RequestParam(name = "number1") Double num1,
			@RequestParam(name = "number2") Double num2) {
		log.error("<< CalculatorController ::: getAddition method Start >>");
		Response response = calculatorService.addition(num1, num2);
		return response;
	}

	@Cacheable(value = "requestResponseEntity", cacheManager = "requestResponseEntityManager")
	@GetMapping(path = "/subtraction")
	public Response getSubtraction(@RequestParam(name = "number1") Double num1,
			@RequestParam(name = "number2") Double num2) {
		log.error("<< CalculatorController ::: getSubtraction method Start >>");
		Response response = calculatorService.subtraction(num1, num2);
		return response;
	}

	@Cacheable(value = "requestResponseEntity", cacheManager = "requestResponseEntityManager")
	@GetMapping(path = "/multiplication")
	public Response getMultiplication(@RequestParam(name = "number1") Double num1,
			@RequestParam(name = "number2") Double num2) {
		log.error("<< CalculatorController ::: getMultiplication method Start >>");
		Response response = calculatorService.multiplication(num1, num2);
		return response;
	}

	@Cacheable(value = "requestResponseEntity", cacheManager = "requestResponseEntityManager")
	@GetMapping(path = "/division")
	public Response getDivision(@RequestParam(name = "number1") Double num1,
			@RequestParam(name = "number2") Double num2) {
		log.error("<< CalculatorController ::: getDivision method Start >>");
		Response response = calculatorService.division(num1, num2);
		return response;
	}

	@Cacheable(value = "requestResponseEntity", cacheManager = "requestResponseEntityManager")
	@GetMapping(path = "/square/{number}")
	public Response getSquare(@PathVariable Double number) {

		log.error("<< CalculatorController ::: getSquare method Start >>");
		Response response = calculatorService.square(number);
		return response;
	}

	@Cacheable(value = "requestResponseEntity", cacheManager = "requestResponseEntityManager")
	@GetMapping(path = "/squareroot/{number}")
	public Response getSquareRoot(@PathVariable Double number) {
		log.error("<< CalculatorController ::: getSquareRoot method Start >>");
		Response response = calculatorService.squareroot(number);
		return response;
	}

	@Cacheable(value = "requestResponseEntity", cacheManager = "requestResponseEntityManager")
	@GetMapping(path = "/factorial/{num}")
	public Response getFactorial(@PathVariable Double num) {
		log.error("<< CalculatorController ::: getFactorial method Start >>");
		Response response = calculatorService.factorial(num);
		return response;
	}

	@Cacheable(value = "requestResponseEntity", cacheManager = "requestResponseEntityManager")
	@PostMapping("/min-max")
	public ResponseMinMax getMinMax(@RequestBody MinMaxRequest minMaxRequest) {
		log.error("<< CalculatorController ::: getMinMax method Start >>");
		ResponseMinMax response = calculatorService.min_max(minMaxRequest);
		return response;
	}

	@Cacheable(value = "requestResponseEntity", cacheManager = "requestResponseEntityManager")
	@GetMapping(path = "/findById/{id}")
	public RequestResponseEntity getResult(@PathVariable Long id) {
		log.error("<< logs of getFactorial method >>" + calculatorService.findById(id).toString());
		return calculatorService.findById(id);
	}

}
