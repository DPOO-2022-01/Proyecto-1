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

	public boolean getDue�o() {
		return due�o;
	}
	@Override
	public String toString() {
		return  "[nombre=" + nombre + ", email=" + email + "]";
	}
	
	
	
	//M�todos
	
	//public void crearProyecto(String nombreP, String descripcion, String fechaInicio, String fechaFinalizacion) {
		//Proyecto p = new Proyecto(nombreP, descripcion, fechaInicio, fechaFinalizacion);	
	//}
	
}
// se recomineda borrar la variable due�o porque el ser due�o no es propio de un partipande es decor el participante no puede ser due�o de todos los proyectos 
// el metodo crear proyecto no es propio de un participante este deberia poner en clase controlador