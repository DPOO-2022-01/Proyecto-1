package Aplicación;

public class Participante {
	
	//Atributos
	
		private String nombre;
		private String email;
		private boolean dueño;
		
	//Constructor
	public Participante(String nombre, String email, boolean dueño) {
			this.nombre = nombre;
			this.email = email;
			this.dueño = dueño;
		}

	//Getters
	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return email;
	}

	public boolean getDueño() {
		return dueño;
	}
	
	//Métodos
	
	public void crearProyecto(String nombreP, String descripcion, String fechaInicio, String fechaFinalizacion) {
		Proyecto p = new Proyecto(nombreP, descripcion, fechaInicio, fechaFinalizacion);	
	}
	
}
