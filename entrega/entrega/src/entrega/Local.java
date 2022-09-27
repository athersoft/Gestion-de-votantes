package entrega;
import java.util.*;
public class Local {
	private String direccion;
	private int id;
	private ArrayList<Persona> personas;
	
	private int capacidad;
	private int inscritos;
	
	public Local() {
		capacidad = 10;
		inscritos = 0;
		direccion = "";
		id = 0;
		personas = new ArrayList<Persona>();
	}
	
	public Local(String direccion, int id, int cap) {
		this.capacidad = cap;
		inscritos = 0;
		this.direccion = direccion;
		this.id = id;
		personas = new ArrayList<Persona>();
		
	}
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void setCapacidad(int i) {
		this.capacidad = i;
	}
	
	public int getCapacidad() {
		return capacidad;
	}
	
	public int getInscritos() {
		return inscritos;
	}
	
	public void agregarPersona(Persona p) {
		personas.add(p);
		inscritos++;
		return;
	}

	public void search(String rut){
		
		for(Persona i : personas) {
			if (i.getRut().equals(rut)){
				System.out.println(i.getName() + " " +i.getRut());
				System.out.println("Asignado al local:" + id);
				System.out.println("Direccion del local:"+direccion);
				return;
			}
		}

		System.out.println("No tiene un local asignado");

	}
	public void showData(){
		System.out.println("id: " + id);
		System.out.println("Capacidad: " + capacidad);
		System.out.println("Direccion: " + direccion);
	}

	public void showData(int id){
		for(Persona i: personas){
			i.showData();
		}
		

	}
	
}
