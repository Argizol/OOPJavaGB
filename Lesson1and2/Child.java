package Lesson1and2;

import java.util.ArrayList;
import java.util.List;

public class Child extends Human {
	private boolean married;
	private Humans mother;
	private Humans father;

	static List<Child> childs = new ArrayList<>();

	public Child(String name, String surname, Human.Gender gender,
	             Humans mother, Humans father){
		super(name,surname, gender);
		this.married = false;
		this.patronimyc = (this.gender == "Male") ? name + "ovich" : name + "ovna";
		this.mother = mother;
		this.father = father;
	}

	@Override
	public String toString() {
		return  "Мать = "+mother.getName()+ " " + mother.getSurname() + "\n" +
				"Отец = " + father.getName() + " " + father.getSurname() + "\n" +
				"name = " + name + " " +
				"surname= " + surname + " " +
				"patronimyc = " + patronimyc + "\n" +
				"gender = " + gender + " " +
				"married = " + married + "\n";
	}

	public boolean isMarried() {
		return married;
	}

	public Humans getMother() {
		return mother;
	}

	public Humans getFather() {
		return father;
	}
}

