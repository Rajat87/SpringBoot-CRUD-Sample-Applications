package com.springboot.rest.model;

public class Country {
	private String name;
	private int population;
	
	public static Country giveMeCountry(String name, int population) {
		Country country = new Country();
		country.setName(name);
		country.setPopulation(population);
		return country;
	}

	// Another Doubt when I used parameterized constructor to initialize country I did not get the result 
	// But when I used getters and setters I got the output.
	
	//Fields must be either public or have (public) getters to be serialized to JSON and (public) setters to be deserialized from JSON.

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "Country [name=" + name + ", population=" + population + "]";
	}
	
	
	
	
}
