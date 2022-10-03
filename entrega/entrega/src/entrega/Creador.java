package entrega;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Creador {
	String in;
	BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
	int aux = 0;
	
	public Persona persona() throws IOException{
		Persona votante;
		votante = new Persona();
		
		System.out.println("Ingrese numero de region donde reside");
		try{
			in = lector.readLine();
		}catch(IOException e){
			System.out.println( "Error de input." );
		}
		try {
			aux = Integer.parseInt(in);
			throw new InputException();
		  } catch (NumberFormatException e) {
			System.out.println("Formato incorrecto (string != int)");
		  }catch(InputException a){
			if(a.regionException(aux) == true){
				while(!(aux >= 1 && aux <= 16)){
					try{
						in = lector.readLine();
						aux = Integer.parseInt(in);
					}catch(IOException e){
						System.out.println( "Error de input." );
					}catch(NumberFormatException k){
						System.out.println("Formato incorrecto (string != int)");
					}

				}
			}
		}
		
		System.out.println("Ingrese nombre");
		try{
			in = lector.readLine();
		}catch(IOException e){
			System.out.println( "Error de input." );
		}
		votante.setName(in);
			
		System.out.println("Ingrese rut");
		try{
			in = lector.readLine();
			throw new InputException();
		}catch(IOException e){
			System.out.println( "Error de input." );
		}catch(InputException a){
			while(a.rutException(in) == true){
				try{
					in = lector.readLine();
				}catch(IOException e){
					System.out.println( "Error de input." );
				}
			}
		}




		votante.setRut(in);	
		votante.showData();	
		System.out.println("Ingrese edad");
		try{
			in = lector.readLine();
		}catch(IOException e){
			System.out.println( "Error de input." );
		}
		try {
			aux = Integer.parseInt(in);
			throw new InputException();
		  } catch (NumberFormatException e) {
			System.out.println("Formato incorrecto (string != int)");
		  }catch(InputException a){
			while(a.edadException(aux) == true){
				try{
					in = lector.readLine();
					aux = Integer.parseInt(in);
				}catch(IOException e){
					System.out.println( "Error de input." );
				}catch(NumberFormatException k){
					System.out.println("Formato incorrecto (string != int)");
				}

			}

		}
		votante.setAge(Integer.parseInt(in));
			
		

	return votante;
		
	}

	
	public Local local() throws IOException{
		Local local = new Local();
		
		System.out.println("Ingrese id del local");
		try{
			in = lector.readLine();
		}catch(IOException e){
			System.out.println( "Error de input." );
		}
		local.setId(Integer.parseInt(in));
		
		System.out.println("Ingrese capacidad maxima");
		try{
			in = lector.readLine();
		}catch(IOException e){
			System.out.println( "Error de input." );
		}
		local.setCapacidad(Integer.parseInt(in));
		
		System.out.println("Ingrese direccion");
		try{
			in = lector.readLine();
		}catch(IOException e){
			System.out.println( "Error de input." );
		}
		local.setDireccion(in);
		
		return local;
	}
	
	public Local modificarLocal(Local l) throws IOException{
		System.out.println("Deje vacío los campos que no quiera modificar");
		
		System.out.println("Ingrese nuevo id para el local");
		try{
			in = lector.readLine();
		}catch(IOException e){
			System.out.println( "Error de input." );
		}

		if(!in.equals("")) {
			l.setId(Integer.parseInt(in));
		}
		
		System.out.println("Ingrese nueva capacidad maxima");
		try{
			in = lector.readLine();
		}catch(IOException e){
			System.out.println( "Error de input." );
		}
		if(!in.equals("")) {
			l.setCapacidad(Integer.parseInt(in));
		}
		
		System.out.println("Ingrese nueva direccion");
		try{
			in = lector.readLine();
		}catch(IOException e){
			System.out.println( "Error de input." );
		}
		if(!in.equals("")) {
			l.setDireccion(in);
		}
		
		return l;
	}
}
