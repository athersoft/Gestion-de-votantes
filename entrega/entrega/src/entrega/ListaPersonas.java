package entrega;

import java.util.ArrayList;

public class ListaPersonas {

	
	private ArrayList<Persona> personas;
	
	public ListaPersonas() {
		personas = new ArrayList<Persona>();
	}
	
	public void mostrarPorEdad(int min, int max) {
		boolean found = false;
		System.out.println("");
		for(Persona i: personas){
			if(i.getAge() >= min && i.getAge() <= max)
				i.showData();
				found = true;
		}
		if(!found) {
			System.out.println("No hay personas en ese rango de edad\n");
		}
		
		return;
	}
	
	public Persona buscarPersona(String rut) {
		for(Persona i : personas) {
			if(i.getRut().equals(rut)) {
				return i;
			}
		}
		
		return null;
	}
	
	public void add(Persona p){
		personas.add(p);
		return;
	}
	
	public void mostrarLista() {
		for(Persona i: personas){
			i.showData();
		}
	}
}
