package Aplicación;

import java.util.ArrayList;

public class Proyecto {
	
	//Atributos
	
	private String nombre;
	private String descripcion;
	private String fechaInicio;
	private String fechaFinalizacion;
	private Participante propietario;
	private ArrayList<Participante>participantes;
	private ArrayList<TipoActividad>tipoActividades;
	private ArrayList<Actividad>actividades;
	
	//Constructor
	public Proyecto(String nombre, String descripcion, String fechaInicio, String fechaFinalizacion,Participante propietario) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFinalizacion = fechaFinalizacion;
		this.propietario = propietario;
		this.participantes = new ArrayList<>();
		this.actividades = new ArrayList<>();
	}
	
	public Participante getPropietario() {
		return propietario;
	}

	public void setPropietario(Participante propietario) {
		this.propietario = propietario;
	}

	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<Participante> participantes) {
		this.participantes = participantes;
	}

	public ArrayList<TipoActividad> getTipoActividades() {
		return tipoActividades;
	}

	public void setTipoActividades(ArrayList<TipoActividad> tipoActividades) {
		this.tipoActividades = tipoActividades;
	}

	//Métodos
	public void agregarParticipante(Participante participante) {
		this.participantes.add(participante);
		
	}
	
	public void agregarActividad(Actividad actividad) {
		this.actividades.add(actividad);
		
	}


	public  ArrayList<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(ArrayList<Actividad> actividades) {
		this.actividades = actividades;
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
	
	
	
}
