package ventanas;

//Integrantes: Bryam Gonzalez, Matías Romero, Eduardo Marín
import java.io.*;
import java.util.HashMap;

public class Sistema {
	
/*	public static void leertxt(Persona bi) throws IOException{
		String filePath = "personas.txt";
		
		BufferedReader lectorTxt = new BufferedReader( new FileReader( filePath ) );
		String lineText = null;
		
		while ((lineText = lectorTxt.readLine()) != null) {
			String[] arr = lineText.split(",");
			bi.setName(arr[0]);
			bi.setRut(arr[1]);
			bi.setAge(Integer.parseInt(arr[2]));
			
			System.out.println(lineText);
		}
		
		lectorTxt.close();
	}
*/

	@SuppressWarnings("static-access")
	public static void main( String arg[] ) throws IOException{
		//Lector y variables para leer
		BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
		String in;
		String in2;
		
		boolean exit = false;
		
		//Inicializar regiones
		MapaRegiones regiones = new MapaRegiones();
		ListaPersonas votantes = new ListaPersonas();
		Creador crear = new Creador();
		
		Ventana menu = new Ventana();
		menu.newWindow(arg);
		while(!exit) {
			//Opciones del menú
			
			System.out.println("--------Sistema electoral---------\n");
			System.out.println("1-Inscribir votante");
			System.out.println("2-Agregar centro de votacion");
			System.out.println("3-Consultar centro de votacion asignado");
			System.out.println("4-Mostrar locales de votacion por region");
			System.out.println("5-Mostrar votantes por rango de edad");
			System.out.println("6-Salir");
			in = lector.readLine();
			
			switch (in){
			
				/////////////Inscribir Votante//////////////////////
				case "1":{
					
					Persona votante = crear.persona();
					votantes.add(votante);
					regiones.asignarLocal(votante, votante.getRegion()-1);
					
					break;
					
				}

				
				////////////////Agregar centro de votacion//////////////
				case "2":{
					Local local = crear.local();
					System.out.println("Ingrese numero de region");
					in2 = lector.readLine();
					
					regiones.agregarLocal(local, Integer.parseInt(in2));
					
					System.out.println("Local agregado correctamente");
					
					break;
				}

				
				///////////////Consultar local asignado////////////////////
				case "3":{
					System.out.println("Ingrese rut a buscar");
					String aux;
					in2 = lector.readLine();

					System.out.println("Ingrese la region a la que pertenece: ");
					aux = lector.readLine();
					regiones.buscarEnLocal(in2, Integer.parseInt(aux));

					break;
					
				}
				
				
				///////////////////Mostrar locales de una region////////////////////
				case "4":{
					System.out.println("Ingrese numero de region a buscar");
					in2 = lector.readLine();
					regiones.mostrarLocales(Integer.parseInt(in2));
					break;
				}
				
				//////////////////Mostrar Personas en un rango de edad//////////////
				case "5":{
					String aux;
					System.out.println("Ingrese minima edad a mostrar");
					in2 = lector.readLine();
					System.out.println("Ingrese maxima edad a mostrar");
					aux = lector.readLine();
					
					votantes.mostrarPorEdad(Integer.parseInt(in2), Integer.parseInt(aux));
					
					break;
				}
				
				/*
				case "5":{
					System.out.println("Ingrese numero de region a buscar");
					in2 = lector.readLine();

					String aux;
					System.out.println("Ingrese la id del local");
					aux = lector.readLine();
					int id;
					id = Integer.parseInt(aux);
					
					regiones.get(Integer.parseInt(in2)).searchLocal(id);
				}
				*/
				
				case "6":{
					exit = true;
				}
				
			}
		}
		System.exit(0);
	}
	
}