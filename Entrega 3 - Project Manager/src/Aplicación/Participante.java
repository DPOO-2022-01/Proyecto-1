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
	//Constructor
		public Participante(String nombre, String email) {
				this.nombre = nombre;
				this.email = email;
				
		
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
	@Override
	public String toString() {
		return  "[nombre=" + nombre + ", email=" + email + "]";
	}
	
	
	
	//Métodos
	
	//public void crearProyecto(String nombreP, String descripcion, String fechaInicio, String fechaFinalizacion) {
		//Proyecto p = new Proyecto(nombreP, descripcion, fechaInicio, fechaFinalizacion);	
	//}
	
}
// se recomineda borrar la variable dueño porque el ser dueño no es propio de un partipande es decor el participante no puede ser dueño de todos los proyectos 
// el metodo crear proyecto no es propio de un participante este deberia poner en clase controlador