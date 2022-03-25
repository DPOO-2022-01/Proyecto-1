package Controller;

import java.util.ArrayList;

import Aplicación.Participante;
import Aplicación.Proyecto;

public class Controller {
	private ArrayList<Proyecto>proyectos;
	private ArrayList<Participante>participantes;
	
	public Controller() {
		this.proyectos =new ArrayList<>();
		this.participantes =new ArrayList<>();
	}
	
	public void crearParticipante(String nombre,String correo ) {
		Participante participante = new Participante(nombre,correo);
		participantes.add(participante);
		
	}
	
	public void crearProyecto(String nombreP, String descripcion, String fechaInicio, String fechaFinalizacion,int idParticipante) {
		Participante propietario =obtenerParticipante(idParticipante);
		Proyecto proyecto = new Proyecto(nombreP, descripcion, fechaInicio, fechaFinalizacion,propietario);
		proyectos.add(proyecto);
	}
	
	public void crearProyecto(String nombreP, String descripcion, String fechaInicio,int idParticipante) {
		Participante propietario =obtenerParticipante(idParticipante);
		Proyecto proyecto = new Proyecto(nombreP, descripcion, fechaInicio,propietario);
		proyectos.add(proyecto);
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
	
	
}
