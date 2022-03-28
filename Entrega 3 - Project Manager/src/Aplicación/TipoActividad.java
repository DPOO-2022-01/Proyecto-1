package Aplicación;

import java.util.ArrayList;

public class TipoActividad 
{

	private String nombreTipoActividad;
	private Proyecto proyecto;
	
	
	
	//Getters and Setters
	
	public Proyecto getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	public String getNombreTipoActividad() {
		return nombreTipoActividad;
	}
	public void setNombreTipoActividad(String nombreTipoActividad) {
		this.nombreTipoActividad = nombreTipoActividad;
	}
	
}
