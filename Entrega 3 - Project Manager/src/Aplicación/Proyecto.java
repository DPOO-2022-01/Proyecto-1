package Aplicación;

public class Proyecto {
	
	//Atributos
	
	private String nombre;
	private String descripcion;
	private String fechaInicio;
	private String fechaFinalizacion;
	
	
	//Constructor
	public Proyecto(String nombre, String descripcion, String fechaInicio, String fechaFinalizacion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFinalizacion = fechaFinalizacion;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public String getFechaFinalizacion() {
		return fechaFinalizacion;
	}


	public void setFechaFinalizacion(String fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}
	
	//Métodos
	
}
