package Lesson1and2;

import java.util.*;

public class Humans extends Human implements DoChild {
	static ArrayList<Humans> allHumans = new ArrayList<>();
	static GenealogicTree<Child> genealogicTree = new GenealogicTree<>();
	private boolean married;
	private int husbandID;
	private int wife_id;

	Humans(String name, String surname, String patronimyc, Gender gender) {
		super(name,surname, gender);
		this.married = false;		
		this.patronimyc = patronimyc;
	}


	@Override
	public String toString() {
		return "name = " + name + " " +
				"surname= " + surname + " " +
				"patronimyc = " + patronimyc + "\n" +
				"gender = " + gender + " " +
				"married = " + married + "\n";

	}

	public static void createHuman(Humans human, ArrayList<Humans> allHumans){
		allHumans.add(human);
	}

	@Override
	public void DoChild(Humans parent2, GenealogicTree<Child> genealogicTree){


		if (!doMarrie(this, parent2)){
			return;
		}
		String childName  = getChildName(this,parent2);
		String surname = this.getSurname();
		Humans mother =  (this.getGender() == "Female") ? this : parent2;
		Humans father = (this.getGender() == "Male") ? this : parent2;

		var child = new Child(childName, surname, Human.Gender.Male,mother ,father);
		Child.childs.add(child);
	}

	public static boolean doMarrie(Humans parent1, Humans parent2){
		if(parent1.getGender() != parent2.getGender()){
			if(parent1.isMarried() == false && parent2.isMarried() == false){
				parent1.setMarried(true);
				parent2.setMarried(true);
			}else if(parent1.isMarried() == true){
				String message = parent1.getName() + " уже в браке";
				System.out.println("Два раза в брак нельзя " + message);
				return false;
			}else if(parent2.isMarried() == true){
				String message = parent2.getName() + " уже в браке";
				System.out.println("Два раза в брак нельзя " + message);
				return false;
			}
			if(parent1.getGender() == "Male"){
				parent2.setHusbandID(parent1.getId());
				parent1.setWife_id(parent2.getId());
			}
			else{
				parent1.setHusbandID(parent2.getId());
				parent2.setWife_id(parent1.getId());
			}

			if(parent1.getGender() == "Male") parent2.setSurname(parent1.getSurname());
			else parent1.setSurname(parent1.getSurname());
		}else{
			System.out.println("Однополые браки запрещены " + parent1.getName() + " " +
					parent2.getName());
			return false;
		}
		return true;
	}
	
	public String getChildName(Humans parent1, Humans parent2){
		String firstPart;
		String secondPart;
		if(parent1.getName().length() >= 3 && parent2.getName().length() >= 3){
		firstPart = (parent1.getGender() == "Male") ? parent1.getName().substring(0,2) : parent2.getName().substring(0,2);
		secondPart = (parent1.getGender() == "Female") ? parent1.getName().substring(0,2) : parent2.getName().substring(0,2);

		}else {
			firstPart = (parent1.getGender() == "Male") ? parent1.getName().substring(0,0) : parent2.getName().substring(0,0);
			secondPart = (parent1.getGender() == "Female") ? parent1.getName().substring(0,0) : parent2.getName().substring(0,0);
		}
		return firstPart + secondPart;
	}

	public static void PrintTreeByID(){

		int id = getIdForSearch();

		for (int i = 0; i < Child.childs.size(); i++) {
			if (id - 1 == i){
				System.out.println(Child.childs.get(i));
			}
		}
	}

	private static int getIdForSearch(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Введите число от 1 до " + Child.childs.size() + " для поиска генеалогического древа ребенка");

		int id = sc.nextInt();

		return id;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean marryed) {
		this.married = marryed;
	}


	public int getHusbandID() {
		return husbandID;
	}

	public void setHusbandID(int husbandID) {
		this.husbandID = husbandID;
	}

	public int getWife_id() {
		return wife_id;
	}

	public void setWife_id(int wife_id) {
		this.wife_id = wife_id;
	}
}

