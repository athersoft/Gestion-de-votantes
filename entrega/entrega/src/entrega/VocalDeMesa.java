package entrega;

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
	
	
}
