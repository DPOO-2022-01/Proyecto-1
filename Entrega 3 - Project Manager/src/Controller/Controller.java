package Controller;

import java.util.ArrayList;
import java.util.Timer;

import Aplicación.Actividad;
import Aplicación.Participante;
import Aplicación.Proyecto;
import Aplicación.TipoActividad;
import Aplicación.Cronometro;

public class Controller {
	private ArrayList<Proyecto>proyectos;
	private ArrayList<Participante>participantes;
	private Cronometro timer = new Cronometro();
	
	public Controller() {
		this.proyectos =new ArrayList<>();
		this.participantes =new ArrayList<>();
	}
	
	public Participante crearParticipante(String nombre,String correo ) {
		Participante participante = new Participante(nombre,correo);
		participantes.add(participante);
		return participante;
		
	}
	
	public Proyecto crearProyecto(String nombreP, String descripcion, String fechaInicio, String fechaFinalizacion,Participante propietario) 
	{
		Proyecto proyecto = new Proyecto(nombreP, descripcion, fechaInicio, fechaFinalizacion, propietario);
		proyecto.agregarParticipante(propietario);
		proyectos.add(proyecto);
		
		return proyecto;
	}
	
	public Actividad crearActividad(String titulo, String descripcion, TipoActividad tipo, String fecharealizacion,String horainicio,String horafin, Participante participante, Proyecto proyecto)
	{
		Actividad actividad = new Actividad(titulo, descripcion, tipo, fecharealizacion, horainicio, horafin, participante);
		proyecto.agregarActividad(actividad);
		return actividad;
		
	}
	
	public void agregarParticipanteProyecto(int idProyecto, int idParticipante) {
		Participante participante = obtenerParticipante(idParticipante);
		Proyecto proyecto = obtenerProyecto(idProyecto);
		proyecto.agregarParticipante(participante);
	}

	private Participante obtenerParticipante( int idParticipante) {
		return participantes.get(idParticipante-1);
	}
	private Proyecto obtenerProyecto( int idProyecto) {
		return proyectos.get(idProyecto-1);
	}

	public ArrayList<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(ArrayList<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<Participante> participantes) {
		this.participantes = participantes;
	}
	public void startCronometro() {
		timer.startTime();
	}
	public String getTiempo() {
		String tiempo = timer.getTiempo();
		return tiempo;
	}
	
	
}
