package entrega;
import java.util.HashMap;

public class MapaRegiones {
	private HashMap <Integer, Region> mapa;

	public MapaRegiones() {
		mapa = new HashMap<Integer,Region>();
		for(int j = 1; j<= 16; j++) {
			mapa.put(j, new Region(j, "") );
		}
	}

	public void asignarLocal(Persona p, int region) {
		mapa.get(region).asignarLocal(p);
	}
	
	public void asignarPersonas(ListaPersonas p, ListaPersonas a) {
		Persona aux;
		while(true) {
			if(p.getCurrent() != null) {
				aux = p.getCurrent();
				if(mapa.get(aux.getRegion()).hayLocales()) {
					asignarLocal(aux, aux.getRegion());
					a.add(aux);
					p.deleteCurrent();
				}else {
					p.next();
				}
			}else {
				break;
			}
		}
		return;
	}
	
	public void asignarPersonas(ListaPersonas p) {
		Persona aux;
		while(true) {
			if(p.getCurrent() != null) {
				aux = p.getCurrent();
				asignarLocal(aux, aux.getRegion());
				p.next();
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
	
	public boolean eliminarLocal(int num, int id) {
		if(mapa.get(num).buscarLocal(id) != null) {
			mapa.get(num).eliminarLocal(id);
			return true;
		}
		return false;
	}

	
}
