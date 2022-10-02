package entrega;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Creador {
	String in;
	BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
	
	public Persona persona() throws IOException{
		Persona votante;
		votante = new Persona();
		
		System.out.println("Ingrese numero de region donde reside");
		in = lector.readLine();
		votante.setRegion(Integer.parseInt(in));
		
		if(Integer.parseInt(in) > 0 && Integer.parseInt(in) < 17) {
			
			System.out.println("Ingrese nombre");
			in = lector.readLine();
			votante.setName(in);
			
			System.out.println("Ingrese rut");
			in = lector.readLine();
			votante.setRut(in);
			
			System.out.println("Ingrese edad");
			in = lector.readLine();
			votante.setAge(Integer.parseInt(in));
			
			return votante;
		}else {
			System.out.println("Region no válida");
		}
		return votante;
		
	}
	
	public Local local() throws IOException{
		Local local = new Local();
		
		System.out.println("Ingrese id del local");
		in = lector.readLine();
		local.setId(Integer.parseInt(in));
		
		System.out.println("Ingrese capacidad maxima");
		in = lector.readLine();
		local.setCapacidad(Integer.parseInt(in));
		
		System.out.println("Ingrese direccion");
		in = lector.readLine();
		local.setDireccion(in);
		
		return local;
	}
	
	public Local modificarLocal(Local l) throws IOException{
		System.out.println("Deje vacío los campos que no quiera modificar");
		
		System.out.println("Ingrese nuevo id para el local");
		in = lector.readLine();
		if(!in.equals("")) {
			l.setId(Integer.parseInt(in));
		}
		
		System.out.println("Ingrese nueva capacidad maxima");
		in = lector.readLine();
		if(!in.equals("")) {
			l.setCapacidad(Integer.parseInt(in));
		}
		
		System.out.println("Ingrese nueva direccion");
		in = lector.readLine();
		if(!in.equals("")) {
			l.setDireccion(in);
		}
		
		return l;
	}
}
