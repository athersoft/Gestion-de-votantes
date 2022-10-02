package ventanas;

public class VocalDeMesa extends Persona{
	private String cargo;
	private boolean presente;
	
	public VocalDeMesa() {
		cargo = "Ayudante";
		presente = false;
	}
	
	public VocalDeMesa(String a) {
		cargo = a;
		presente = false;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public boolean isPresente() {
		return presente;
	}

	public void setPresente(boolean presente) {
		this.presente = presente;
	}
	
	public void showData() {
		System.out.println("Nombre: " + getName());
		System.out.println("Edad: " + getAge());
		System.out.println("Rut: " + getRut());
		System.out.println("Cargo: " + cargo);
		System.out.println("Presente:" + presente);
		return;
	}
	
}
