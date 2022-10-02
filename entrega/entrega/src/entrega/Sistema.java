package entrega;

//Integrantes: Bryam Gonzalez, Matías Romero, Eduardo Marín
import java.io.*;

import java.util.HashMap;

import java.util.ArrayList; 

public class Sistema {
	
	
	public static void cargarNoInscritos(ListaPersonas p) throws IOException{
		String filePath = "personasNoInscritas.txt";
		
		BufferedReader lectorTxt = new BufferedReader( new FileReader( filePath ) );
		String lineText = null;
		
		while ((lineText = lectorTxt.readLine()) != null) {
			Persona bi = new Persona();
			String[] arr = lineText.split(",");
			bi.setRegion(Integer.parseInt(arr[0]));
			bi.setName(arr[1]);
			bi.setAge(Integer.parseInt(arr[2]));
			bi.setRut(arr[3]);
			p.add(bi);
		}
		
		lectorTxt.close();
	}
	
	public static void cargarInscritos(ListaPersonas p) throws IOException{
		String filePath = "personasInscritas.txt";
		
		BufferedReader lectorTxt = new BufferedReader( new FileReader( filePath ) );
		String lineText = null;
		
		while ((lineText = lectorTxt.readLine()) != null) {
			Persona bi = new Persona();
			String[] arr = lineText.split(",");
			bi.setRegion(Integer.parseInt(arr[0]));
			bi.setName(arr[1]);
			bi.setAge(Integer.parseInt(arr[2]));
			bi.setRut(arr[3]);
			p.add(bi);
		}
		
		lectorTxt.close();
	}
	
	public static void cargarLocales(MapaRegiones regiones) throws IOException{
		String filePath = "locales.txt";
		
		BufferedReader lectorTxt = new BufferedReader( new FileReader( filePath ) );
		String lineText = null;
		
		while ((lineText = lectorTxt.readLine()) != null) {
			Local local = new Local();
			String[] arr = lineText.split(",");
			local.setId(Integer.parseInt(arr[1]));
			local.setCapacidad(Integer.parseInt(arr[2]));
			local.setDireccion(arr[3]);
			regiones.agregarLocal(local, Integer.parseInt(arr[0]));
		}
		
		lectorTxt.close();
	}
	

	public static void main( String arg[] ) throws IOException{
		//Lector y variables para leer
		BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
		String in;
		String in2;
		
		boolean exit = false;
		
		//Inicializar regiones
		MapaRegiones regiones = new MapaRegiones();
		ListaPersonas votantes = new ListaPersonas();
		ListaPersonas votantesSinAsignar = new ListaPersonas();
		Creador crear = new Creador();
		
		cargarNoInscritos(votantesSinAsignar);
		cargarInscritos(votantes);
		cargarLocales(regiones);
		
		while(!exit) {
			//Opciones del menú
			
			System.out.println("\n--------Sistema electoral---------\n");
			System.out.println("1-Inscribir votante");
			System.out.println("2-Asignar votantes");
			System.out.println("3-Agregar centro de votacion");
			System.out.println("4-Modificar centro de votacion");
			System.out.println("5-Eliminar centro de votacion");
			System.out.println("6-Consultar centro de votacion asignado");
			System.out.println("7-Mostrar locales de votacion por region");
			System.out.println("8-Mostrar personas en el sistema");
			System.out.println("9-Mostrar votantes por rango de edad");
			System.out.println("10-Salir");
			in = lector.readLine();
			
			switch (in){
			
				/////////////Inscribir Votante//////////////////////
				case "1":{
					
					Persona votante = crear.persona();
					votantesSinAsignar.add(votante);
					
					break;
					
				}
				
				//////////////Asignar Votantes///////////////////
				
				case "2":{
					regiones.asignarPersonas(votantesSinAsignar,votantes);
					break;
				}
				
				////////////////Agregar centro de votacion//////////////
				case "3":{
					Local local = crear.local();
					System.out.println("Ingrese numero de region");
					in2 = lector.readLine();
					
					regiones.agregarLocal(local, Integer.parseInt(in2));
					
					System.out.println("Local agregado correctamente");
					
					break;
				}
				
				///////////////Modificar local de votacion////////////////
				case "4":{
					String aux;
					System.out.println("Ingrese region");
					in2 = lector.readLine();
					System.out.println("Ingrese id de local a modificar");
					aux = lector.readLine();
					
					Local local = regiones.buscarLocal(Integer.parseInt(in2), Integer.parseInt(aux));
					if(local != null) {
						local = crear.modificarLocal(local);
					}
					
					regiones.eliminarLocal(Integer.parseInt(in2), Integer.parseInt(aux));
					
					regiones.agregarLocal(local, Integer.parseInt(in2));
					
					break;
				}
				
				///////////////Eliminar local//////////////////////////
				case "5":{
					String aux;
					System.out.println("Ingrese region");
					in2 = lector.readLine();
					System.out.println("Ingrese id de local a eliminar");
					aux = lector.readLine();
					
					if(regiones.buscarLocal(Integer.parseInt(in2), Integer.parseInt(aux)) != null) {
						regiones.eliminarLocal(Integer.parseInt(in2), Integer.parseInt(aux));
					}
					
					System.out.println("Local Eliminado");
					
					break;
				}
				
				///////////////Consultar local asignado////////////////////
				case "6":{
					System.out.println("Ingrese rut a buscar");
					String aux;
					in2 = lector.readLine();

					System.out.println("Ingrese la region a la que pertenece: ");
					aux = lector.readLine();
					regiones.buscarEnLocal(in2, Integer.parseInt(aux));

					break;
					
				}
				
				
				///////////////////Mostrar locales de una region////////////////////
				case "7":{
					System.out.println("Ingrese numero de region a buscar");
					in2 = lector.readLine();
					regiones.mostrarLocales(Integer.parseInt(in2));
					break;
				}
				
				////////////////Mostrar todas las personas////////////
				case "8":{
					System.out.println("\n----------Personas inscritas------------");
					votantes.mostrarLista();
					
					System.out.println("\n------------Personas no inscritas-----------");
					votantesSinAsignar.mostrarLista();
					
					break;
				}
				
				
				//////////////////Mostrar Personas en un rango de edad//////////////
				case "9":{
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
				
				case "10":{
					exit = true;
				}
				
				case "11":{
					
				}
				
			}
		}
		System.exit(0);
	}
	
}
