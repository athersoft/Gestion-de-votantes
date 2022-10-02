package entrega;

import java.util.ArrayList;

public class ListaMiembrosDeMesa extends ListaPersonas{
	
	private ArrayList<MiembroDeMesa> miembros;
	
	public ListaMiembrosDeMesa() {
		miembros = new ArrayList<MiembroDeMesa>();
	}
	
	public void add(MiembroDeMesa p){
		miembros.add(p);
		return;
	}
	
	public void mostrarLista() {
		for(MiembroDeMesa i: miembros){
			i.showData();
		}
		
		if(miembros.size() == 0) {
			System.out.println("No hay miembros de mesa\n");
		}
	}

}
