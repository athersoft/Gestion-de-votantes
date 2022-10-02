package modelo;
import ventanas.Persona;
public class Modelo {
	
	public static Persona personas;
	
	public static void setPersona(String nombre, int edad, int region, String rut) {
		if(personas == null) {
			personas = new Persona();
		}
		personas.setName(null);
		personas.setAge(0);
		personas.setRegion(0);
		personas.setRut(null);
	}
}
