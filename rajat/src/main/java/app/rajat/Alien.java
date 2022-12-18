package app.rajat;

public class Alien {

	private int age;
	Computer laptop;


	@Override
	public String toString() {
		return "Alien [age=" + age + ", laptop=" + laptop + "]";
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public Computer getLaptop() {
		return laptop;
	}


	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}


	public Alien() {
		super();
	}


	public Alien(int age, Laptop laptop) {
		super();
		this.age = age;
		this.laptop = laptop;
	}



}
