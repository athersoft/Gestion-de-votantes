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
	
}
