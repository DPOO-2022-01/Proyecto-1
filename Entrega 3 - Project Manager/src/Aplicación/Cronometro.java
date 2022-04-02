package Aplicación;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.naming.InitialContext;
import javax.swing.Timer;

public class Cronometro {
	private javax.swing.Timer cronometro;
	private int centesimas_segundo = 0;
	private int segundos = 0;
	private int minutos = 0;
	private int horas = 0;
	private String tiempo = "";
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private ActionListener accion = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			centesimas_segundo++;
			if (centesimas_segundo == 100) {
				segundos++;
				centesimas_segundo = 0;
			}
			if (segundos == 60) {
				minutos++;
				segundos = 0;
			}
			if (minutos == 60) {
				horas++;
				minutos = 0;
			}
			actualizarTiempo();
		}
	};
	private void actualizarTiempo() {
		String tiempo = (horas<=9?"0":"")
				+horas+":"+(minutos<=9?"0":"")+minutos+":"
				+(segundos<=9?"0":"")+segundos+":"
				+(centesimas_segundo<=9?"0":"")+centesimas_segundo;
		setTiempo(tiempo);
	}
	
	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}


	public Cronometro() {
		super();	
		cronometro = new Timer(10, accion);
	}
	public void startTime() {
		cronometro.start();
		try {
			int opcion;
			do {
				System.out.println("1. Pausar\n2. Reanudar\n3. Terminar actividad");
				opcion = Integer.parseInt(this.br.readLine());
				if (opcion == 1) {
					cronometro.stop();
					System.out.println("Han transcurrido: "+this.getTiempo());
				} if (opcion == 2) {
					cronometro.start();
				} if (opcion == 3) {
					cronometro.stop();
					System.out.println("El tiempo de la actividad es: " + this.getTiempo());
					opcion = 0;
				}
			} while (opcion != 0);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public int tiempoEnMins() {
		String[] separado = this.tiempo.split(":");
		int horas_a_mins = Integer.parseInt(separado[0])/60;
		int mins = Integer.parseInt(separado[1]);
		int segs_a_mins = Integer.parseInt(separado[2])*60;
		int todoMinutos = horas_a_mins + mins + segs_a_mins;
		return todoMinutos;
	}
}