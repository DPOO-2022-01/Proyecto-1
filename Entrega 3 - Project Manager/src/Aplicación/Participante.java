package Aplicaci�n;

public class Participante {
	
	//Atributos
	
		private String nombre;
		private String email;
		private boolean due�o;
		
	//Constructor
	public Participante(String nombre, String email, boolean due�o) {
			this.nombre = nombre;
			this.email = email;
			this.due�o = due�o;
		}

	//Getters
	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return email;
	}

	public boolean getDue�o() {
		return due�o;
	}
	
	//M�todos
	
	public void crearProyecto(String nombreP, String descripcion, String fechaInicio, String fechaFinalizacion) {
		Proyecto p = new Proyecto(nombreP, descripcion, fechaInicio, fechaFinalizacion);	
	}
	
}
