package entrega;
import java.util.ArrayList;

public class Region {
	private int num;
	private String name;
	private ArrayList<Local> locales = new ArrayList<Local>();
	
	public Region(int a, String b) {
		num = a;
		name = b;
	}
	
	public void setName(String n) {
		name = n;
		return;
	}
	
	public void setNum(int n) {
		num = n;
		return;
	}
	
	public String getName() {
		return name;
	}
	
	public int getnum() {
		return num;
	}
	
	public void asignarLocal(Persona votante) {
		
	}

	public void asignarLocal(Persona votante, int pos) {
		locales.get(pos).agregarPersona(votante);
	}
	
	public void mostrarLocales() {
		for(Local i : locales) {
			System.out.println("Local numero:");
			System.out.println("Numero de personas asignadas");
			i.getInscritos();
		}
		return;
	}
	
}
