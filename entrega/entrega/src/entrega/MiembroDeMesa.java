package entrega;

public class MiembroDeMesa extends Persona{
	private String cargo;
	private boolean presente;
	
	public MiembroDeMesa() {
		cargo = "Ayudante";
		presente = false;
	}
	
	public MiembroDeMesa(String a) {
		cargo = a;
		presente = false;
	}


	public boolean isPresente() {
		return presente;
	}

	public void setPresente(boolean presente) {
		this.presente = presente;
	}
	
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
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
