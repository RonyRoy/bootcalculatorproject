package com.example.bootcalculatorproject.dataHelper;

import java.util.ArrayList;
import java.util.List;

import com.example.bootcalculatorproject.dto.MinMaxRequest;

public class TestDataHelper {
	private TestDataHelper() {
	};

	public static MinMaxRequest getMinMaxRequest() {
		List<Integer> numList = new ArrayList<>();
		numList.add(90);
		numList.add(-9);
		numList.add(-20);
		numList.add(24);
		numList.add(67);
		numList.add(33);
		numList.add(-100);
		numList.add(1);
		MinMaxRequest minMaxRequest = new MinMaxRequest();
		minMaxRequest.setNumbers(numList);
		return minMaxRequest;
	}
}
