package Aplicación;

import java.util.ArrayList;

public class Actividad {
	//Atributos
	
		private String titulo;
		private String descripcion;
		private String tipo;
		private String fecharealizacion;
		private int horainicio;
		private int horafin;
		private ArrayList<Participante>participantes;
		


//Constructor
	public Actividad(String titulo, String descripcion, String tipo, String fecharealizacion,int horainicio,int horafin) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fecharealizacion = fecharealizacion;
		this.horainicio = horainicio;
		this.horafin=horafin;
		this.participantes = new ArrayList<>();
	  }
	//Métodos



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



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public String getFecharealizacion() {
		return fecharealizacion;
	}



	public void setFecharealizacion(String fecharealizacion) {
		this.fecharealizacion = fecharealizacion;
	}



	public int getHorainicio() {
		return horainicio;
	}



	public void setHorainicio(int horainicio) {
		this.horainicio = horainicio;
	}



	public int getHorafin() {
		return horafin;
	}



	public void setHorafin(int horafin) {
		this.horafin = horafin;
	}



	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}



	public void setParticipantes(ArrayList<Participante> participantes) {
		this.participantes = participantes;
	}
	
	}
	
