package entrega;
import java.util.ArrayList;

public class Region {
	private int num;
	private String name;
	private ArrayList<Local> locales = new ArrayList<Local>();
	
	public Region(int a, String b) {
		num = a;
		name = b;
	}
	
	public void setName(String n) {
		name = n;
		return;
	}
	
	public void setNum(int n) {
		num = n;
		return;
	}
	
	public String getName() {
		return name;
	}
	
	public int getnum() {
		return num;
	}
	
}
