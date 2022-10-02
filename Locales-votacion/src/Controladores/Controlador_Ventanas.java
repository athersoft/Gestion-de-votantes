package Controladores;
import modelo.Modelo;
import ventanas.Ventana;
public class Controlador_Ventanas {
	
	private static final Ventana ventanaDeResultados = new Ventana() ;

	public void botonPresionado(String cadena1,int edad, int region, String cadena2) {
		Modelo.setPersona(cadena1,edad,region, cadena2);
		ventanaDeResultados.newWindow(null);
	}
}
