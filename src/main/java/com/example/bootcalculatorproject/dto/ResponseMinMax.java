package com.example.bootcalculatorproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseMinMax {
	@JsonProperty("max")
	private int max;
	@JsonProperty("min")
	private int min;

}
