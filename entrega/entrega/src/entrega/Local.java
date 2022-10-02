package entrega;
import java.util.*;
public class Local {
	private String direccion;
	private int id;
	
	
	private int capacidad;
	private int inscritos;
	
	private ListaPersonas votantes;
	private ListaMiembrosDeMesa miembros;
	
	public Local() {
		capacidad = 10;
		inscritos = 0;
		direccion = "";
		id = 0;
		votantes = new ListaPersonas();
		miembros = new ListaMiembrosDeMesa();
	}
	
	public Local(String direccion, int id, int cap) {
		this.capacidad = cap;
		inscritos = 0;
		this.direccion = direccion;
		this.id = id;
		votantes = new ListaPersonas();
		
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
		votantes.add(p);
		inscritos++;
		return;
	}

	public void search(String rut){
		Persona p = votantes.buscarPersona(rut);
		if (p != null){
			System.out.println(p.getName() + " " +p.getRut());
			System.out.println("Asignado al local:" + id);
			System.out.println("Direccion del local:"+direccion);
			return;
		}

		System.out.println("No tiene un local asignado");

	}
	

	public void showData(int id){
		votantes.mostrarLista();
	}
	
	public void mostrarMiembros() {
		miembros.mostrarLista();
	}
	
	public void showData(){
		System.out.println("id: " + id);
		System.out.println("Capacidad: " + capacidad);
		System.out.println("Direccion: " + direccion);
		System.out.println("Miembros de mesa: ");
		mostrarMiembros();
	}
}
