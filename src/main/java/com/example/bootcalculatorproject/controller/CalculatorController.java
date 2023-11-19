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
		RequestResponseEntity requestResponseEntity = new RequestResponseEntity();
		Double add = 0.0;
		Response response = null;
		Long t = System.currentTimeMillis();
		requestResponseEntity = calculatorService.findByRequest((num1.toString()) + " + " + (num2.toString()));

		if (null != requestResponseEntity) {
			log.error("<< logs of getAddition method RequestResponseEntity >>>" + requestResponseEntity.toString());
			response = new Response(Double.parseDouble(requestResponseEntity.getResponse()),
					requestResponseEntity.getRequest() + " = " + (requestResponseEntity.getResponse()));
		} else {
			add = num1 + num2;
			requestResponseEntity = setDataInRepo((num1.toString()) + " + " + (num2.toString()), (add.toString()),
					Operation.ADDITION.getName(), t);
			response = new Response(add, (num1.toString()) + " + " + (num2.toString()) + " = " + (add.toString()));
			calculatorService.saveRequstResponse(requestResponseEntity);
		}
		log.error("<< logs of getAddition method >>" + response.toString());
		return response;
	}

	@Cacheable(value = "requestResponseEntity", cacheManager = "requestResponseEntityManager")
	@GetMapping(path = "/subtraction")
	public Response getSubtraction(@RequestParam(name = "number1") Double num1,
			@RequestParam(name = "number2") Double num2) {
		RequestResponseEntity requestResponseEntity = new RequestResponseEntity();
		Double subtract = 0.0;
		Response response = null;
		Long t = System.currentTimeMillis();
		requestResponseEntity = calculatorService.findByRequest(num1.toString() + " - " + num2.toString());

		if (null != requestResponseEntity) {
			log.error("<< logs of getSubtraction method RequestResponseEntity >>>" + requestResponseEntity.toString());
			response = new Response(Double.parseDouble(requestResponseEntity.getResponse()),
					requestResponseEntity.getRequest() + " = " + (requestResponseEntity.getResponse()));
		} else {
			subtract = num1 - num2;
			response = new Response(subtract, num1.toString() + " - " + num2.toString() + " = " + subtract.toString());
			requestResponseEntity = setDataInRepo(num1.toString() + " - " + num2.toString(), (subtract.toString()),
					Operation.SUBTRACTION.getName(), t);
			calculatorService.saveRequstResponse(requestResponseEntity);
		}
		log.error("<< logs of getSubtraction method >>" + response.toString());
		return response;
	}

	@Cacheable(value = "requestResponseEntity", cacheManager = "requestResponseEntityManager")
	@GetMapping(path = "/multiplication")
	public Response getMultiplication(@RequestParam(name = "number1") Double num1,
			@RequestParam(name = "number2") Double num2) {

		RequestResponseEntity requestResponseEntity = new RequestResponseEntity();
		Double multiplication = 0.0;
		Response response = null;
		Long t = System.currentTimeMillis();
		requestResponseEntity = calculatorService.findByRequest(num1.toString() + " * " + (num2.toString()));

		if (null != requestResponseEntity) {
			log.error(
					"<< logs of getMultiplication method RequestResponseEntity >>>" + requestResponseEntity.toString());
			response = new Response(Double.parseDouble(requestResponseEntity.getResponse()),
					requestResponseEntity.getRequest() + " = " + (requestResponseEntity.getResponse()));
		} else {
			multiplication = num1 * num2;
			response = new Response(multiplication,
					(num1.toString()) + " * " + (num2.toString()) + " = " + (multiplication.toString()));
			t = System.currentTimeMillis();
			requestResponseEntity = setDataInRepo(num1.toString() + " * " + (num2.toString()),
					(multiplication.toString()), Operation.MULTIPLICATION.getName(), t);

			calculatorService.saveRequstResponse(requestResponseEntity);
		}

		log.error("<< logs of getMultiplication method >>" + response.toString());
		return response;
	}

	@Cacheable(value = "requestResponseEntity", cacheManager = "requestResponseEntityManager")
	@GetMapping(path = "/division")
	public Response getDivision(@RequestParam(name = "number1") Double num1,
			@RequestParam(name = "number2") Double num2) {

		RequestResponseEntity requestResponseEntity = new RequestResponseEntity();
		Response response = null;
		Long t = System.currentTimeMillis();
		requestResponseEntity = calculatorService
				.findByRequest(Integer.toString(num1.intValue()) + " / " + Integer.toString(num2.intValue()));

		if (null != requestResponseEntity) {
			log.error(
					"<< logs of getMultiplication method RequestResponseEntity >>>" + requestResponseEntity.toString());
			response = new Response(Double.parseDouble(requestResponseEntity.getResponse()),
					requestResponseEntity.getRequest() + " = " + (requestResponseEntity.getResponse()));
		} else {
			response = new Response((num1 / num2), Integer.toString(num1.intValue()) + " / "
					+ Integer.toString(num2.intValue()) + " = " + Double.toString(num1 / num2));
			t = System.currentTimeMillis();
			requestResponseEntity = setDataInRepo(
					Integer.toString(num1.intValue()) + " / " + Integer.toString(num2.intValue()),
					(Double.toString(num1 / num2)), Operation.DIVISION.getName(), t);

			calculatorService.saveRequstResponse(requestResponseEntity);
		}

		log.error("<< logs of getMultiplication method >>" + response.toString());
		return response;
	}

	@Cacheable(value = "requestResponseEntity", cacheManager = "requestResponseEntityManager")
	@GetMapping(path = "/square/{number}")
	public Response getSquare(@PathVariable Double number) {
		RequestResponseEntity requestResponseEntity = new RequestResponseEntity();
		Double square = 0.0;
		Response response = null;
		Long t = System.currentTimeMillis();
		requestResponseEntity = calculatorService.findByRequest("square of " + number);
		if (null != requestResponseEntity) {
			log.error("<< logs of getSquare method RequestResponseEntity >>>" + requestResponseEntity.toString());
			response = new Response(Double.parseDouble(requestResponseEntity.getResponse()),
					requestResponseEntity.getRequest() + " = " + (requestResponseEntity.getResponse()));
		} else {
			square = number * number;
			response = new Response(square, "square of " + number + " = " + (square.toString()));
			t = System.currentTimeMillis();
			requestResponseEntity = setDataInRepo("square of " + number, (square.toString()),
					Operation.SQUARE.getName(), t);
			calculatorService.saveRequstResponse(requestResponseEntity);
		}
		log.error("<< logs of getSquare method >>" + response.toString());
		return response;
	}

	@Cacheable(value = "requestResponseEntity", cacheManager = "requestResponseEntityManager")
	@GetMapping(path = "/squareroot/{number}")
	public Response getSquareRoot(@PathVariable Double number) {
		RequestResponseEntity requestResponseEntity = new RequestResponseEntity();
		Double squareRoot = 0.0;
		Response response = null;
		Long t = System.currentTimeMillis();
		requestResponseEntity = calculatorService.findByRequest("squareroot of " + number);
		if (null != requestResponseEntity) {
			log.error("<< logs of getSquareRoot method RequestResponseEntity >>>" + requestResponseEntity.toString());
			response = new Response(Double.parseDouble(requestResponseEntity.getResponse()),
					requestResponseEntity.getRequest() + " = " + (requestResponseEntity.getResponse()));
		} else {
			squareRoot = Math.sqrt(number);
			response = new Response(squareRoot, "squareroot of " + number + " = " + (squareRoot.toString()));
			t = System.currentTimeMillis();
			requestResponseEntity = setDataInRepo("squareroot of " + number, (squareRoot.toString()),
					Operation.SQUARE_ROOT.getName(), t);
			calculatorService.saveRequstResponse(requestResponseEntity);
		}
		log.error("<< logs of getSquareRoot method >>" + response.toString());
		return response;
	}

	@Cacheable(value = "requestResponseEntity", cacheManager = "requestResponseEntityManager")
	@GetMapping(path = "/factorial/{num}")
	public Response getFactorial(@PathVariable Double num) {
		RequestResponseEntity requestResponseEntity = new RequestResponseEntity();
		Double result = 0.0;
		Response response = null;
		Long t = System.currentTimeMillis();
		requestResponseEntity = calculatorService.findByRequest((num.toString()) + "!");
		if (null != requestResponseEntity) {
			log.error("<< logs of getFactorial method RequestResponseEntity >>>" + requestResponseEntity.toString());
			response = new Response(Double.parseDouble(requestResponseEntity.getResponse()),
					requestResponseEntity.getRequest() + " = " + (requestResponseEntity.getResponse()));
		} else {
			result = getFac(num);
			response = new Response(result, (num.toString()) + "!" + " = " + (result.toString()));
			t = System.currentTimeMillis();
			requestResponseEntity = setDataInRepo((num.toString()) + "!", (result.toString()),
					Operation.FACTORIAL.getName(), t);
			calculatorService.saveRequstResponse(requestResponseEntity);
		}
		log.error("<< logs of getFactorial method >>" + response.toString());
		return response;
	}

	private Double getFac(Double num) {
		if (num == 1 || num == 0)
			return (double) 1;
		else
			return (num * getFac(num - 1));
	}

	@Cacheable(value = "requestResponseEntity", cacheManager = "requestResponseEntityManager")
	@PostMapping("/min-max")
	public ResponseMinMax getMinMax(@RequestBody MinMaxRequest minMaxRequest) {
		RequestResponseEntity requestResponseEntity = new RequestResponseEntity();
		int max = 0;
		int min = 0;
		ResponseMinMax response = null;
		Long t = System.currentTimeMillis();
		requestResponseEntity = calculatorService.findByRequest(minMaxRequest.toString());
		if (null != requestResponseEntity) {
			log.error("<< logs of getFactorial method RequestResponseEntity >>>" + requestResponseEntity.toString());
			response = new ResponseMinMax(requestResponseEntity.getResponse());
		} else {
			max = minMaxRequest.getNumbers().stream().max(Integer::compare).get();
			min = minMaxRequest.getNumbers().stream().min(Integer::compare).get();
			String result = "min : " + min + " max : " + max;
			response = new ResponseMinMax(result);
			t = System.currentTimeMillis();
			requestResponseEntity = setDataInRepo(minMaxRequest.toString(), response.toString(),
					Operation.MIN_MAX.getName(), t);
			calculatorService.saveRequstResponse(requestResponseEntity);
		}

		log.error("<< logs of getMinMax method >>" + response.toString());
		return response;
	}

	private RequestResponseEntity setDataInRepo(String request, String response, String operation, Long sqlTimestamp) {
		RequestResponseEntity requestResponseEntity = new RequestResponseEntity();
		requestResponseEntity.setRequest(request);
		requestResponseEntity.setResponse(response);
		requestResponseEntity.setOperation(operation);
		requestResponseEntity.setSqlTimestamp(sqlTimestamp);
		return requestResponseEntity;
	}

	@Cacheable(value = "requestResponseEntity", cacheManager = "requestResponseEntityManager")
	@GetMapping(path = "/findById/{id}")
	public RequestResponseEntity getResult(@PathVariable Long id) {
		log.error("<< logs of getFactorial method >>" + calculatorService.findById(id).toString());
		return calculatorService.findById(id);
	}

}
