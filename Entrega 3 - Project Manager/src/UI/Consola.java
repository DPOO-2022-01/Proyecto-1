package UI;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import Aplicación.Actividad;
import Aplicación.Participante;
import Aplicación.Proyecto;
import Aplicación.TipoActividad;
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
						+ "¿Qué quieres hacer hoy?...\n"
						+ "1. Crear un proyecto\n"
						+ "2. Añadir participante\n"
						+ "3. Registrar una actividad\n"
						+ "4. Mostrar reporte de participantes\n"
						+ "0. Salir");
				opcion = Integer.parseInt(this.br.readLine()); 
				if(opcion == 1) {
					System.out.println("Hola dueño del proyecto! Primero necesitamos tus datos:\n"
							+ "Ingresa por favor tu nombre completo: \n");
					String nombre = this.br.readLine();
					System.out.println("Ingresa por favor tu dirección e-mail: \n");
					String email = this.br.readLine();
					Participante propietario = new Participante(nombre, email);

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

					Proyecto proyecto = controller.crearProyecto(nombreP, descripcion, fechaInicial, fechaFinalizacion, propietario);
					ArrayList<TipoActividad>tipoActividades = new ArrayList<>();
					System.out.println("Por favor ingrese los tipos de actividades que tendrá el proyecto separados por coma: \n");
					String[] tiposActividades = this.br.readLine().split(",");
					for (String tipo: tiposActividades) {
						TipoActividad tipoActividad = new TipoActividad();
						tipoActividad.setNombreTipoActividad(tipo);
						tipoActividad.setProyecto(proyecto);
						tipoActividades.add(tipoActividad);
					}
					proyecto.setTipoActividades(tipoActividades);
					System.out.println("Tu proyecto ha sido creado con éxito! \n");	
				}

				else if(opcion == 2) {

					if (controller.getProyectos().size() == 0) {
						System.out.println("Primero debes crear un proyecto para añadir participantes \n");
					}
					else {
						System.out.println("Ingresa por favor el nombre del proyecto: \n");
						String nombreProyecto = this.br.readLine();
						for (Proyecto proyecto: controller.getProyectos()) {
							if (proyecto.getNombre().equals(nombreProyecto)) {
								System.out.println("Por favor ingresa los datos del nuevo participante:\n"
										+ "Ingresa por favor tu nombre completo: \n");
								String nombre = this.br.readLine();
								System.out.println("Ingresa por favor tu dirección e-mail: \n");
								String email = this.br.readLine();
								Participante participante = controller.crearParticipante(nombre, email);
								proyecto.agregarParticipante(participante);
								System.out.println("Se agregó el participante con éxito! \n" + "El número de participantes en el proyecto es de: "
								+ proyecto.getParticipantes().size()+"\n");
							}
							else {
								System.out.println("El proyecto no existe, intenta de nuevo. \n"); 
							}
						}
					}
				}

				else if(opcion == 3){
					if (controller.getProyectos().size() == 0) {
						System.out.println("Primero debes crear un proyecto para registrar una actividad \n");
					}
					else {
						System.out.println("Ingresa por favor el nombre del proyecto: \n");
						String nombreProyecto = this.br.readLine();
						for (Proyecto proyecto: controller.getProyectos()) {
							if (proyecto.getNombre().equals(nombreProyecto)) {
								//proyecto es el Proyecto al que se le está registrando una actividad
								System.out.println("Por favor ingresa el título de la actividad que deseas registrar: \n");
								String titulo = this.br.readLine();
								System.out.println("Ingresa por favor una descripción corta de la actividad: \n");
								String descripcionA = this.br.readLine();
								System.out.println("Ingresa por favor la fecha en la que se realizó la actividad: \n");
								String fechaA = this.br.readLine();
								System.out.println("Ingresa por favor la hora de inicio: \n");
								String horaInicio = this.br.readLine();
								//Tiempo de actividad
								controller.startCronometro();

								System.out.println("Ingresa por favor la hora de finalización: \n");
								String horaFinal = this.br.readLine();
								System.out.println("Ingresa por favor el # del tipo de actividad que desea realizar: \n");
								int i = 1;
								for (TipoActividad tipo: proyecto.getTipoActividades()) {
									System.out.println( i + " " + tipo.getNombreTipoActividad());
									i++;
								}
								String numTipo = this.br.readLine();
								//Tipo es el tipo de actividad en el que se trabajo
								TipoActividad tipo = proyecto.getTipoActividades().get(Integer.parseInt(numTipo)-1);
								System.out.println("Selecciona el participante que realizaó la actividad: \n");
								int j = 1;
								for (Participante participante: proyecto.getParticipantes()) {
									System.out.println( j + " " + participante.getNombre());
									j++;
								}
								String numParticipante = this.br.readLine();
								//participant es el participante que realizó la actividad
								Participante participant = proyecto.getParticipantes().get(Integer.parseInt(numParticipante)-1);
								//TODO Implementar la adición del participante al hashMap de tiempoParticipante
								String nombreParticipante = participant.getNombre();

								if (tipo.getTiempoParticipantes().containsKey(nombreParticipante) == true) {
									int duracionMinutos = controller.getTiempo();
									int tiempoAnterior = tipo.getTiempoParticipantes().get(nombreParticipante).get(0);
									int participacionAnterior = tipo.getTiempoParticipantes().get(nombreParticipante).get(1);
									//Se sumó el tiempo pasado con el actual y se añadió al array del participante
									tipo.getTiempoParticipantes().get(nombreParticipante).set(0, duracionMinutos+tiempoAnterior);
									//Se sumó la participación anterior + 1 y se añadió al array del participante
									tipo.getTiempoParticipantes().get(nombreParticipante).set(1, participacionAnterior+1);
								}

								if (tipo.getTiempoParticipantes().containsKey(nombreParticipante) == false) {
									ArrayList<Integer> array = new ArrayList<>();
									tipo.getTiempoParticipantes().put(nombreParticipante, array);
									int duracionMinutos = controller.getTiempo();
									//Posición 0 del array = Tiempo de actividad 
									tipo.getTiempoParticipantes().get(nombreParticipante).add(duracionMinutos);
									//Posición 1 del array = número de participaciones
									tipo.getTiempoParticipantes().get(nombreParticipante).add(1);
								}
								System.out.println(participant.getNombre() + tipo.getNombreTipoActividad());
								controller.crearActividad(titulo, descripcionA, tipo, fechaA, horaInicio, horaFinal, participant, proyecto);
								for (Actividad actividad: proyecto.getActividades()) {
									System.out.println(actividad.getTitulo());
								}
							}

							else {
								System.out.println("El proyecto no existe, intenta de nuevo. \n"); 
							}
						}
					}
				}
				else if (opcion == 4) {
					if (controller.getProyectos().size() == 0) {
						System.out.println("Primero debes crear un proyecto para ver el reporte de los participantes \n");	
					} else {
						System.out.println("Ingresa por favor el nombre del proyecto: \n");
						String nombreProyecto = this.br.readLine();
						for (Proyecto proyecto: controller.getProyectos()) {
							if (proyecto.getNombre().equals(nombreProyecto)) {
								//Necesito recorrer la lista de participantes primero,
								//luego de eso, con cada valor del nombreParticipante pido que me obtenga el valor del hashmap
								//donde en el array de cada participante, el [0] = tiempo total
								//y [1] = tiempo promedio
								for (Participante participante : proyecto.getParticipantes()) {
									String nombreParticipante = participante.getNombre();
									for(TipoActividad tipoAct : proyecto.getTipoActividades()) {
										if (tipoAct.getTiempoParticipantes().isEmpty()) {
											System.out.println("No se puede mostrar reporte debido a que ningún participante ha registrado alguna actividad en: "+tipoAct.getNombreTipoActividad());
										} else {
											ArrayList<Integer> tiemposArray = tipoAct.getTiempoParticipantes().get(nombreParticipante);
											String nombreTipo = tipoAct.getNombreTipoActividad();
											int tiempoTotal = tiemposArray.get(0);
											int tiempoPromedio = tiempoTotal/tiemposArray.get(1);
											System.out.println(nombreParticipante + " en "+nombreTipo+":\n"+"Tiempo total: "+tiempoTotal+"\n"
													+"Tiempo promedio: "+tiempoPromedio);
										}
									}
								}
							} 
							else {
								System.out.println("El proyecto no existe, intenta de nuevo. \n"); 
							}
						}
						}
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
