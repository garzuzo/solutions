import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class foosball {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Queue<Jugador> cola = new ArrayDeque<Jugador>();
		Queue<Jugador> equipoB = new ArrayDeque<Jugador>();
		Queue<Jugador> equipoW = new ArrayDeque<Jugador>();
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

		int totalJugadores = Integer.parseInt(lector.readLine());
		String[] nombres = lector.readLine().split(" ");
		boolean uno = false;
		for (int i = 0; i < totalJugadores; i++) {
			String nombre = nombres[i];
			Jugador nuevo = new Jugador(nombre, 0, i);
			if (i <= 3) {
				if (!uno) {
					equipoW.add(nuevo);
					uno = true;
				} else {
					equipoB.add(nuevo);
					uno = false;
				}
			} else {
				cola.add(nuevo);
			}
		}
		String casos = lector.readLine();

		for (int i = 0; i < casos.length(); i++) {

			String casoActual = casos.charAt(i) + "";

			if (casoActual.equals("W")) {
				Jugador actual = equipoW.peek();
				actual.setPuntaje(actual.getPuntaje() + 1);
				equipoW.poll();
				equipoW.add(actual);

				Jugador ofensivo = equipoB.poll();
				cola.add(equipoB.poll());

				equipoB.add(cola.poll());
				equipoB.add(ofensivo);
			} else {
				Jugador actual = equipoB.peek();
				actual.setPuntaje(actual.getPuntaje() + 1);
				equipoB.poll();
				equipoB.add(actual);
				Jugador ofensivo = equipoW.poll();
				cola.add(equipoW.poll());

				equipoW.add(cola.poll());
				equipoW.add(ofensivo);

			}

		}

		Jugador actual = equipoW.poll();
		Jugador siguiente = equipoW.poll();
		boolean diferenteCero = false;
		boolean diferenteCero1 = false;
		if (actual.getPuntaje() != 0) {
			diferenteCero = true;
		}
		if (siguiente.getPuntaje() != 0) {
			diferenteCero1 = true;
		}
		if (diferenteCero && diferenteCero1) {
			if (actual.getPosicion() < siguiente.getPosicion()) {

				System.out.println(actual.getNombre() + " " + siguiente.getNombre());

			} else {
				System.out.println(siguiente.getNombre() + " " + actual.getNombre());
			}
		} else if (!diferenteCero && diferenteCero1) {
			System.out.println(siguiente.getNombre());
		} else if (diferenteCero && !diferenteCero1) {
			System.out.println(actual.getNombre());
		}
		diferenteCero = false;
		diferenteCero1 = false;

		actual = equipoB.poll();
		siguiente = equipoB.poll();
		if (actual.getPuntaje() != 0) {
			diferenteCero = true;
		}
		if (siguiente.getPuntaje() != 0) {
			diferenteCero1 = true;
		}
		if (diferenteCero && diferenteCero1) {
			if (actual.getPosicion() < siguiente.getPosicion()) {

				System.out.println(actual.getNombre() + " " + siguiente.getNombre());

			} else {
				System.out.println(siguiente.getNombre() + " " + actual.getNombre());
			}
		} else if (!diferenteCero && diferenteCero1) {
			System.out.println(siguiente.getNombre());
		} else if (diferenteCero && !diferenteCero1) {
			System.out.println(actual.getNombre());
		}

	}

}

class Jugador {
	String nombre;
	int puntaje;
	int posicion;

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public Jugador(String nombre, int puntaje, int posicion) {
		this.nombre = nombre;
		this.puntaje = puntaje;
		this.posicion = posicion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

}