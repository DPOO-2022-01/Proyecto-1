package Aplicaci�n;

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
				System.out.println("Para pausar oprima 1\nPara reanudar opimra 2\n");
				opcion = Integer.parseInt(this.br.readLine());
				if (opcion == 1) {
					cronometro.stop();
					System.out.println("Han transcurrido: "+this.getTiempo());
				} if (opcion == 2) {
					cronometro.start();
					this.cronometro.start();
				}
			} while (opcion != 0);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}