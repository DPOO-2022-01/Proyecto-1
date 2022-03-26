package UI;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import Aplicaci�n.Cronometro;
import Aplicaci�n.Participante;
import Controller.Controller;

public class Consola {
	
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private Controller controller;
	
	public static void main(String[] args) {
		Consola consola = new Consola();
		
	}

	public Consola () {
		controller=new Controller();
		mostrarMenu();
	}
	private void mostrarMenu() {
		try {			
			int opcion;
			do {
				System.out.println("Bienvenido a Proyect Manager!\n"
						+ "�Qu� quieres hacer hoy?...\n"
						+ "1. Crear un proyecto\n"
						+ "2. Crear participante\n"
						+ "3. \n"
						+ "0. Salir");
			opcion = Integer.parseInt(this.br.readLine()); 
			if(opcion == 1) {
				/*System.out.println("Hola due�o del proyecto! Primero necesitamos tus datos:\n"
						+ "Ingresa por favor tu nombre completo: \n");
				String nombre = this.br.readLine();
				System.out.println("Ingresa por favor tu direcci�n e-mail: \n");
				String email = this.br.readLine();
				boolean due�o = true;
				Participante participante = new Participante(nombre, email, due�o);*/	
				
				System.out.println("Gracias! \n"
						+ "------Tu nuevo proyecto necesitar� informaci�n------\n"
						+ "Ingresa por favor el nombre de tu proyecto: \n");
				String nombreP = this.br.readLine();
				System.out.println("Ingresa por favor una descripci�n corta del proyecto: \n");
				String descripcion = this.br.readLine();
				System.out.println("Ingresa por favor la fecha inicial: \n");
				String fechaInicial = this.br.readLine();
				System.out.println("Ingresa por favor la fecha estimada de finalizaci�n: \n");
				String fechaFinalizacion = this.br.readLine();
				System.out.println("Lista de participantes");
				mostrarParticipantes();
				System.out.println("Seleccion el due�o del Proyecto: \n");
				int idParticipante = this.br.read();
				controller.crearProyecto(nombreP, descripcion, fechaInicial, fechaFinalizacion, idParticipante);
				//participante.crearProyecto(nombreP, descripcion, fechaInicial, fechaFinalizacion);
				
				System.out.println("Tu proyecto ha sido creado con �xito! \n");
						
				}
			else if(opcion == 2) {
				System.out.println("Por favor ingresa los datos del nuevo participante:\n"
						+ "Ingresa por favor tu nombre completo: \n");
				String nombre = this.br.readLine();
				System.out.println("Ingresa por favor tu direcci�n e-mail: \n");
				String email = this.br.readLine();
				controller.crearParticipante(nombre, email);
				
				}
			else if(opcion == 3){
				Cronometro timer = new Cronometro();
				timer.startTime();
				}
			}
			
		while(opcion != 0);		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	private void mostrarParticipantes() {
		for(int i=0;i<controller.getParticipantes().size();i++) {
			System.out.println((i+1)+") "+controller.getParticipantes().get(i));
		}
	}
}
