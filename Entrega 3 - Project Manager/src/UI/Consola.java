package UI;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import Aplicaci�n.Actividad;
import Aplicaci�n.Participante;
import Aplicaci�n.Proyecto;
import Aplicaci�n.TipoActividad;
import Mediador.Aplicacion;

public class Consola {

	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private Aplicacion mediador;

	public static void main(String[] args) {
		Consola consola = new Consola();

	}

	public Consola () {
		mediador =new Aplicacion();
		mostrarMenu();
	}
	
	//Men� principal
	private void mostrarMenu() {
		try {			
			int opcion;
			do {
				System.out.println("\nBienvenido a Proyect Manager!\n"
						+ "�Qu� quieres hacer hoy?...\n"
						+ "1. Crear un proyecto\n"
						+ "2. A�adir participante\n"
						+ "3. Registrar una actividad\n"
						+ "4. Mostrar reporte de participantes\n"
						+ "0. Salir");
				opcion = Integer.parseInt(this.br.readLine()); 
				
				//En la opci�n 1 se crea un proyecto, para esto necesitamos los datos del propietario y otras caracter�sticas propias del proyecto.
				if(opcion == 1) {
					System.out.println("Hola due�o del proyecto! Primero necesitamos tus datos:\n"
							+ "Ingresa por favor tu nombre completo: \n");
					String nombre = this.br.readLine();
					System.out.println("Ingresa por favor tu direcci�n e-mail: \n");
					String email = this.br.readLine();
					Participante propietario = new Participante(nombre, email);

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
					
					//Ya obtenidos los datos, se procede a crear el proyecto.
					Proyecto proyecto = mediador.crearProyecto(nombreP, descripcion, fechaInicial, fechaFinalizacion, propietario);
					
					//Se asignan los tipos de actividad que va a tener el proyecto.
					ArrayList<TipoActividad>tipoActividades = new ArrayList<>();
					System.out.println("Por favor ingrese los tipos de actividades que tendr� el proyecto separados por coma: \n");
					String[] tiposActividades = this.br.readLine().split(",");
					for (String tipo: tiposActividades) {
						TipoActividad tipoActividad = new TipoActividad();
						tipoActividad.setNombreTipoActividad(tipo);
						tipoActividad.setProyecto(proyecto);
						tipoActividades.add(tipoActividad);
					}
					proyecto.setTipoActividades(tipoActividades);
					System.out.println("Tu proyecto ha sido creado con �xito! \n");	
				}
				
				//La opci�n 2 permite a�adir participantes, para esto primero se v�lida que exista un proyecto ya creado.
				//Luego, se procede a pedir el nombre del proyecto para asociarlo y poder agregar al participante a ese proyecto.
				else if(opcion == 2) {
					
					if (mediador.getProyectos().size() == 0) {
						System.out.println("Primero debes crear un proyecto para a�adir participantes \n");
					}
					else {
						System.out.println("Ingresa por favor el nombre del proyecto: \n");
						String nombreProyecto = this.br.readLine();
						for (Proyecto proyecto: mediador.getProyectos()) {
							if (proyecto.getNombre().equals(nombreProyecto)) {
								System.out.println("Por favor ingresa los datos del nuevo participante:\n"
										+ "Ingresa por favor tu nombre completo: \n");
								String nombre = this.br.readLine();
								System.out.println("Ingresa por favor tu direcci�n e-mail: \n");
								String email = this.br.readLine();
								
								//Luego de obtenidos los datos se crea el participante y se agrega el participante al proyecto.
								Participante participante = mediador.crearParticipante(nombre, email);
								proyecto.agregarParticipante(participante);
								System.out.println("Se agreg� el participante con �xito! \n" + "El n�mero de participantes en el proyecto es de: "
								+ proyecto.getParticipantes().size()+"\n");
							}
							else {
								System.out.println("El proyecto no existe, intenta de nuevo. \n"); 
							}
						}
					}
				}
				
				//La opci�n 3 permite registrar una actividad en el proyecto, para esto primero se v�lida que exista un proyecto ya creado.
				//Luego, se procede a pedir el nombre del proyecto para asociarlo y poder agregar la actividad a ese proyecto.
				else if(opcion == 3){
					if (mediador.getProyectos().size() == 0) {
						System.out.println("Primero debes crear un proyecto para registrar una actividad \n");
					}
					else {
						System.out.println("Ingresa por favor el nombre del proyecto: \n");
						String nombreProyecto = this.br.readLine();
						for (Proyecto proyecto: mediador.getProyectos()) {
							if (proyecto.getNombre().equals(nombreProyecto)) {
								//proyecto es el Proyecto al que se le estar� registrando una actividad
								System.out.println("Por favor ingresa el t�tulo de la actividad que deseas registrar: \n");
								String titulo = this.br.readLine();
								System.out.println("Ingresa por favor una descripci�n corta de la actividad: \n");
								String descripcionA = this.br.readLine();
								System.out.println("Ingresa por favor la fecha en la que se realiz� la actividad: \n");
								String fechaA = this.br.readLine();
								System.out.println("Ingresa por favor la hora de inicio: \n");
								String horaInicio = this.br.readLine();
								//Tiempo de actividad
								mediador.startCronometro();

								System.out.println("Ingresa por favor la hora de finalizaci�n: \n");
								String horaFinal = this.br.readLine();
								System.out.println("Ingresa por favor el # del tipo de actividad que desea realizar: \n");
								int i = 1;
								for (TipoActividad tipo: proyecto.getTipoActividades()) {
									System.out.println( i + " " + tipo.getNombreTipoActividad());
									i++;
								}
								String numTipo = this.br.readLine();
								//Tipo es el tipo de actividad en el que se trabaj�
								TipoActividad tipo = proyecto.getTipoActividades().get(Integer.parseInt(numTipo)-1);
								System.out.println("Selecciona el participante que realiz� la actividad: \n");
								int j = 1;
								for (Participante participante: proyecto.getParticipantes()) {
									System.out.println( j + " " + participante.getNombre());
									j++;
								}
								String numParticipante = this.br.readLine();
								//participant es el participante que realiz� la actividad
								Participante participant = proyecto.getParticipantes().get(Integer.parseInt(numParticipante)-1);
								String nombreParticipante = participant.getNombre();

								if (tipo.getTiempoParticipantes().containsKey(nombreParticipante) == true) {
									int duracionMinutos = mediador.getTiempo();
									int tiempoAnterior = tipo.getTiempoParticipantes().get(nombreParticipante).get(0);
									int participacionAnterior = tipo.getTiempoParticipantes().get(nombreParticipante).get(1);
									//Se suma el tiempo pasado con el actual y se a�ade al array del participante
									tipo.getTiempoParticipantes().get(nombreParticipante).set(0, duracionMinutos+tiempoAnterior);
									//Se suma la participaci�n anterior + 1 y se a�ade al array del participante
									tipo.getTiempoParticipantes().get(nombreParticipante).set(1, participacionAnterior+1);
								}

								if (tipo.getTiempoParticipantes().containsKey(nombreParticipante) == false) {
									ArrayList<Integer> array = new ArrayList<>();
									tipo.getTiempoParticipantes().put(nombreParticipante, array);
									int duracionMinutos = mediador.getTiempo();
									//Posici�n 0 del array = Tiempo de actividad 
									tipo.getTiempoParticipantes().get(nombreParticipante).add(duracionMinutos);
									//Posici�n 1 del array = n�mero de participaciones
									tipo.getTiempoParticipantes().get(nombreParticipante).add(1);
								}
								System.out.println("El participante que realiz� la actividad es: " + participant.getNombre() + " \n"
								+ "El tipo de actividad que realiz� fue: "+ tipo.getNombreTipoActividad());
								
								//Luego de obtenido los datos, se procede a crear la actividad en el proyecto.
								mediador.crearActividad(titulo, descripcionA, tipo, fechaA, horaInicio, horaFinal, participant, proyecto);
								
								System.out.println("Las actividades que hay en el proyecto son: ");
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
				
				//La opci�n 4 permite mostrar un reporte por participante, para esto primero se v�lida que exista un proyecto ya creado.
				//Luego, se procede a pedir el nombre del proyecto para asociarlo y poder mostrar el reporte de dicho proyecto.
				else if (opcion == 4) {
					if (mediador.getProyectos().size() == 0) {
						System.out.println("Primero debes crear un proyecto para ver el reporte de los participantes \n");	
					} else {
						System.out.println("Ingresa por favor el nombre del proyecto: \n");
						String nombreProyecto = this.br.readLine();
						for (Proyecto proyecto: mediador.getProyectos()) {
							if (proyecto.getNombre().equals(nombreProyecto)) {
								//Necesito recorrer la lista de participantes primero,
								//luego de eso, con cada valor del nombreParticipante pido que me obtenga el valor del hashmap
								//donde en el array de cada participante, el [0] = tiempo total
								//y [1] = tiempo promedio
								for (Participante participante : proyecto.getParticipantes()) {
									String nombreParticipante = participante.getNombre();
									for(TipoActividad tipoAct : proyecto.getTipoActividades()) {
										if (tipoAct.getTiempoParticipantes().isEmpty()) {
											System.out.println("No se puede mostrar reporte debido a que ning�n participante ha registrado alguna actividad en: "+tipoAct.getNombreTipoActividad());
										} else {
											ArrayList<Integer> tiemposArray = tipoAct.getTiempoParticipantes().get(nombreParticipante);
											String nombreTipo = tipoAct.getNombreTipoActividad();
											int tiempoTotal = tiemposArray.get(0);
											int tiempoPromedio = tiempoTotal/tiemposArray.get(1);
											//NOTA: Los tiempos son en mins as� que si no pas� m�s de un min en la actividad, mostrar� 0.
											System.out.println(nombreParticipante + " en "+nombreTipo+":\n"+"Tiempo total en mins: "+tiempoTotal+"\n"
													+"Tiempo promedio en mins: "+tiempoPromedio);
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

		}
