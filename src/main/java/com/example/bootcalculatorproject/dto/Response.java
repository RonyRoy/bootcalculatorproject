package com.example.bootcalculatorproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Response {
	@JsonProperty("answer")
	private Double answer;

	@JsonProperty("detail")
	private String detail;
}
