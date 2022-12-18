package com.packone;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TesterOne {

	public static void main(String[] args) {
		List<Integer>  integers = Arrays.asList(5,6,7,8);
		System.out.println(integers.stream().map(i-> i*i).collect(Collectors.toList()));
	}

}
