package entrega;

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

	public static void main( String arg[] ) throws IOException{
		//Lector y variables para leer
		BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
		String in;
		String in2;
		
		boolean exit = false;
		
		//Inicializar regiones
		MapaRegiones regiones = new MapaRegiones();
		
		
		
		while(!exit) {
			//Opciones del menú
			
			System.out.println("1-Inscribir votante");
			System.out.println("2-Agregar centro de votacion");
			System.out.println("3-Consultar centro de votacion asignado");
			System.out.println("4-Mostrar locales de votacion por region");
			System.out.println("5-Mostrar votantes por rango de edad");
			System.out.println("6-Salir");
			in = lector.readLine();
			
			switch (in){
				
				case "1":{
					Persona votante;
					votante = new Persona();
					
					System.out.println("Ingrese numero de region donde reside");
					in2 = lector.readLine();
					votante.setRegion(Integer.parseInt(in2));
					
					if(Integer.parseInt(in2) > 0 && Integer.parseInt(in2) < 17) {
						
						System.out.println("Ingrese nombre");
						in2 = lector.readLine();
						votante.setName(in2);
						
						System.out.println("Ingrese rut");
						in2 = lector.readLine();
						votante.setRut(in2);
						
						System.out.println("Ingrese edad");
						in2 = lector.readLine();
						votante.setAge(Integer.parseInt(in2));
						
						regiones.get(votante.getRegion()-1).asignarLocal(votante);
						
					}else {
						System.out.println("Region no válida");
					}
					
					break;
					
				}
				
				case "2":{
					Local local = new Local();
					
					System.out.println("Ingrese id del local");
					in2 = lector.readLine();
					local.setId(Integer.parseInt(in2));
					
					System.out.println("Ingrese capacidad maxima");
					in2 = lector.readLine();
					local.setCapacidad(Integer.parseInt(in2));
					
					System.out.println("Ingrese direccion");
					in2 = lector.readLine();
					local.setDireccion(in2);
					
					System.out.println("Ingrese numero de region");
					in2 = lector.readLine();
					
					regiones.get(Integer.parseInt(in2)).agregarLocal(local);
					
					System.out.println("Local agregado correctamente");
				}
				
				case "3":{
					System.out.println("Ingrese rut a buscar");
					String aux;
					in2 = lector.readLine();

					System.out.println("Ingrese la region a la que pertenece: ");
					aux = lector.readLine();
					regiones.mapa.get(Integer.parseInt(aux)).searchLocal(in2, Integer.parseInt(aux));

					
					break;
					
				}
				
				case "4":{
					System.out.println("Ingrese numero de region a buscar");
					in2 = lector.readLine();
					
					regiones.get(Integer.parseInt(in2)).mostrarLocales();
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
				
				case "5":{
					exit = true;
				}
				
			}
		}
		System.exit(0);
	}
	
}
