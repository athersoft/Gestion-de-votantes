package entrega;
import java.util.*;
public class Local {
	private String direccion;
	private int id;
	private ArrayList<Persona> personas;
	
	
	public Local() {
		direccion = "";
		id = 0;
		personas = new ArrayList<Persona>(15);
	}
	
	public Local(String direccion, int id) {
		this.direccion = direccion;
		this.id = id;
		personas = new ArrayList<Persona>(15);
		
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
	
	public void agregarPersona(Persona p) {
		personas.add(p);
		return;
	}
	
}
