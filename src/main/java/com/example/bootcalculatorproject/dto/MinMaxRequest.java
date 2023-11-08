package com.example.bootcalculatorproject.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MinMaxRequest {
	@JsonProperty("numbers")
	List<Integer> numbers;

	public List<Integer> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}

}
