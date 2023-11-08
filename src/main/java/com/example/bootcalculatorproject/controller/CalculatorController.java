package com.example.bootcalculatorproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bootcalculatorproject.dto.MinMaxRequest;
import com.example.bootcalculatorproject.dto.Response;
import com.example.bootcalculatorproject.dto.ResponseMinMax;

@RestController
@RequestMapping("/calculatorapi/v1")
public class CalculatorController {
	@GetMapping(path = "/addition")
	public Response getAddition(@RequestParam(name = "number1") Double num1,
			@RequestParam(name = "number2") Double num2) {
		Double add = num1 + num2;
		return new Response(add, (num1.toString()) + " + " + (num2.toString()) + " = " + (add.toString()));
	}

	@GetMapping(path = "/subtraction")
	public Response getSubtraction(@RequestParam(name = "number1") Double num1,
			@RequestParam(name = "number2") Double num2) {
		Double subtract = num1 - num2;
		return new Response(subtract, num1.toString() + " - " + num2.toString() + " = "
				+ subtract.toString());
	}

	@GetMapping(path = "/multiplication")
	public Response getMultiplication(@RequestParam(name = "number1") Double num1,
			@RequestParam(name = "number2") Double num2) {
		Double multiplication = num1 * num2;
		return new Response(multiplication,
				(num1.toString()) + " * " + (num2.toString()) + " = " + (multiplication.toString()));
	}

	@GetMapping(path = "/division")
	public Response getDivision(@RequestParam(name = "number1") Double num1,
			@RequestParam(name = "number2") Double num2) {
		Response response = new Response((num1 / num2), Integer.toString(num1.intValue()) + " / "
				+ Integer.toString(num2.intValue()) + " = " + Double.toString(num1 / num2));
		return response;
	}

	@GetMapping(path = "/square/{number}")
	public Response getSquare(@PathVariable Double number) {
		Double square = number * number;
		return new Response(square, "square of " + number + " = " + (square.toString()));
	}

	@GetMapping(path = "/squareroot/{number}")
	public Response getSquareRoot(@PathVariable Double number) {
		Double squareRoot = Math.sqrt(number);
		return new Response(squareRoot, "squareroot of " + number + " = " + (squareRoot.toString()));
	}

	@GetMapping(path = "/factorial/{num}")
	public Response getFactorial(@PathVariable Double num) {
		Double result = getFac(num);
		return new Response(result, (num.toString()) + "!" + " = " + (result.toString()));
	}

	private Double getFac(Double num) {
		if (num == 1 || num == 0)
			return (double) 1;
		else
			return (num * getFac(num - 1));
	}

	@PostMapping("/min-max")
	public ResponseMinMax getMinMax(@RequestBody MinMaxRequest minMaxRequest) {
		int max = minMaxRequest.getNumbers().stream().max(Integer::compare).get();
		int min = minMaxRequest.getNumbers().stream().min(Integer::compare).get();
		return new ResponseMinMax(max, min);
	}

}
