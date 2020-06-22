package pe.edu.upeu.caso.entity;

public class Escuela {
	private int idescuela;
	private String nombre_escuela;
	
	public Escuela() {
		super();
	}
	public Escuela(int idescuela, String nombre_escuela) {
		super();
		this.idescuela = idescuela;
		this.nombre_escuela = nombre_escuela;
	}
	public int getIdescuela() {
		return idescuela;
	}
	public void setIdescuela(int idescuela) {
		this.idescuela = idescuela;
	}
	public String getNombre_escuela() {
		return nombre_escuela;
	}
	public void setNombre_escuela(String nombre_escuela) {
		this.nombre_escuela = nombre_escuela;
	}
	
	
}
