package com.example.bootcalculatorproject.service;

import com.example.bootcalculatorproject.dto.MinMaxRequest;
import com.example.bootcalculatorproject.dto.Response;
import com.example.bootcalculatorproject.dto.ResponseMinMax;

public interface ICalculatorService {
	public Response addition( Double number1, Double number2 );
	public Response subtraction( Double number1, Double number2 );
	public Response multiplication( Double number1, Double number2 );
	public Response division( Double number1, Double number2 );
	public Response square(Double number);
	public Response squareroot(Double number);
	public Response factorial(Double num);
	public ResponseMinMax min_max(MinMaxRequest minMaxRequest);
}
