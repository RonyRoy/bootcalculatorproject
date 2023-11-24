package com.example.bootcalculatorproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bootcalculatorproject.controller.CalculatorController;
import com.example.bootcalculatorproject.dao.CalculatorRepo;
import com.example.bootcalculatorproject.dto.MinMaxRequest;
import com.example.bootcalculatorproject.dto.Operation;
import com.example.bootcalculatorproject.dto.Response;
import com.example.bootcalculatorproject.dto.ResponseMinMax;
import com.example.bootcalculatorproject.jpa.RequestResponseEntity;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CalculatorService implements ICalculatorService {
	@Autowired
	CalculatorRepo calculatorRepo;

	RequestResponseEntity requestResponseEntity = new RequestResponseEntity();

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

	private RequestResponseEntity setDataInRepo(String request, String response, String operation, Long sqlTimestamp) {
		RequestResponseEntity requestResponseEntity = new RequestResponseEntity();
		requestResponseEntity.setRequest(request);
		requestResponseEntity.setResponse(response);
		requestResponseEntity.setOperation(operation);
		requestResponseEntity.setSqlTimestamp(sqlTimestamp);
		return requestResponseEntity;
	}

	@Override
	public Response addition(Double number1, Double number2) {
		Response response = null;
		Long t = System.currentTimeMillis();
		requestResponseEntity = findByRequest((number1.toString()) + " + " + (number2.toString()));

		if (null != requestResponseEntity) {
			log.error("<< logs of CalculatorService ::: addition method RequestResponseEntity >>>"
					+ requestResponseEntity.toString());
			response = new Response(Double.parseDouble(requestResponseEntity.getResponse()),
					requestResponseEntity.getRequest() + " = " + (requestResponseEntity.getResponse()));
		} else {
			Double add = number1 + number2;
			requestResponseEntity = setDataInRepo((number1.toString()) + " + " + (number2.toString()), (add.toString()),
					Operation.ADDITION.getName(), t);
			saveRequstResponse(requestResponseEntity);
			response = new Response(add,
					(number1.toString()) + " + " + (number2.toString()) + " = " + (add.toString()));
		}
		log.error("<< logs of CalculatorService ::: addition method >>" + response.toString());
		return response;
	}

	@Override
	public Response subtraction(Double number1, Double number2) {
		Response response = null;
		Long t = System.currentTimeMillis();
		requestResponseEntity = findByRequest(number1.toString() + " - " + number2.toString());
		if (null != requestResponseEntity) {
			log.error("<< logs of CalculatorService ::: subtraction method RequestResponseEntity >>>"
					+ requestResponseEntity.toString());
			response = new Response(Double.parseDouble(requestResponseEntity.getResponse()),
					requestResponseEntity.getRequest() + " = " + (requestResponseEntity.getResponse()));
		} else {
			Double subtract = number1 - number2;
			response = new Response(subtract,
					number1.toString() + " - " + number2.toString() + " = " + subtract.toString());
			requestResponseEntity = setDataInRepo(number1.toString() + " - " + number2.toString(),
					(subtract.toString()), Operation.SUBTRACTION.getName(), t);
			saveRequstResponse(requestResponseEntity);
		}
		log.error("<< logs of CalculatorService ::: subtraction method >>" + response.toString());
		return response;
	}

	@Override
	public Response multiplication(Double number1, Double number2) {
		Double multiplication = 0.0;
		Response response = null;
		Long t = System.currentTimeMillis();
		requestResponseEntity = findByRequest(number1.toString() + " * " + (number2.toString()));

		if (null != requestResponseEntity) {
			log.error("<< logs of CalculatorService ::: multiplication method RequestResponseEntity >>>"
					+ requestResponseEntity.toString());
			response = new Response(Double.parseDouble(requestResponseEntity.getResponse()),
					requestResponseEntity.getRequest() + " = " + (requestResponseEntity.getResponse()));
		} else {
			multiplication = number1 * number2;
			response = new Response(multiplication,
					(number1.toString()) + " * " + (number2.toString()) + " = " + (multiplication.toString()));
			t = System.currentTimeMillis();
			requestResponseEntity = setDataInRepo(number1.toString() + " * " + (number2.toString()),
					(multiplication.toString()), Operation.MULTIPLICATION.getName(), t);

			saveRequstResponse(requestResponseEntity);
		}

		log.error("<< logs of CalculatorService ::: multiplication method >>" + response.toString());
		return response;
	}

	@Override
	public Response division(Double number1, Double number2) {
		Response response = null;
		Long t = System.currentTimeMillis();
		requestResponseEntity = findByRequest(
				Integer.toString(number1.intValue()) + " / " + Integer.toString(number2.intValue()));
		if (null != requestResponseEntity) {
			log.error("<< logs of CalculatorService ::: division method RequestResponseEntity >>>"
					+ requestResponseEntity.toString());
			response = new Response(Double.parseDouble(requestResponseEntity.getResponse()),
					requestResponseEntity.getRequest() + " = " + (requestResponseEntity.getResponse()));
		} else {
			response = new Response((number1 / number2), Integer.toString(number1.intValue()) + " / "
					+ Integer.toString(number2.intValue()) + " = " + Double.toString(number1 / number2));
			t = System.currentTimeMillis();
			requestResponseEntity = setDataInRepo(
					Integer.toString(number1.intValue()) + " / " + Integer.toString(number2.intValue()),
					(Double.toString(number1 / number2)), Operation.DIVISION.getName(), t);

			saveRequstResponse(requestResponseEntity);
		}

		log.error("<< logs of CalculatorService ::: division method >>" + response.toString());
		return response;

	}

	@Override
	public Response square(Double number) {
		Double square = 0.0;
		Response response = null;
		Long t = System.currentTimeMillis();
		requestResponseEntity = findByRequest("square of " + number);
		if (null != requestResponseEntity) {
			log.error("<< logs of CalculatorService ::: square method RequestResponseEntity >>>"
					+ requestResponseEntity.toString());
			response = new Response(Double.parseDouble(requestResponseEntity.getResponse()),
					requestResponseEntity.getRequest() + " = " + (requestResponseEntity.getResponse()));
		} else {
			square = number * number;
			response = new Response(square, "square of " + number + " = " + (square.toString()));
			t = System.currentTimeMillis();
			requestResponseEntity = setDataInRepo("square of " + number, (square.toString()),
					Operation.SQUARE.getName(), t);
			saveRequstResponse(requestResponseEntity);
		}
		log.error("<< logs of CalculatorService ::: square method >>" + response.toString());
		return response;
	}

	@Override
	public Response squareroot(Double number) {
		Double squareRoot = 0.0;
		Response response = null;
		Long t = System.currentTimeMillis();
		requestResponseEntity = findByRequest("squareroot of " + number);
		if (null != requestResponseEntity) {
			log.error("<< logs of CalculatorService ::: squareRoot method RequestResponseEntity >>>"
					+ requestResponseEntity.toString());
			response = new Response(Double.parseDouble(requestResponseEntity.getResponse()),
					requestResponseEntity.getRequest() + " = " + (requestResponseEntity.getResponse()));
		} else {
			squareRoot = Math.sqrt(number);
			response = new Response(squareRoot, "squareroot of " + number + " = " + (squareRoot.toString()));
			t = System.currentTimeMillis();
			requestResponseEntity = setDataInRepo("squareroot of " + number, (squareRoot.toString()),
					Operation.SQUARE_ROOT.getName(), t);
			saveRequstResponse(requestResponseEntity);
		}
		log.error("<< logs of CalculatorService ::: squareRoot method >>" + response.toString());
		return response;
	}

	@Override
	public Response factorial(Double num) {
		RequestResponseEntity requestResponseEntity = new RequestResponseEntity();
		Double result = 0.0;
		Response response = null;
		Long t = System.currentTimeMillis();
		requestResponseEntity = findByRequest((num.toString()) + "!");
		if (null != requestResponseEntity) {
			log.error("<< logs of CalculatorService ::: factorial method RequestResponseEntity >>>"
					+ requestResponseEntity.toString());
			response = new Response(Double.parseDouble(requestResponseEntity.getResponse()),
					requestResponseEntity.getRequest() + " = " + (requestResponseEntity.getResponse()));
		} else {
			result = getFac(num);
			response = new Response(result, (num.toString()) + "!" + " = " + (result.toString()));
			t = System.currentTimeMillis();
			requestResponseEntity = setDataInRepo((num.toString()) + "!", (result.toString()),
					Operation.FACTORIAL.getName(), t);
			saveRequstResponse(requestResponseEntity);
		}
		log.error("<< logs of CalculatorService ::: factorial method >>" + response.toString());
		return response;

	}

	private Double getFac(Double num) {
		if (num == 1 || num == 0)
			return (double) 1;
		else
			return (num * getFac(num - 1));
	}

	@Override
	public ResponseMinMax min_max(MinMaxRequest minMaxRequest) {
		int max = 0;
		int min = 0;
		ResponseMinMax response = null;
		Long t = System.currentTimeMillis();
		requestResponseEntity = findByRequest(minMaxRequest.toString());
		if (null != requestResponseEntity) {
			log.error("<< logs of CalculatorService ::: min_max method RequestResponseEntity >>>"
					+ requestResponseEntity.toString());
			response = new ResponseMinMax(requestResponseEntity.getResponse());
		} else {
			max = minMaxRequest.getNumbers().stream().max(Integer::compare).get();
			min = minMaxRequest.getNumbers().stream().min(Integer::compare).get();
			String result = "min : " + min + " max : " + max;
			response = new ResponseMinMax(result);
			t = System.currentTimeMillis();
			requestResponseEntity = setDataInRepo(minMaxRequest.toString(), response.toString(),
					Operation.MIN_MAX.getName(), t);
			saveRequstResponse(requestResponseEntity);
		}

		log.error("<< logs of CalculatorService ::: min_max method >>" + response.toString());
		return response;
	}

}
