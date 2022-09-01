package entrega;

//Integrantes: Bryam Gonzalez, Matías Romero, Eduardo Marín
import java.io.*;

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
		int i = 0;
		boolean found = false;
		Persona[] contactos = new Persona[30];
		

		//Inicializar regiones
		Region regiones[] = new Region[16];
		for(int j = 0; j< 16; j++) {
			regiones[j].setNum(j);
		}
		
		int pLibre = 0;
		
		while(!exit) {
			//Opciones del menú
			System.out.println("1-Inscribir votante");
			System.out.println("2-Consultar centro de votacion asignado");
			System.out.println("3-Mostrar locales de votacion por region");
			System.out.println("4-Salir");
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
						
						regiones[votante.getRegion()-1].asignarLocal(votante);
						//contactos[pLibre] = votante;
						//pLibre++;
						
					}else {
						System.out.println("Region no válida");
					}
					
					break;
					
				}
				
				case "2":{
					i = 0;
					if(pLibre > 0) {
						while (i < pLibre) {
							System.out.println("");
							contactos[i].showData();
							i++;
							System.out.println("");
						}
					}
					break;
				}
				
				
				case "3":{
					System.out.println("Ingrese rut a buscar");
					in2 = lector.readLine();
					
					i = 0;
					if(pLibre > 0) {
						while (i < pLibre) {
							if((contactos[i].getRut()).equals(in2)) {
								found = true;
								break;
							}
							i++;
						}
						
					}
					
					if(!found) {
						System.out.println("Usuario no encontrado");
					}else {
						contactos[i].showData();
					}
					
					found = false;
					
					break;
					
				}
				
				case "4":{
					exit = true;
				}
				
			}
		}
		System.exit(0);
	}
	
}
