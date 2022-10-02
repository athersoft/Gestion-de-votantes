package entrega;
import java.util.HashMap;

public class MapaRegiones {
	private HashMap <Integer, Region> mapa;

	public MapaRegiones() {
		mapa = new HashMap<Integer,Region>();
		for(int j = 0; j< 16; j++) {
			mapa.put(j, new Region(j, "") );
		}
	}

	public void asignarLocal(ListaPersonas p) {
		boolean exit = false;
		Persona aux;
		while(!exit) {
			aux = p.getCurrent();
			if(aux != null) {
				mapa.get(aux.getRegion()-1).asignarLocal(aux, aux.getRegion()-1);
				p.deleteCurrent();
			}else {
				return;
			}
		}
		
		
	}
	
	public void agregarLocal(Local local, int region) {
		mapa.get(region).agregarLocal(local);
	}
	
	public void buscarEnLocal(String rut, int region) {
		mapa.get(region).searchLocal(rut);
	}
	
	public void mostrarLocales(int region) {
		mapa.get(region).mostrarLocales();
	}
	
	public Local buscarLocal(int num, int id) {
		if(mapa.get(num).buscarLocal(id) != null) {
			return mapa.get(num).buscarLocal(id);
		}else {
			System.out.println("El local no existe");
			return null;
		}
	}

	
}
