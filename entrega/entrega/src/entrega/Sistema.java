package entrega;

//Integrantes: Bryam Gonzalez, Matías Romero, Eduardo Marín
import java.io.*;

public class Sistema {
	
	
	public static void cargarNoInscritos(ListaPersonas p) throws IOException{
		String filePath = "personasNoInscritas.txt";
		try{

			throw new FilesException();
		}catch(FilesException a){
			if(a.UnsupportedMediaException(filePath) == true){
				System.exit(0);
			}
		}
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
		try{

			throw new FilesException();
		}catch(FilesException a){
			if(a.UnsupportedMediaException(filePath) == true){
				System.exit(0);
			}
		}
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
		try{

			throw new FilesException();
		}catch(FilesException a){
			if(a.UnsupportedMediaException(filePath) == true){
				System.exit(0);
			}
		}
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
		String in = null;
		String in2 = null;
		String aux = null;
		boolean exit = false;
		
		//Inicializar regiones
		MapaRegiones regiones = new MapaRegiones();
		ListaPersonas votantes = new ListaPersonas();
		ListaPersonas votantesSinAsignar = new ListaPersonas();
		Creador crear = new Creador();
		
		cargarNoInscritos(votantesSinAsignar);
		cargarInscritos(votantes);
		cargarLocales(regiones);
		
		regiones.asignarPersonas(votantes);
		
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

			try {
				in = lector.readLine( );
				} catch( IOException e ) {
				System.out.println( "Error de input." );
				}
			//in = lector.readLine();
			
			switch (in){
			
				/////////////Inscribir Votante//////////////////////
				case "1":{
					System.out.println("\n--------Inscripcion de votante--------\n");
					Persona votante = crear.persona();
					votantesSinAsignar.add(votante);
					
					break;
				}
				
				//////////////Asignar Votantes///////////////////
				
				case "2":{
					regiones.asignarPersonas(votantesSinAsignar,votantes);
					System.out.println("\n--------Votantes Asignados---------\n");
					break;
				}
				
				////////////////Agregar centro de votacion//////////////
				case "3":{
					Local local = crear.local();
					System.out.println("Ingrese numero de region");
					try {
						in2 = lector.readLine( );
						} catch( IOException e ) {
						System.out.println( "Error de input." );
						}
					
					regiones.agregarLocal(local, Integer.parseInt(in2));
					
					FileWriter myWriter = new FileWriter("Locales.txt",true);
					myWriter.append(in2+",");
					myWriter.append(local.getId()+",");
					myWriter.append(local.getCapacidad()+",");
					myWriter.append(local.getDireccion()+"");
					myWriter.append("\n");
					myWriter.close();
					 
					System.out.println("\n--------Local agregado correctamente---------\n");
					break;
				}
				
				///////////////Modificar local de votacion////////////////
				case "4":{
					
					System.out.println("Ingrese region");
					try {
						in2 = lector.readLine( );
						} catch( IOException e ) {
						System.out.println( "Error de input." );
						}
					System.out.println("Ingrese id de local a modificar");
					aux = lector.readLine();
					try {
						aux = lector.readLine( );
						} catch( IOException e ) {
						System.out.println( "Error de input." );
						}
					
					Local local = regiones.buscarLocal(Integer.parseInt(in2), Integer.parseInt(aux));
					if(local != null) {
						local = crear.modificarLocal(local);
					}
					
					ListaPersonas l;
					l = regiones.eliminarLocal(Integer.parseInt(in2), Integer.parseInt(aux));
					
					regiones.agregarLocal(local, Integer.parseInt(in2));
					regiones.asignarPersonas(l);
					
					System.out.println("\n--------Modificacion Exitosa---------\n");
					break;
				}
				
				///////////////Eliminar local//////////////////////////
				case "5":{
					System.out.println("Ingrese region");
					try {
						in2 = lector.readLine( );
						} catch( IOException e ) {
						System.out.println( "Error de input." );
						}
					System.out.println("Ingrese id de local a eliminar");
					try {
						aux = lector.readLine( );
						} catch( IOException e ) {
						System.out.println( "Error de input." );
						}
					
					if(regiones.buscarLocal(Integer.parseInt(in2), Integer.parseInt(aux)) != null) {
						ListaPersonas l;
						l = regiones.eliminarLocal(Integer.parseInt(in2), Integer.parseInt(aux));
						votantesSinAsignar.agregarLista(l);
					}
					
					System.out.println("\n--------Local Eliminado---------\n");
					break;
				}
				
				///////////////Consultar local asignado////////////////////
				case "6":{
					System.out.println("Ingrese rut a buscar");
					try {
						in2 = lector.readLine( );
						} catch( IOException e ) {
						System.out.println( "Error de input." );
						}

					System.out.println("Ingrese la region a la que pertenece: ");
					
					try {
						aux = lector.readLine( );
						} catch( IOException e ) {
						System.out.println( "Error de input." );
						}
					regiones.buscarEnLocal(in2, Integer.parseInt(aux));

					break;
					
				}
				
				
				///////////////////Mostrar locales de una region////////////////////
				case "7":{
					System.out.println("Ingrese numero de region a buscar");
					try {
						in2 = lector.readLine( );
						} catch( IOException e ) {
						System.out.println( "Error de input." );
						}
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
					System.out.println("Ingrese minima edad a mostrar");
					try {
						in2 = lector.readLine( );
						} catch( IOException e ) {
						System.out.println( "Error de input." );
						}
					System.out.println("Ingrese maxima edad a mostrar");
					try {
						aux = lector.readLine( );
						} catch( IOException e ) {
						System.out.println( "Error de input." );
						}
					
					votantes.mostrarPorEdad(Integer.parseInt(in2), Integer.parseInt(aux));
					
					break;
				}
				
				///////////Salir///////////////
				case "10":{
					votantes.guardar("personasInscritas.txt");
					votantesSinAsignar.guardar("personasNoInscritas.txt");
					System.out.println("\n--------Programa Terminado---------\n");
					exit = true;
				}
				
				
			}
		}
		System.exit(0);
	}
	
}
