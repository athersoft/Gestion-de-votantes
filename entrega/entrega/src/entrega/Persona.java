package entrega;

public class Persona {
	private String rut;
	private int age;
	private String name;
	private int numRegion;
	
	public Persona(){
		name = "";
		rut = "";
		age = 0;
		numRegion = 0;
	}
		
	public void setName(String n) {
		name = n;
		return;
	}
	public void setRut(String f) {
		rut = f;
		return;
	}
	
	public void setAge(int a) {
		age = a;
		return;
	}
	
	public void setRegion(int a) {
		numRegion = a;
		return;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getRut() {
		return rut;
	}
	
	public int getRegion() {
		return numRegion;
	}
	
	public void showData() {
		System.out.println("\nNombre: " + name);
		System.out.println("Edad: " + age);
		System.out.println("Rut: " + rut);
		System.out.println("region: "+ numRegion);
		return;
	}
	
}



