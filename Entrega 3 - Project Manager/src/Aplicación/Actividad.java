package Aplicación;

import java.util.ArrayList;

public class Actividad {
	//Atributos
	
		private String titulo;
		private String descripcion;
		private TipoActividad tipo;
		private String fecharealizacion;
		private String horainicio;
		private String horafin;
		private ArrayList<Participante>participantes;
	

//Constructor
	public Actividad(String titulo, String descripcion, TipoActividad tipo, String fecharealizacion,String horainicio,String horafin, Participante participante) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.fecharealizacion = fecharealizacion;
		this.horainicio = horainicio;
		this.horafin=horafin;
		this.participantes = new ArrayList<>();
	  }
	public void agregarParticipante(Participante participante) {
		this.participantes.add(participante);
	}
	
	
	//Getters and Setters



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public TipoActividad getTipo() {
		return tipo;
	}



	public void setTipo(TipoActividad tipo) {
		this.tipo = tipo;
	}



	public String getFecharealizacion() {
		return fecharealizacion;
	}



	public void setFecharealizacion(String fecharealizacion) {
		this.fecharealizacion = fecharealizacion;
	}



	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}



	public void setParticipantes(ArrayList<Participante> participantes) {
		this.participantes = participantes;
	}
	



	public String getHorainicio() {
		return horainicio;
	}



	public void setHorainicio(String horainicio) {
		this.horainicio = horainicio;
	}



	public String getHorafin() {
		return horafin;
	}



	public void setHorafin(String horafin) {
		this.horafin = horafin;
	}
	
	
}



	
