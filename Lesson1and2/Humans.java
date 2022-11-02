package Lesson1and2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Humans extends Human implements DoChild {

	private boolean married;
	private boolean isChild;
	private int husbandID;
	int parent_id;
	private int wife_id;

	static ArrayList<Humans> allHumans = new ArrayList<>();
	static Map<Integer, ArrayList<Humans>> genealogicTree = new HashMap<>();

	Humans(String name, String surname,String patronimyc, Gender gender, ArrayList<Humans> allHumans) {
		super(name,surname, gender);
		this.married = false;		
		this.patronimyc = patronimyc;
	}
	
	private Humans(String name, String surname, Gender gender, boolean isChild, int parent_id){
		super(name,surname, gender);
		this.isChild = isChild;
		this.married = false;
		this.patronimyc = (this.gender == "Male") ? name + "ovich" : name + "ovna";
		this.parent_id = parent_id;
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
	public void DoChild(Humans parent2, Map<Integer, ArrayList<Humans>> genealogicTree){

		if (!doMarrie(this, parent2)){
			return;
		}
		String childName  = getChildName(this,parent2);
		String surname = this.getSurname();

		var child = new Humans(childName, surname, Human.Gender.Male, true,
				parent_id = (this.getGender() == "Male") ? this.getId() : parent2.getId());

		if(!genealogicTree.containsKey((this.getGender() == "Male") ? this.getId() : parent2.getId())) {
			ArrayList<Humans> childs = new ArrayList<>();
			childs.add(child);
			genealogicTree.put(child.getParent_id(), childs);
		}else {
			ArrayList<Humans> list = genealogicTree.get((this.getGender() == "Male") ? this.getId() : parent2.getId());
			list.add(child);
		}

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

	public static void findAndPrintTreeByID(){

		int id = getIdForSearch();
		String father = null;
		String mother = null;
		int mthrId = 0;

		if(!genealogicTree.containsKey(id)) {
			for(Humans hum : allHumans){
				if(hum.getId() == id){
					id = hum.getHusbandID();
				}
			}
		}

		for(Humans hum : allHumans){
			if(hum.getId() == id){
				father = "Отец = " + hum;
				mthrId = hum.getWife_id();
			}
		}

		for(Humans hum : allHumans){
			if(hum.getId() == mthrId){
				mother = "Мать = " + hum;
			}
		}

		System.out.println(mother + "\n" + father);

		for(int ids : genealogicTree.keySet()){
			if(ids == id){
				System.out.println("Дети: \n" + genealogicTree.get(id));
			}
		}

	}

	private static int getIdForSearch(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Введите число от 1 до " + allHumans.size() + " для поиска генеалогического древа");

		int id = sc.nextInt();

		return id;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean marryed) {
		this.married = marryed;
	}

	public boolean isChild() {
		return isChild;
	}
	public int getParent_id() {
		return parent_id;
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

