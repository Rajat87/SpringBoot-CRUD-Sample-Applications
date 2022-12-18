package com.springXML.SpringCoreUsingAnnot;

import org.springframework.stereotype.Component;

@Component
public class Laptop {
	String Brand;

	@Override
	public String toString() {
		return "Laptop [Brand=" + Brand + "]";
	}
	
	
}
