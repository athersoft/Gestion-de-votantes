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
	
	public int getInscritos() {
		return inscritos;
	}
	
	public void agregarPersona(Persona p) {
		personas.add(p);
		inscritos++;
		return;
	}
	
}
