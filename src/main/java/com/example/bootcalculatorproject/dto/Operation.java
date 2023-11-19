package com.example.bootcalculatorproject.dto;

public enum Operation {
	ADDITION("addition"),
	SUBTRACTION("subtraction"),
	MULTIPLICATION("multiplication"),
	DIVISION("division"),SQUARE("square"),
	SQUARE_ROOT("squareroot"),
	FACTORIAL("factorial"),
	MIN_MAX("min-max");
	
	 private String name;
	 
    Operation(String name) {
    	this.name = name;
	}

    public String getName() {
        return name;
    }
}
