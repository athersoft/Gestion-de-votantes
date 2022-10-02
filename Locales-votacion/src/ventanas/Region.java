package ventanas;
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
	
	public void agregarLocal(Local local) {
		locales.add(local);
	}
	
	public void asignarLocal(Persona votante) {
		//locales.get(pos).agregarPersona(votante);
		
	}

	public void asignarLocal(Persona votante, int pos) {
		locales.get(pos).agregarPersona(votante);
	}
	
	public void mostrarLocales() {
		if(!locales.isEmpty()) {
			for(Local i : locales) {
				i.showData();
			}
		}else {
			System.out.println("No hay locales inscritos en esta region");
		}
		return;
	}

	public void searchLocal(String rut) {
		for(Local i : locales) {
			i.search(rut);
		}
		return;
	}

	public void searchLocal(int id){
		for(Local i : locales){
			if (i.getId() == id){
				i.showData(id);
			}
			
		}
	}
	
}
