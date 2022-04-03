package Mediador;

import java.util.ArrayList;
import java.util.Timer;

import Aplicación.Actividad;
import Aplicación.Participante;
import Aplicación.Proyecto;
import Aplicación.TipoActividad;
import Aplicación.Cronometro;

public class Aplicacion {
	
	//Atributos
	private ArrayList<Proyecto>proyectos;
	private ArrayList<Participante>participantes;
	private Cronometro timer = new Cronometro();
	
	public Aplicacion() {
		this.proyectos =new ArrayList<>();
		this.participantes =new ArrayList<>();
	}
	
	//Todas estas funciones sirven como mediador entre la consola y la lógica. Esto es para un menor acoplamiento
	
	
	
	//Este método crea un participante, a partir de los parámetros nombre y correo. Y lo añade a la vez a una lista de participantes.
	public Participante crearParticipante(String nombre,String correo ) {
		Participante participante = new Participante(nombre,correo);
		participantes.add(participante);
		return participante;
		
	}
	
	//Este método crea un proyecto, a partir de los parámetros. Y lo añade a la vez a una lista de proyectos. 
	//Además, se le asigna actumáticamente el participante propietario del proyecto y se agrega a la lista de participantes.
	public Proyecto crearProyecto(String nombreP, String descripcion, String fechaInicio, String fechaFinalizacion,Participante propietario) 
	{
		Proyecto proyecto = new Proyecto(nombreP, descripcion, fechaInicio, fechaFinalizacion, propietario);
		proyecto.agregarParticipante(propietario);
		proyectos.add(proyecto);
		
		return proyecto;
	}
	
	//Este método crea una actividad, a partir de los parámetros. Y lo añade a la vez a una lista de actividades en el proyecto. 
	public Actividad crearActividad(String titulo, String descripcion, TipoActividad tipo, String fecharealizacion,String horainicio,String horafin, Participante participante, Proyecto proyecto)
	{
		Actividad actividad = new Actividad(titulo, descripcion, tipo, fecharealizacion, horainicio, horafin, participante);
		proyecto.agregarActividad(actividad);
		return actividad;
		
	}
	
	//Este método agrega un participante a un proyecto, a partir de los parámetros idProyecto y idParticipante.
	public void agregarParticipanteProyecto(int idProyecto, int idParticipante) {
		Participante participante = obtenerParticipante(idParticipante);
		Proyecto proyecto = obtenerProyecto(idProyecto);
		proyecto.agregarParticipante(participante);
	}
	
	
	//Getters and Setters

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
	public int getTiempo() {
		return timer.tiempoEnMins();
	}

}
