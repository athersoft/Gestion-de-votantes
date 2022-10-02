package entrega;

import java.util.ArrayList;

public class ListaPersonas {

	
	private ArrayList<Persona> personas;
	private int size;
	private int current;
	
	public ListaPersonas() {
		personas = new ArrayList<Persona>();
		size = 0;
		current = 0;
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
		size++;
		return;
	}
	
	public void mostrarLista() {
		if(personas.size() == 0) {
			System.out.println("\nNo hay personas en esta listan");
		}
		for(Persona i: personas){
			i.showData();
		}
	}
	
	public int getSize() {
		return size;
	}
	
	public Persona getCurrent() {
		if(size == 0) {
			return null;
		}
		return personas.get(current);
	}
	
	public void deleteCurrent() {
		personas.remove(current);
	}
	
	public boolean next() {
		if(current < size) {
			current++;
			return true;
		}else {
			return false;
		}
	}
}
