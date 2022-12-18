package com.anotheraspect;

import org.springframework.stereotype.Service;

@Service  // Added in AC
public class AspectService {
	
	public int add(int num1, int num2) {
		return (num1+num2);
	}
	
}
