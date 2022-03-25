package UI;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import Aplicación.Participante;

public class Consola {
	
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	
	public static void main(String[] args) {
		Consola consola = new Consola();
		consola.mostrarMenu();
	}

	private void mostrarMenu() {
		try {			
			int opcion;
			do {
				System.out.println("Bienvenido a Proyect Manager!\n"
						+ "¿Qué quieres hacer hoy?...\n"
						+ "1. Crear un proyecto\n"
						+ "2. \n"
						+ "3. \n"
						+ "0. Salir");
			opcion = Integer.parseInt(this.br.readLine()); 
			if(opcion == 1) {
				System.out.println("Hola dueño del proyecto! Primero necesitamos tus datos:\n"
						+ "Ingresa por favor tu nombre completo: \n");
				String nombre = this.br.readLine();
				System.out.println("Ingresa por favor tu dirección e-mail: \n");
				String email = this.br.readLine();
				boolean dueño = true;
				Participante participante = new Participante(nombre, email, dueño);	
				
				System.out.println("Gracias! \n"
						+ "------Tu nuevo proyecto necesitará información------\n"
						+ "Ingresa por favor el nombre de tu proyecto: \n");
				String nombreP = this.br.readLine();
				System.out.println("Ingresa por favor una descripción corta del proyecto: \n");
				String descripcion = this.br.readLine();
				System.out.println("Ingresa por favor la fecha inicial: \n");
				String fechaInicial = this.br.readLine();
				System.out.println("Ingresa por favor la fecha estimada de finalización: \n");
				String fechaFinalizacion = this.br.readLine();
				participante.crearProyecto(nombreP, descripcion, fechaInicial, fechaFinalizacion);
				
				System.out.println("Tu proyecto ha sido creado con éxito! \n");
						
				}
			else if(opcion == 2) {
				
				}
			else if(opcion == 3){
	
				}
			}
			
		while(opcion != 0);		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
