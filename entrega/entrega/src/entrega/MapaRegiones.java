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

	public void asignarLocal(Persona p, int region) {
		mapa.get(region).asignarLocal(p);
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
}
